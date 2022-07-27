package com.library.system.librarysystem.services.impl;

import com.library.system.librarysystem.dto.DTOEditorial;
import com.library.system.librarysystem.dto.EditorialListDTO;
import com.library.system.librarysystem.dto.NewEditorialDTO;
import com.library.system.librarysystem.exepciones.NoContentException;
import com.library.system.librarysystem.exepciones.ResourceNotFoundException;
import com.library.system.librarysystem.models.Editorial;
import com.library.system.librarysystem.repositories.EditorialRepository;
import com.library.system.librarysystem.services.EditorialService;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EditorialServiceImpl implements EditorialService{
    final ModelMapper modelMapper;
    final EditorialRepository editorialRepository;

    public EditorialServiceImpl(EditorialRepository repository, ModelMapper mapper){
        this.editorialRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public DTOEditorial create(NewEditorialDTO dtoEditorial) {
        Editorial editorial = modelMapper.map(dtoEditorial, Editorial.class);
        editorialRepository.save(editorial);
        return modelMapper.map(editorial, DTOEditorial.class); 
   
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
    public DTOEditorial update(DTOEditorial dtoEditorial, Long id)  {
        Editorial editorial = editorialRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Editorial not found"));
        
        Editorial editorialUpdated = modelMapper.map(dtoEditorial, Editorial.class);
        editorialUpdated.setCreatedBy(editorial.getCreatedBy());
        editorialUpdated.setCreatedDate(editorial.getCreatedDate());  
        editorialRepository.save(editorialUpdated); 
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
    public List<EditorialListDTO> list(int page, int size, String sort) {
        Pageable pageable = sort == null || sort.isEmpty() ? 
                    PageRequest.of(page, size) 
                :   PageRequest.of(page, size,  Sort.by(sort));

        Page<Editorial> editoriales = editorialRepository.findAll(pageable);
        if(editoriales.isEmpty()) throw new NoContentException("Exams is empty");
        return editoriales.stream().map(editorial -> modelMapper.map(editoriales, EditorialListDTO.class))
            .collect(Collectors.toList()); 
    }

    @Override
    public long count() {        
        return editorialRepository.count();
    }

}
