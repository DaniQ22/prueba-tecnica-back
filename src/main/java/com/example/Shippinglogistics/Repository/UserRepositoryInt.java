package com.example.Shippinglogistics.Repository;

import com.example.Shippinglogistics.DTO.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryInt {

    List<User> getAll();

    User save(User user);

    Boolean existUsername(String username);

    Boolean isexistUser(String username);

    Boolean deleteUser(String username);

    int isExistEmail(String email);


    Optional<User> getUserById(String username);

}
