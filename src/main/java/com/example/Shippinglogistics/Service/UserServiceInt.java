package com.example.Shippinglogistics.Service;

import com.example.Shippinglogistics.DTO.User;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface UserServiceInt {

    ResponseEntity<?> getAll();

    ResponseEntity<String> save(User user);

    ResponseEntity<String> delete(String username);

    Optional<User> getUserById(String username);
}
