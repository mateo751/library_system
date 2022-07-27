package com.library.system.librarysystem.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.system.librarysystem.dto.DTOLibro;
import com.library.system.librarysystem.dto.LibroAutorDTO;
import com.library.system.librarysystem.dto.LibroListDTO;
import com.library.system.librarysystem.dto.NewLibroDTO;
import com.library.system.librarysystem.exepciones.NoContentException;
import com.library.system.librarysystem.exepciones.ResourceNotFoundException;
import com.library.system.librarysystem.models.Autor;
import com.library.system.librarysystem.models.Libro;
import com.library.system.librarysystem.repositories.AutorRepository;
import com.library.system.librarysystem.repositories.LibroRepository;
import com.library.system.librarysystem.services.LibroService;

@Service
public class LibroServiceImpl implements LibroService {
    final ModelMapper modelMapper;
    final LibroRepository repository;
    final AutorRepository autorRepository;

    public LibroServiceImpl (LibroRepository l, AutorRepository ar, ModelMapper m)
    {
        this.modelMapper = m;
        this.repository = l;
        this.autorRepository = ar;
    }


    @Override
    @Transactional
    public DTOLibro create(Long idAutor, NewLibroDTO dtoLibro) {
        Autor autor= autorRepository.findById(idAutor)
            .orElseThrow(()-> new ResourceNotFoundException("Not found"));
        Libro libro = modelMapper.map(dtoLibro, Libro.class);    
        libro.setAutor(autor);
        repository.save(libro);
        return modelMapper.map(libro, DTOLibro.class); 
    }

    @Override
    @Transactional(readOnly=true)
    public LibroAutorDTO retrieve(Long idAutor, Long id) {
        Autor autor = autorRepository.findById(idAutor)
            .orElseThrow(()-> new ResourceNotFoundException("Autor not found"));
            Libro libro = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Libro not found"));
            libro.setAutor(autor);
        return modelMapper.map(libro, LibroAutorDTO.class);
    }

    @Override
    @Transactional
    public LibroAutorDTO update(DTOLibro dtoLibro, Long idAutor, Long id) {
        Autor autor = autorRepository.findById(idAutor)
        .orElseThrow(()-> new ResourceNotFoundException("Autor not found"));
        Libro libro = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Libro not found"));
        libro = modelMapper.map(dtoLibro, Libro.class);
        libro.setAutor(autor);
        repository.save(libro);       
        return modelMapper.map(libro, LibroAutorDTO.class);
    }


    @Override
    @Transactional
    public void delete(Long idAutor, Long id) {
        Autor autor = autorRepository.findById(idAutor)
        .orElseThrow(()-> new ResourceNotFoundException("Autor not found"));
        Libro libro = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Libro not found"));
        libro.setAutor(autor);
        repository.deleteById(libro.getId());  
    }

    @Override
    @Transactional(readOnly=true)
    public List<LibroListDTO> list(Long idAutor, int page, int size, String sort) {
        Pageable pageable = sort == null || sort.isEmpty() ? 
                    PageRequest.of(page, size) 
                :   PageRequest.of(page, size,  Sort.by(sort));

        Page <Autor> autor = autorRepository.findAll(pageable);
        if(autor.isEmpty()) throw new NoContentException("Autor is empty");
        Page <Libro> libros = repository.findAll(pageable);
        if(libros.isEmpty()) throw new NoContentException("Libros is empty");
        //Lambda ->
        return libros.stream().map(l -> modelMapper.map(l, LibroListDTO.class) )
            .collect(Collectors.toList());
    }

    @Override
    public long count() {        
        return autorRepository.count();
    }

}
