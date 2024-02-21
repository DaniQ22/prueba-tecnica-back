package com.example.Shippinglogistics.Service;

import com.example.Shippinglogistics.DTO.RoleUser;
import com.example.Shippinglogistics.DTO.User;
import com.example.Shippinglogistics.DTO.web.Utils.Validations.UserValidation;
import com.example.Shippinglogistics.Repository.UserRepository;
import com.example.Shippinglogistics.Repository.UserRepositoryInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInt{

    private final UserRepositoryInt repositoryImp;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepositoryInt repositoryImp, PasswordEncoder passwordEncoder) {
        this.repositoryImp = repositoryImp;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ResponseEntity<?> getAll() {
        try {
            List<User> users = repositoryImp.getAll();
            if (!users.isEmpty()){
                return ResponseEntity.status(HttpStatus.OK).body(users);
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay usuarios");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hubo un error al buscar los usuarios");
        }
    }

    @Override
    public ResponseEntity<String> save(User user) {
        try {

            if(!UserValidation.validatedUser(user)){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario no valido");
            }

            if (!repositoryImp.existUsername(user.getUsername())){
                String encodePassword = passwordEncoder.encode(user.getPassword());
                user.setPassword(encodePassword);
                user.setLocked(false);
                user.setDisable(false);
                if(user.getUserRoles() == null || user.getUserRoles().isEmpty()){
                    RoleUser newRol = new RoleUser();
                    newRol.setUsername(user.getUsername());
                    newRol.setRoleUser("ADMIN");
                    newRol.setGrantedDate(LocalDateTime.now());
                    List<RoleUser> roleToSave = new ArrayList<>();
                    roleToSave.add(newRol);
                    user.setUserRoles(roleToSave);
                }
                repositoryImp.save(user);
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("El usuario ya está registrado, ingrese otro nombre de usuario");
            }
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear un usuario" + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<String> delete(String username) {
        try {
            if(repositoryImp.deleteUser(username)){
                return ResponseEntity.status(HttpStatus.OK).build();
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuenta el usuario");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el usuario");
        }
    }

    @Override
    public Optional<User> getUserById(String username) {
        return repositoryImp.getUserById(username);
    }



}
