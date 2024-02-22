package com.example.Shippinglogistics.DTO.web.Utils.Validations;

import com.example.Shippinglogistics.DTO.GroundShipping;
import com.example.Shippinglogistics.DTO.MaritimeShipping;

public class ShippingValidation {

    public static  boolean shippingValidated(GroundShipping groundShipping){
        if(groundShipping.getPrice() <= 0) {
            throw new MessageException("Ingrese un precio validi");
        }
        if (groundShipping.getDateDelivery().equals("")){
            throw new MessageException("Ingrese una decha de entrega");
        }
        if(groundShipping.getQuantityProduct()<=0){
            throw new MessageException("Debe ingresar una cantidad valida");
        }
        if(!isValidLicensePlate(groundShipping.getLicensePlate())){
            throw new MessageException("La placa de vehículo no cumple con el formato requerido Ej:(ABC123)");
        }

        return true;
    }

    public static  boolean regiteredShippingMaritime(MaritimeShipping maritimeShipping){
        if(maritimeShipping.getPrice() <= 0) {
            throw new MessageException("Ingrese un precio validi");
        }
        if (maritimeShipping.getDateDelivery().equals("")){
            throw new MessageException("Ingrese una decha de entrega");
        }
        if(maritimeShipping.getQuantityProduct()<=0){
            throw new MessageException("Debe ingresar una cantidad valida");
        }
        if(!isValidFleetNumber(maritimeShipping.getFleetNumber())){
            throw new MessageException("El numero de flota no cimeple con el formato requerido Ej:(ABC1234A)");
        }
        return true;

    }


    private static boolean isValidLicensePlate(String licensePlate) {
        // Expresión regular para validar el formato de la placa de vehículo
        String regex = "^[A-Z]{3}\\d{3}$"; // Tres letras seguidas de tres dígitos
        return licensePlate.matches(regex);
    }

    private static boolean isValidFleetNumber(String fleetNumber) {
        // Expresión regular para validar el formato de la placa de vehículo
        String regex = "^[A-Z]{3}\\d{4}[A-Z]$"; // Tres letras seguidas de cuatro dígitos y finalizando con una letra
        return fleetNumber.matches(regex);
    }
}
