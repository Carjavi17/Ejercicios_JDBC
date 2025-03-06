package com.egg.biblioteca.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.egg.biblioteca.Entidades.Usuario;
import com.egg.biblioteca.Excepciones.MiExcepcion;
import com.egg.biblioteca.Respositorios.UsuarioRepositorio;

@Service
public class UsuarioServicio implements UserDetailsService{

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    private void validar(String nombre, String email, String password, String password2) throws MiExcepcion {


        if (nombre.isEmpty() || nombre == null) {
            throw new MiExcepcion("el nombre no puede ser nulo o estar vacío");
        }
        if (email.isEmpty() || email == null) {
            throw new MiExcepcion("el email no puede ser nulo o estar vacío");
        }
        if (password.isEmpty() || password == null || password.length() <= 5) {
            throw new MiExcepcion("La contraseña no puede estar vacía, y debe tener más de 5 dígitos");
        }
        if (!password.equals(password2)) {
            throw new MiExcepcion("Las contraseñas ingresadas deben ser iguales");
        }

        Usuario usuario = new Usuario();

        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setPassword(password);
        usuario.setRol("ROLE_USER");

        usuarioRepositorio.save(usuario);

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        throw new UnsupportedOperationException("Unimplemented method 'loadUserByUsername'");
    }
    
}
