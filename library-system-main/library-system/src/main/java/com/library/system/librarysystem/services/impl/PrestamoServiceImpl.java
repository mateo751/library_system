package com.library.system.librarysystem.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.library.system.librarysystem.dto.DTOPrestamo;
import com.library.system.librarysystem.dto.NewPrestamoDTO;
import com.library.system.librarysystem.repositories.PrestamoRepository;
import com.library.system.librarysystem.services.PrestamoService;

public class PrestamoServiceImpl implements PrestamoService{
    
    final ModelMapper modelMapper;
    final PrestamoRepository prestamoRepository;

    @Autowired
    public PrestamoServiceImpl(@Autowired PrestamoRepository repository, ModelMapper mapper){
        this.prestamoRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    public DTOPrestamo create(NewPrestamoDTO DTOPrestamo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DTOPrestamo retrieve(Long id) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DTOPrestamo update(DTOPrestamo DTOPrestamo, Long id) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {
        // TODO Auto-generated method stub
        
    }
}
