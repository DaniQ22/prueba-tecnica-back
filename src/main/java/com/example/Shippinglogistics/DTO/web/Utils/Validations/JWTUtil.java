package com.example.Shippinglogistics.DTO.web.Utils.Validations;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JWTUtil {

    private static String  SECRECT_KEY = "E_commerce_hdjjsbfjk";
    private static Algorithm algorithm = Algorithm.HMAC256(SECRECT_KEY);

    public String create(String username){
        return JWT.create()
                .withSubject(username)
                .withIssuer("Daniel-Q")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1)))
                .sign(algorithm);
    }


    //Verificar token

    public boolean isvalid(String token) {
        try {
            JWT.require(algorithm)
                    .build()
                    .verify(token);
            return true;
        }catch (JWTVerificationException e) {
            return false;
        }
    }

    // Obtener usuario quien crea el usuario
    public String username(String token){
        return JWT.require(algorithm)
                .build()
                .verify(token)
                .getSubject();
    }
}
