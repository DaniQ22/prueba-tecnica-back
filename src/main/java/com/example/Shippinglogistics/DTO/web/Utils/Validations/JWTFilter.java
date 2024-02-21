package com.example.Shippinglogistics.DTO.web.Utils.Validations;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {

    private final JWTUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    @Autowired
    public JWTFilter(JWTUtil jwtUtil, UserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //1. Validamos que el sea un header authorization valido
        String headers = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (headers == null || headers.isEmpty() || !headers.startsWith("Bearer")){
            filterChain.doFilter(request, response);
            return;
        }

        //2. se valida que el JWT sea valido
        String token  = headers.split( " ")[1].trim();
        if (!jwtUtil.isvalid(token)){
            filterChain.doFilter(request, response);
            return;
        }

        //3. cargar  el usuario del userdetailservice
        String username = jwtUtil.username(token);
        User user = (User) userDetailsService.loadUserByUsername(username);

        //4. cargar al ususario con el contexto de seguridad
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                user.getUsername(), user.getPassword(), user.getAuthorities());

        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);








    }
}
