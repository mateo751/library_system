package com.library.system.librarysystem.services.impl;

import com.library.system.librarysystem.dto.DTOEditorial;
import com.library.system.librarysystem.dto.NewEditorialDTO;
import com.library.system.librarysystem.exepciones.ResourceNotFoundException;
import com.library.system.librarysystem.models.Editorial;
import com.library.system.librarysystem.repositories.EditorialRepository;
import com.library.system.librarysystem.services.EditorialService;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EditorialServiceImpl implements EditorialService{
    final ModelMapper modelMapper;
    final EditorialRepository editorialRepository;

    @Autowired
    public EditorialServiceImpl(@Autowired EditorialRepository repository, ModelMapper mapper){
        this.editorialRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public DTOEditorial create(NewEditorialDTO DTOeditorial) {
        Editorial editorial = modelMapper.map(DTOeditorial, Editorial.class);
        editorialRepository.save(editorial);
        DTOEditorial editorialDTOCreated = modelMapper.map(editorial, DTOEditorial.class); 
        return editorialDTOCreated;
    }

    @Override
    @Transactional(readOnly = true)
    public DTOEditorial retrieve(Long id){
        Editorial editorial = editorialRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Editorial not found"));
        return modelMapper.map(editorial, DTOEditorial.class);
    }

    @Override
    @Transactional
    public DTOEditorial update(DTOEditorial DTOeditorial, Long id)  {
        Editorial editorial = editorialRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Editorial not found"));
        
        editorial.setId(id);
        editorial = modelMapper.map(DTOeditorial, Editorial.class);
        editorialRepository.save(editorial);       

        return modelMapper.map(editorial, DTOEditorial.class);
    }

    @Override
    @Transactional
    public void delete(Long id)  {
        Editorial editorial = editorialRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Exam not found"));        
        editorialRepository.deleteById(editorial.getId());        
    }

    @Override
    @Transactional(readOnly = true)
    public List<DTOEditorial> list() {
        List<Editorial> editoriales = editorialRepository.findAll();
        return editoriales.stream().map(editorial -> modelMapper.map(editorial, DTOEditorial.class))
            .collect(Collectors.toList());
    }

}
