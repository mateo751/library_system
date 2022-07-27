package com.library.system.librarysystem.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.library.system.librarysystem.dto.DTOUsuario;
import com.library.system.librarysystem.dto.UsuarioListDTO;
import com.library.system.librarysystem.dto.NewUsuarioDTO;
import com.library.system.librarysystem.exepciones.NoContentException;
import com.library.system.librarysystem.exepciones.ResourceNotFoundException;
import com.library.system.librarysystem.models.Usuario;
import com.library.system.librarysystem.repositories.UsuarioRepository;
import com.library.system.librarysystem.services.UsuarioService;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UsuarioServiceImpl implements UsuarioService {
    
    final ModelMapper modelMapper;
    final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository repository, ModelMapper mapper){
        this.usuarioRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public DTOUsuario create(NewUsuarioDTO dtoUsuario) {
        Usuario usuario = modelMapper.map(dtoUsuario, Usuario.class);
        usuarioRepository.save(usuario);
        return modelMapper.map(usuario, DTOUsuario.class); 
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
    public DTOUsuario update(DTOUsuario dtoUsuario, Long id)  {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Usuario not found"));
        
        Usuario usuarioUpdated = modelMapper.map(dtoUsuario,Usuario.class);
        usuarioUpdated.setCreatedBy(usuario.getCreatedBy());
        usuarioUpdated.setCreatedDate(usuario.getCreatedDate());
        usuarioRepository.save(usuarioUpdated);  
        return modelMapper.map( usuarioUpdated, DTOUsuario.class);
    }

    @Override
    @Transactional
    public void delete(Long id)  {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Usuario not found"));        
        usuarioRepository.deleteById(usuario.getId());        
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioListDTO> list(int page, int size, String sort) {
        Pageable pageable = sort == null || sort.isEmpty() ? 
                    PageRequest.of(page, size) 
                :   PageRequest.of(page, size,  Sort.by(sort));

        Page<Usuario> usuarios = usuarioRepository.findAll(pageable);
        if(usuarios.isEmpty()) throw new NoContentException("Usuarios is empty");
        return usuarios.stream().map(usuario -> modelMapper.map(usuarios, UsuarioListDTO.class))
            .collect(Collectors.toList()); 
    }

    @Override
    public long count() {        
        return usuarioRepository.count();
    }
    
}
