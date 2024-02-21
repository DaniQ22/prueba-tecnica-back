package com.example.Shippinglogistics.Service;

import com.example.Shippinglogistics.DTO.Customer;
import com.example.Shippinglogistics.DTO.MaritimeShipping;
import com.example.Shippinglogistics.DTO.web.Utils.Validations.ShippingValidation;
import com.example.Shippinglogistics.Repository.CustomerRepositoryInt;
import com.example.Shippinglogistics.Repository.MaritimeShippingRepInt;
import com.example.Shippinglogistics.Repository.PortRespositoryInt;
import com.example.Shippinglogistics.Repository.ProductRepositoryInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class MaritimeShippingServ implements MaritimeShippingServInt{
    private final MaritimeShippingRepInt repository;
    private final CustomerRepositoryInt repositoryIntCustomer;

    private final ProductRepositoryInt productRepositoryInt;

    private final PortRespositoryInt portRespositoryInt;

    @Autowired
    public MaritimeShippingServ(MaritimeShippingRepInt repository, CustomerRepositoryInt repositoryIntCustomer, ProductRepositoryInt productRepositoryInt, PortRespositoryInt portRespositoryInt) {
        this.repository = repository;
        this.repositoryIntCustomer = repositoryIntCustomer;
        this.productRepositoryInt = productRepositoryInt;
        this.portRespositoryInt = portRespositoryInt;
    }

    @Override
    public ResponseEntity<String> save(MaritimeShipping maritimeShipping) {
        try {
            //Primero hacemos validacion de los datos de
            if(!ShippingValidation.regiteredShippingMaritime(maritimeShipping)){
                return ResponseEntity.badRequest().body("Error en la validacion de los datos");
            }
            //Validmos que el producto si exista
            boolean noExistProduct = productRepositoryInt.exiistProduct(maritimeShipping.getTypeProduct());
            if(!noExistProduct){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El producto no existe");
            }
            //Comprobamos si el puert existe
            boolean noExistPort = portRespositoryInt.existPort(maritimeShipping.getPortDelivery());
            if(!noExistPort) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El puerto no existe");
            }

            //Almacenamos el numero de guia
            String guideNumber = generateGuideNumber();
            maritimeShipping.setGuideNumber(guideNumber);
            // Registra el cliente asociado con el envío
            Customer customer = maritimeShipping.getCustomer();
            // Comprueba si el cliente ya existe en la base de datos antes de intentar guardarlo
            if (!repositoryIntCustomer.existById(customer.getCustomerId())) {
                repositoryIntCustomer.save(customer);
            }
            maritimeShipping.setIdCustomer(maritimeShipping.getCustomer().getCustomerId());

            // Registra la fecha en que se crea un envío
            LocalDateTime dateRegistry = LocalDateTime.now();
            maritimeShipping.setDateRegistry(dateRegistry);

            // Calcula el descuento y establece el precio total del envío
            int quantityProduct = maritimeShipping.getQuantityProduct();
            double price = maritimeShipping.getPrice();
            double discount = (quantityProduct > 10) ? (price * 0.3) : 0;
            double priceTotal = price - discount;
            maritimeShipping.setDiscount(discount);
            maritimeShipping.setPriceTotal(priceTotal);


            repository.save(maritimeShipping);
            return ResponseEntity.status(HttpStatus.CREATED).body("Envio maritimo realizado correctamente");
        }catch (DataAccessException e) {
            // Manejar excaepciones de acceso a datos
            return ResponseEntity.internalServerError().body("Error en el acceso a datos: " + e.getMessage());
        } catch (Exception e) {
            // Manejar otras excepciones
            return ResponseEntity.internalServerError().body("No se pudo realizar el envío: " + e.getMessage());
        }

    }

    @Override
    public ResponseEntity<?> getAll() {
        try {
            List<MaritimeShipping> maritimeShippings  = repository.getALL();
            if(!maritimeShippings.isEmpty()){
                return ResponseEntity.ok().body(maritimeShippings);
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay envios exsitentes");
            }
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("No se pudo realizar el envío: " + e.getMessage());

        }
    }

    @Override
    public ResponseEntity<String> delelete(String numberGuide) {
        try {

            boolean noExistMaritimeShipping = repository.existMaritimeShipping(numberGuide);
            if (!noExistMaritimeShipping){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existen envios con ese numero de guia");
            }
            repository.delete(numberGuide);
            return ResponseEntity.ok().body("El envio se ha eliminado");
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al eliminar");
        }
    }

    @Override
    public ResponseEntity<String> update(MaritimeShipping maritimeShipping) {
        try {
            boolean existShipping = repository.existMaritimeShipping(maritimeShipping.getGuideNumber());
            if(existShipping){
                repository.save(maritimeShipping);
                return  ResponseEntity.status(HttpStatus.OK).body("El envio se ha actualizado");
            }else {
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    //Metodo para crear el numero de guia
    private String generateGuideNumber() {
        // Generaramos un número de guía único alfanumérico de 10 dígitos usando UUID
        String guideNumber = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);
        return guideNumber.toUpperCase(); // Convertir a mayúsculas
    }
}
