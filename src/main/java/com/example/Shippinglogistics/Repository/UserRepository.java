package com.example.Shippinglogistics.Repository;

import com.example.Shippinglogistics.DTO.User;
import com.example.Shippinglogistics.entitys.Usuario;
import com.example.Shippinglogistics.entitys.crud.UsuarioCrudTRepository;
import com.example.Shippinglogistics.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements UserRepositoryInt {

    private final UsuarioMapper mapper;

    private final UsuarioCrudTRepository crudRepository;

    @Autowired
    public UserRepository(UsuarioMapper mapper, UsuarioCrudTRepository crudRepository) {
        this.mapper = mapper;
        this.crudRepository = crudRepository;
    }


    @Override
    public List<User> getAll() {
        List<Usuario> usuarios = crudRepository.findAll();
        return mapper.toUsers(usuarios);
    }

    @Override
    public User save(User user) {
        Usuario usuario = mapper.toUsuario(user);
        return mapper.toUser(crudRepository.save(usuario));
    }

    @Override
    public Boolean existUsername(String username) {
        return crudRepository.existsById(username);
    }

    @Override
    public Boolean isexistUser(String username) {
        return crudRepository.existsById(username);
    }

    @Override
    public Boolean deleteUser(String username) {
        Boolean user = isexistUser(username);
        if (user) {
            crudRepository.deleteById(username);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Optional<User> getUserById(String username) {
        Optional<Usuario> usuario = crudRepository.findById(username);
        return usuario.map(mapper::toUser);

    }

    @Override
    public int isExistEmail(String email) {
        return crudRepository.isExistEmail(email);

    }
}


