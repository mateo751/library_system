package com.library.system.librarysystem.repositories;

<<<<<<< Updated upstream
import com.library.system.librarysystem.models.Estudiante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  EstudianteRepository extends JpaRepository<Estudiante,Long> {
    
}
=======
import org.springframework.data.jpa.repository.JpaRepository;

import com.library.system.librarysystem.models.Estudiante;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante,Long> {
    
}
>>>>>>> Stashed changes
