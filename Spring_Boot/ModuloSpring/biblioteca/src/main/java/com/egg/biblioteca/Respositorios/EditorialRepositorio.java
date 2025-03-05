package com.egg.biblioteca.Respositorios;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egg.biblioteca.Entidades.Editorial;

@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial, UUID>{
    
} 
