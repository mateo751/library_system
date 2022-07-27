package com.library.system.librarysystem.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.system.librarysystem.dto.DTOPrestamo;
import com.library.system.librarysystem.dto.NewPrestamoDTO;
import com.library.system.librarysystem.dto.PrestamoListDTO;
import com.library.system.librarysystem.exepciones.NoContentException;
import com.library.system.librarysystem.exepciones.ResourceNotFoundException;
import com.library.system.librarysystem.models.Libro;
import com.library.system.librarysystem.models.Prestamo;
import com.library.system.librarysystem.repositories.LibroRepository;
import com.library.system.librarysystem.repositories.PrestamoRepository;
import com.library.system.librarysystem.services.PrestamoService;

@Service
public class PrestamoServiceImpl implements PrestamoService{
    
    final ModelMapper modelMapper;
    final PrestamoRepository repository;
    final LibroRepository libroRepository;

   

    public PrestamoServiceImpl (PrestamoRepository p, LibroRepository lr, ModelMapper m)
    {
        this.modelMapper = m;
        this.repository = p;
        this.libroRepository = lr;
    }


    @Override
    @Transactional
    public DTOPrestamo create(Long idLibro, NewPrestamoDTO dtoPrestamo) {
        Libro libro= libroRepository.findById(idLibro)
            .orElseThrow(()-> new ResourceNotFoundException("Libro not found"));
        Prestamo prestamo = modelMapper.map(dtoPrestamo, Prestamo.class);    
        prestamo.setLibro(libro);
        repository.save(prestamo);
        return modelMapper.map(prestamo, DTOPrestamo.class); 
    }

    @Override
    @Transactional(readOnly=true)
    public DTOPrestamo retrieve(Long idLibro, Long id) {
        Libro libro = libroRepository.findById(idLibro)
            .orElseThrow(()-> new ResourceNotFoundException("Libro not found"));
            Prestamo prestamo = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Prestamo not found"));
            prestamo.setLibro(libro);
        return modelMapper.map(prestamo, DTOPrestamo.class);
    }

    @Override
    @Transactional
    public DTOPrestamo update(DTOPrestamo dtoPrestamo, Long idLibro, Long id) {
        Libro libro = libroRepository.findById(idLibro)
        .orElseThrow(()-> new ResourceNotFoundException("Libro not found"));
        Prestamo prestamo = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Prestamo not found"));
        prestamo = modelMapper.map(dtoPrestamo, Prestamo.class);
        prestamo.setLibro(libro);
        repository.save(prestamo);       
        return modelMapper.map(prestamo, DTOPrestamo.class);
    }


    @Override
    @Transactional
    public void delete(Long idLibro, Long id) {
        Libro libro = libroRepository.findById(idLibro)
        .orElseThrow(()-> new ResourceNotFoundException("Libro not found"));
        Prestamo prestamo = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Prestamo not found"));
        prestamo.setLibro(libro);
        repository.deleteById(prestamo.getId());  
    }

    @Override
    @Transactional(readOnly=true)
    public List<PrestamoListDTO> list(Long idLibro) {
        Libro libro = libroRepository.findById(idLibro)
            .orElseThrow(()-> new ResourceNotFoundException("Libro not found"));
        List<Prestamo> prestamos = repository.findByLibro(libro);
        if(prestamos.isEmpty()) throw new NoContentException("Prestamos is empty");
        //Lambda ->
        return prestamos.stream().map(l -> modelMapper.map(l, PrestamoListDTO.class) )
            .collect(Collectors.toList());
    }

    @Override
    public long count() {        
        return libroRepository.count();
    }

}
