package com.library.system.librarysystem.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.system.librarysystem.dto.DTOUsuario;
import com.library.system.librarysystem.dto.NewUsuarioDTO;
import com.library.system.librarysystem.exepciones.ResourceNotFoundException;
import com.library.system.librarysystem.models.Usuario;
import com.library.system.librarysystem.repositories.UsuarioRepository;
import com.library.system.librarysystem.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    
    final ModelMapper modelMapper;
    final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(@Autowired UsuarioRepository repository, ModelMapper mapper){
        this.usuarioRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public DTOUsuario create(NewUsuarioDTO DTOusuario) {
        Usuario usuario = modelMapper.map(DTOusuario, Usuario.class);
        usuarioRepository.save(usuario);
        DTOUsuario usuarioDTOCreated = modelMapper.map(usuario, DTOUsuario.class); 
        return usuarioDTOCreated;
    }

    @Override
    @Transactional(readOnly = true)
    public DTOUsuario retrieve(Long id){
        Usuario usuario = usuarioRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Usuario not found"));
        return modelMapper.map(usuario, DTOUsuario.class);
    }

    @Override
    @Transactional
    public DTOUsuario update(DTOUsuario DTOusuario, Long id)  {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Usuario not found"));
        
        usuario.setId(id);
        usuario = modelMapper.map(DTOusuario, Usuario.class);
        usuarioRepository.save(usuario);       

        return modelMapper.map(usuario, DTOUsuario.class);
    }

    @Override
    @Transactional
    public void delete(Long id)  {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Exam not found"));        
        usuarioRepository.deleteById(usuario.getId());        
    }

    @Override
    @Transactional(readOnly = true)
    public List<DTOUsuario> list() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(usuario -> modelMapper.map(usuario, DTOUsuario.class))
            .collect(Collectors.toList());
    }
}
