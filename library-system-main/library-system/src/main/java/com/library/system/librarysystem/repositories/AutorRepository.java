package com.library.system.librarysystem.repositories;

import com.library.system.librarysystem.models.Autor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  AutorRepository extends JpaRepository<Autor,Long> {
    public List<Autor> findByNombre(String name);
}
