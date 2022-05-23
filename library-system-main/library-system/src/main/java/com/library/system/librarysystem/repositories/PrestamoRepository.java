package com.library.system.librarysystem.repositories;

import com.library.system.librarysystem.models.Prestamo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  PrestamoRepository extends JpaRepository<Prestamo,Long> {
    
}
