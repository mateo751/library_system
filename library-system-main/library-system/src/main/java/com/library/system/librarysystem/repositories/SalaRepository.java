package com.library.system.librarysystem.repositories;

import com.library.system.librarysystem.models.Sala;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  SalaRepository extends JpaRepository<Sala,Long> {
    
}