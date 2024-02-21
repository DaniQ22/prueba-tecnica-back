package com.example.Shippinglogistics.DTO.web.Utils.Validations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class CorsConfig {

    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration =  new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200")); //Origenes que seran permitidos para consumir la api
        configuration.setAllowedMethods(Arrays.asList("GET", "PUT", "POST", "DELETE"));//Que metodo se permiten consumir
        configuration.setAllowedHeaders(Arrays.asList("*")); //Permitir todos los tipos de encabezados llegan
        configuration.addExposedHeader("*"); //Exponer todos los encabezados para dar acceso al token
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;

    }

}
