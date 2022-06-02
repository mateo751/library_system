package com.library.system.librarysystem.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.library.system.librarysystem.dto.DTOLibro;
import com.library.system.librarysystem.dto.NewLibroDTO;
import com.library.system.librarysystem.models.Libro;
import com.library.system.librarysystem.repositories.LibroRepository;
import com.library.system.librarysystem.services.LibroService;

public class LibroServiceImpl implements LibroService {
    final ModelMapper modelMapper;
    final LibroRepository libroRepository;

    @Autowired
    public LibroServiceImpl(@Autowired LibroRepository repository, ModelMapper mapper){
        this.libroRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    public DTOLibro create(NewLibroDTO DTOLibro) {
        Libro libro = modelMapper.map(DTOLibro, Libro.class);
        libroRepository.save(libro);
        DTOLibro libroDTOCreated = modelMapper.map(libro, DTOLibro.class); 
        return libroDTOCreated;
    }

    @Override
    public DTOLibro retrieve(Long id) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DTOLibro update(DTOLibro DTOLibro, Long id) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {
        // TODO Auto-generated method stub
        
    }
}
