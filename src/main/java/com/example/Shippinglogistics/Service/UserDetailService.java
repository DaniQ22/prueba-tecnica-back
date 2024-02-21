package com.example.Shippinglogistics.Service;

import com.example.Shippinglogistics.DTO.RoleUser;
import com.example.Shippinglogistics.DTO.User;
import com.example.Shippinglogistics.entitys.crud.UsuarioCrudTRepository;
import com.example.Shippinglogistics.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailService implements UserDetailsService {

    private final UsuarioMapper mapper;

    private final UsuarioCrudTRepository crudRepository;

    @Autowired
    public UserDetailService(UsuarioMapper mapper, UsuarioCrudTRepository crudRepository) {
        this.mapper = mapper;
        this.crudRepository = crudRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = mapper.toUser(crudRepository.findById(username).orElseThrow(() ->
                new UsernameNotFoundException("User" + username + "no found")));

        System.out.println(user);

        String[] roles = user.getUserRoles().stream().map(RoleUser::getRoleUser).toArray(String[]::new);


        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(this.grantedAuthorityList(roles))
                .accountLocked(user.getLocked())
                .disabled(user.getDisable())
                .build();
    }

    String[] getAuthorities(String role) { //Aqui estamos asignando un permiso puntual para que cualquier  rol pueda acceder
        if ("ADMIN".equals(role) || "CUSTOMER".equals(role)) {
            return new String[]{"unitary_permit"};
        }
        return new String[]{};
    }

    private List<GrantedAuthority> grantedAuthorityList(String[] roles) { //Aqui estamos asignado los roles que administrara spring.
        List<GrantedAuthority> authorities = new ArrayList<>(roles.length);
        for (String rol : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + rol));

            for (String authority : this.getAuthorities(rol)) {
                authorities.add(new SimpleGrantedAuthority(authority));
            }
        }

        return authorities;

    }

}
