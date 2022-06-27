package com.library.system.librarysystem.repositories;

import com.library.system.librarysystem.models.Editorial;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  EditorialRepository extends JpaRepository<Editorial,Long> {
    public List<Editorial> findByNombreEdi(String name);
}
