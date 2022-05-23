package com.library.system.librarysystem.repositories;

import com.library.system.librarysystem.models.Libro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  LibroRepository extends JpaRepository<Libro,Long> {
    
}
