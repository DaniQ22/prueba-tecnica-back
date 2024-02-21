package com.example.Shippinglogistics.Service;

import com.example.Shippinglogistics.DTO.Customer;
import com.example.Shippinglogistics.DTO.GroundShipping;
import com.example.Shippinglogistics.DTO.web.Utils.Validations.ShippingValidation;
import com.example.Shippinglogistics.Repository.CustomerRepositoryInt;
import com.example.Shippinglogistics.Repository.GroundShippingRepoInt;
import com.example.Shippinglogistics.Repository.ProductRepositoryInt;
import com.example.Shippinglogistics.Repository.WarehouseRepositortyInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class GroundShippingServ implements GrondShippingServiceInt{
    private  final GroundShippingRepoInt repository;
    private final CustomerRepositoryInt repositoryCustomer;
    private final ProductRepositoryInt productRepositoryInt;

    private final WarehouseRepositortyInt warehouseRepositortyInt;

    @Autowired
    public GroundShippingServ(GroundShippingRepoInt repository, CustomerRepositoryInt repositoryCustomer, ProductRepositoryInt productRepositoryInt, WarehouseRepositortyInt warehouseRepositortyInt) {
        this.repository = repository;
        this.repositoryCustomer = repositoryCustomer;
        this.productRepositoryInt = productRepositoryInt;
        this.warehouseRepositortyInt = warehouseRepositortyInt;
    }


    @Override
    public ResponseEntity<String> save(GroundShipping groundShipping) {
        try {
            //Primero hacemos validacion de los datos de
            if(!ShippingValidation.shippingValidated(groundShipping)){
                return ResponseEntity.badRequest().body("Error en la validacion de los datos");
            }
            boolean noExistProduct = productRepositoryInt.exiistProduct(groundShipping.getTypeProduct());
            if(!noExistProduct){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El producto no existe");
            }
            boolean noExistWarehouse = warehouseRepositortyInt.existWarehouse(groundShipping.getDeliveryWarehouse());
            if(!noExistWarehouse) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La bodega de entrega no existe");

            }
            //Almacenamos el numero de guia
            String guideNumber = generateGuideNumber();
            groundShipping.setGuideNumber(guideNumber);
            // Registra el cliente asociado con el envío
            Customer customer = groundShipping.getCustomer();
            // Comprueba si el cliente ya existe en la base de datos antes de intentar guardarlo
            if (!repositoryCustomer.existById(customer.getCustomerId())) {
                repositoryCustomer.save(customer);
            }
            groundShipping.setIdCustomer(groundShipping.getCustomer().getCustomerId());

            // Registra la fecha en que se crea un envío
            LocalDateTime dateRegistry = LocalDateTime.now();
            groundShipping.setDateRegistry(dateRegistry);

            // Calcula el descuento y establece el precio total del envío
            int quantityProduct = groundShipping.getQuantityProduct();
            double price = groundShipping.getPrice();
            double discount = (quantityProduct > 10) ? (price * 0.5) : 0;
            double priceTotal = price - discount;
            groundShipping.setDiscount(discount);
            groundShipping.setPriceTotal(priceTotal);

            // Guarda el envío terrestre
            repository.save(groundShipping);

            return ResponseEntity.status(HttpStatus.CREATED).body("Envío realizado correctamente");
        } catch (DataAccessException e) {
            // Manejar excaepciones de acceso a datos
            return ResponseEntity.internalServerError().body("Error en el acceso a datos: " + e.getMessage());
        } catch (Exception e) {
            // Manejar otras excepciones
            return ResponseEntity.internalServerError().body("No se pudo realizar el envío: " + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<List<GroundShipping>> getAll() {
        try {
            List<GroundShipping> groundShippings = repository.getALL();
            if (!groundShippings.isEmpty()){
                return ResponseEntity.ok().body(groundShippings);
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<String> delete(String guideNumber) {
        try {
            boolean noExistGroundNumber  = repository.existGroundShipping(guideNumber);
            if(!noExistGroundNumber) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error este envio no existe");
            }else {
                repository.delete(guideNumber);
                return ResponseEntity.ok().body("Envio eliminado correctamente");
            }
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Hubo un error al eliminar el envio");
        }
    }

    @Override
    public ResponseEntity<String> update(GroundShipping groundShipping) {
        try {
            //Primero buscamos si existe el envio para actualizar
            boolean existShipping= repository.existGroundShipping(groundShipping.getGuideNumber());
            if (existShipping){
                repository.save(groundShipping);
                return ResponseEntity.status(HttpStatus.OK).body("El envio se ha actulizado");
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El envio no existe");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El envio no existe");

        }
    }

    //Metodo para crear el numero de guia
    private String generateGuideNumber() {
        // Generaramos un número de guía único alfanumérico de 10 dígitos usando UUID
        String guideNumber = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);
        return guideNumber.toUpperCase(); // Convertir a mayúsculas
    }

}
