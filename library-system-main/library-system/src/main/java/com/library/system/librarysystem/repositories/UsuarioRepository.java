package com.library.system.librarysystem.repositories;

import com.library.system.librarysystem.models.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UsuarioRepository extends JpaRepository<Usuario,Long> {
    
}
