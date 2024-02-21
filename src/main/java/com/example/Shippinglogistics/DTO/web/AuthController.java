package com.example.Shippinglogistics.DTO.web;

import com.example.Shippinglogistics.DTO.Login;
import com.example.Shippinglogistics.DTO.web.Utils.Validations.JWTUtil;
import com.example.Shippinglogistics.Service.UserServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JWTUtil jwtUtil;

    private final UserServiceInt serviceInt;

    private final PasswordEncoder passwordEncoder;


    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JWTUtil jwtUtil, UserServiceInt serviceInt, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.serviceInt = serviceInt;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login log) {
        Optional<com.example.Shippinglogistics.DTO.User> optionalUser = serviceInt.getUserById(log.getUsername());

        // Verificar si el usuario existe
        if (optionalUser.isPresent()) {
           com.example.Shippinglogistics.DTO.User user = optionalUser.get();

            // Verificar si el usuario está deshabilitado
            if (!user.getDisable()) {
                // Autenticación de usuario
                UsernamePasswordAuthenticationToken loginToken = new UsernamePasswordAuthenticationToken(log.getUsername(), log.getPassword());
                Authentication authentication;
                try {
                    authentication = this.authenticationManager.authenticate(loginToken);
                } catch (AuthenticationException e) {
                    // Error de autenticación: credenciales incorrectas
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
                }

                // Usuario autenticado correctamente
                User authenticatedUser = (User) authentication.getPrincipal();
                String jwt = jwtUtil.create(log.getUsername());
                return ResponseEntity.status(HttpStatus.OK)
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + jwt)
                        .body(authenticatedUser);
            } else {
                // Usuario deshabilitado
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("No estás autorizado para ingresar al sistema. Una vez tu cuenta haya sido habilitada, te enviaremos un correo.");
            }
        } else {
            // Usuario no encontrado en la base de datos
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no registrado o credenciales invalidas");
        }
    }



}
