package com.library.system.librarysystem.services.impl;

import com.library.system.librarysystem.dto.DTOEditorial;
import com.library.system.librarysystem.dto.NewEditorialDTO;
import com.library.system.librarysystem.models.Editorial;
import com.library.system.librarysystem.repositories.EditorialRepository;
import com.library.system.librarysystem.services.EditorialService;

import java.util.Optional;

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
    public DTOEditorial create(NewEditorialDTO DTOEditorial) {
        Editorial editorial = modelMapper.map(DTOEditorial, Editorial.class);
        editorialRepository.save(editorial);
        DTOEditorial editorialDTOCreated = modelMapper.map(editorial, DTOEditorial.class); 
        return editorialDTOCreated;
    }

    @Override
    @Transactional(readOnly = true)
    public DTOEditorial retrieve(Long id) throws Exception {
        Optional<Editorial> editorial = editorialRepository.findById(id);
        if(editorial.isPresent()){
            throw new Exception("Exan not found");
        }
        //.orElseThrow(()-> new Exception("Exam not found"));
        return modelMapper.map(editorial.get(), DTOEditorial.class);
    }

    @Override
    @Transactional
    public DTOEditorial update(DTOEditorial DTOeditorial, Long id) throws Exception {
        Editorial editorial = editorialRepository.findById(id)
                .orElseThrow(()-> new Exception("Exam not found"));
        
        editorial.setId(id);
        editorial = modelMapper.map(DTOeditorial, Editorial.class);
        editorialRepository.save(editorial);       

        return modelMapper.map(editorial, DTOEditorial.class);
    }
    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        Editorial editorial = editorialRepository.findById(id)
                .orElseThrow(()-> new Exception("Exam not found"));        
        editorialRepository.deleteById(editorial.getId());
        
    }
}
