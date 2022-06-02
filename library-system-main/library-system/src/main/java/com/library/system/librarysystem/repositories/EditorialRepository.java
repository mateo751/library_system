package com.library.system.librarysystem.repositories;

<<<<<<< Updated upstream
import com.library.system.librarysystem.models.Editorial;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  EditorialRepository extends JpaRepository<Editorial,Long> {
=======
import org.springframework.data.jpa.repository.JpaRepository;

import com.library.system.librarysystem.models.Editorial;

import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial,Long> {
>>>>>>> Stashed changes
    
}
