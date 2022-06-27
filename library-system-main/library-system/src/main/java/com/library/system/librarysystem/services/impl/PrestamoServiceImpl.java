package com.library.system.librarysystem.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.system.librarysystem.dto.DTOPrestamo;
import com.library.system.librarysystem.dto.NewPrestamoDTO;
import com.library.system.librarysystem.exepciones.ResourceNotFoundException;
import com.library.system.librarysystem.models.Prestamo;
import com.library.system.librarysystem.repositories.PrestamoRepository;
import com.library.system.librarysystem.services.PrestamoService;

@Service
public class PrestamoServiceImpl implements PrestamoService{
    
    final ModelMapper modelMapper;
    final PrestamoRepository prestamoRepository;

    @Autowired
    public PrestamoServiceImpl(@Autowired PrestamoRepository repository, ModelMapper mapper){
        this.prestamoRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public DTOPrestamo create(NewPrestamoDTO DTOprestamo) {
        Prestamo prestamo = modelMapper.map(DTOprestamo, Prestamo.class);
        prestamoRepository.save(prestamo);
        DTOPrestamo prestamoDTOCreated = modelMapper.map(prestamo, DTOPrestamo.class); 
        return prestamoDTOCreated;
    }

    @Override
    @Transactional(readOnly = true)
    public DTOPrestamo retrieve(Long id){
        Prestamo prestamo = prestamoRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Prestamo not found"));
        return modelMapper.map(prestamo, DTOPrestamo.class);
    }

    @Override
    @Transactional
    public DTOPrestamo update(DTOPrestamo DTOprestamo, Long id)  {
        Prestamo prestamo = prestamoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Prestamo not found"));
        
        prestamo.setId(id);
        prestamo = modelMapper.map(DTOprestamo, Prestamo.class);
        prestamoRepository.save(prestamo);       

        return modelMapper.map(prestamo, DTOPrestamo.class);
    }

    @Override
    @Transactional
    public void delete(Long id)  {
        Prestamo prestamo = prestamoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Exam not found"));        
        prestamoRepository.deleteById(prestamo.getId());        
    }

    @Override
    @Transactional(readOnly = true)
    public List<DTOPrestamo> list() {
        List<Prestamo> prestamos = prestamoRepository.findAll();
        return prestamos.stream().map(prestamo -> modelMapper.map(prestamo, DTOPrestamo.class))
            .collect(Collectors.toList());
    }
}
