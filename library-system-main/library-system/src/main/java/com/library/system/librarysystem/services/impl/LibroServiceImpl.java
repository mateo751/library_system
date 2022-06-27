package com.library.system.librarysystem.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.system.librarysystem.dto.DTOLibro;
import com.library.system.librarysystem.dto.NewLibroDTO;
import com.library.system.librarysystem.exepciones.ResourceNotFoundException;
import com.library.system.librarysystem.models.Libro;
import com.library.system.librarysystem.repositories.LibroRepository;
import com.library.system.librarysystem.services.LibroService;

@Service
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
    @Transactional(readOnly = true)
    public DTOLibro retrieve(Long id){
        Libro libro = libroRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Libro not found"));
        return modelMapper.map(libro, DTOLibro.class);
    }

    @Override
    @Transactional
    public DTOLibro update(DTOLibro DTOlibro, Long id){
        Libro libro = libroRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Exam not found"));

        libro.setId(id);
        libro = modelMapper.map(DTOlibro, Libro.class);
        libroRepository.save(libro);       

        return modelMapper.map(libro, DTOLibro.class);
    }

    @Override
    @Transactional
    public void delete(Long id){
        Libro libro = libroRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Exam not found"));        
        libroRepository.deleteById(libro.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<DTOLibro> list() {
        List<Libro> libros = libroRepository.findAll();
        return libros.stream().map(libro -> modelMapper.map(libro, DTOLibro.class))
            .collect(Collectors.toList());
    }
}
