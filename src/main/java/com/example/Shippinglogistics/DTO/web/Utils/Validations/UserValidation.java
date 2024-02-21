package com.example.Shippinglogistics.DTO.web.Utils.Validations;

import com.example.Shippinglogistics.DTO.User;

import java.util.regex.Pattern;

public class UserValidation {

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    public static Boolean validatedUser(User user){

        if (user.getUsername().isEmpty()
                ||user.getUsername().length() < 10
                || user.getUsername().equals(user.getUsername().toLowerCase())) {
            throw new MessageException("Nombre de usuario no valido");

        }

        if (user.getEmail().isEmpty()
        ){
            throw new MessageException("Correo no valido");
        }

        if (user.getPassword().isEmpty()
                ||!user.getPassword().matches(".*[A-Z].*") ||  // Al menos una letra mayúscula
                !user.getPassword().matches(".*[a-z].*") ||  // Al menos una letra minúscula
                !user.getPassword().matches(".*[!@#$%^&*()-+].*")) {  // Al menos un carácter especial
            // La contraseña no cumple con los requisitos
            throw new MessageException("Contraseña no valida");
        }
        return true;
    }
}
