package com.library.system.librarysystem.services.impl;

import java.util.List;
import java.util.stream.Collectors;


import com.library.system.librarysystem.dto.AutorListDTO;
import com.library.system.librarysystem.dto.DTOAutor;
import com.library.system.librarysystem.dto.NewAutorDTO;
import com.library.system.librarysystem.exepciones.NoContentException;
import com.library.system.librarysystem.exepciones.ResourceNotFoundException;
import com.library.system.librarysystem.models.Autor;
import com.library.system.librarysystem.repositories.AutorRepository;
import com.library.system.librarysystem.services.AutorService;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AutorServiceImpl implements AutorService{

    final ModelMapper modelMapper;
    final AutorRepository autorRepository;

    
    public AutorServiceImpl(AutorRepository repository, ModelMapper mapper){
        this.autorRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public DTOAutor create(NewAutorDTO dtoAutor) {
        Autor autor = modelMapper.map(dtoAutor, Autor.class);
        autorRepository.save(autor); 
        return modelMapper.map(autor, DTOAutor.class);
    }

    @Override
    @Transactional(readOnly = true)
    public DTOAutor retrieve(Long id){
        Autor autor = autorRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Autor not found"));
        return modelMapper.map(autor, DTOAutor.class);
    }

    @Override
    @Transactional
    public DTOAutor update(DTOAutor dtoAutor, Long id)  {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Autor not found"));

        Autor autorUpdated = modelMapper.map(dtoAutor, Autor.class);
        //Keeping values
        autorUpdated.setCreatedBy(autor.getCreatedBy()) ;
        autorUpdated.setCreatedDate(autor.getCreatedDate()) ;
        autorRepository.save(autor);       

        return modelMapper.map( autorUpdated, DTOAutor.class);
    }

    @Override
    @Transactional
    public void delete(Long id)  {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Exam not found"));        
        autorRepository.deleteById(autor.getId());        
    }

    @Override
    @Transactional(readOnly = true)
    public List<AutorListDTO> list(int page, int size, String sort) {
        Pageable pageable = sort == null || sort.isEmpty() ? 
                    PageRequest.of(page, size) 
                :   PageRequest.of(page, size,  Sort.by(sort));

        Page<Autor> autores = autorRepository.findAll(pageable);
        if(autores.isEmpty())throw new NoContentException("Autores está vacio");
        return autores.stream().map(autor -> modelMapper.map(autores, AutorListDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public long count() {        
        return autorRepository.count();
    }
    

}
