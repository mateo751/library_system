package com.library.system.librarysystem.repositories;

import com.library.system.librarysystem.models.Login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  LoginRepository extends JpaRepository<Login,Long> {
    
}
