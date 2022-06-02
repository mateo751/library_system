package com.library.system.librarysystem.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.library.system.librarysystem.dto.DTOUsuario;
import com.library.system.librarysystem.dto.NewUsuarioDTO;
import com.library.system.librarysystem.repositories.UsuarioRepository;
import com.library.system.librarysystem.services.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {
    
    final ModelMapper modelMapper;
    final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(@Autowired UsuarioRepository repository, ModelMapper mapper){
        this.usuarioRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    public DTOUsuario create(NewUsuarioDTO DTOUsuario) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DTOUsuario retrieve(Long id) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DTOUsuario update(DTOUsuario DTOUsuario, Long id) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {
        // TODO Auto-generated method stub
        
    }
}
