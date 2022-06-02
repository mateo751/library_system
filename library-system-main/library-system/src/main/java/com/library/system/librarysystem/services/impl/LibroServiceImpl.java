package com.library.system.librarysystem.services.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public DTOLibro create(NewLibroDTO DTOLibro) {
        Libro libro = modelMapper.map(DTOLibro, Libro.class);
        libroRepository.save(libro);
        DTOLibro libroDTOCreated = modelMapper.map(libro, DTOLibro.class); 
        return libroDTOCreated;
    }

    @Override
    @Transactional
    public DTOLibro retrieve(Long id) throws Exception {
        Optional<Libro> libro = libroRepository.findById(id);
        if(libro.isPresent()){
            throw new Exception("Exan not found");
        }
        //.orElseThrow(()-> new Exception("Exam not found"));
        return modelMapper.map(libro.get(), DTOLibro.class);
    }

    @Override
    @Transactional
    public DTOLibro update(DTOLibro DTOlibro, Long id) throws Exception {
        Libro libro = libroRepository.findById(id)
        .orElseThrow(()-> new Exception("Exam not found"));

        libro.setId(id);
        libro = modelMapper.map(DTOlibro, Libro.class);
        libroRepository.save(libro);       

        return modelMapper.map(libro, DTOLibro.class);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        Libro libro = libroRepository.findById(id)
        .orElseThrow(()-> new Exception("Exam not found"));        
        libroRepository.deleteById(libro.getId());
    }
}
