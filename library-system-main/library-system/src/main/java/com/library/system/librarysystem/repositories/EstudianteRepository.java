package com.library.system.librarysystem.repositories;

import com.library.system.librarysystem.models.Estudiante;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  EstudianteRepository extends JpaRepository<Estudiante,Long> {
    public List<Estudiante> findByNombre(String name); 
}