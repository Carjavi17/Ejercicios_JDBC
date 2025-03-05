package com.egg.biblioteca.Respositorios;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.egg.biblioteca.Entidades.Autor;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, UUID> {

    Optional<Autor> findByNombre(String nombre);
    
}


