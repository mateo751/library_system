package com.library.system.librarysystem.services.impl;

import java.util.Optional;

import com.library.system.librarysystem.dto.DTOAutor;
import com.library.system.librarysystem.dto.NewAutorDTO;
import com.library.system.librarysystem.models.Autor;
import com.library.system.librarysystem.repositories.AutorRepository;
import com.library.system.librarysystem.services.AutorService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AutorServiceImpl implements AutorService{
    final ModelMapper modelMapper;
    final AutorRepository autorRepository;

    @Autowired
    public AutorServiceImpl(@Autowired AutorRepository repository, ModelMapper mapper){
        this.autorRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public DTOAutor create(NewAutorDTO DTOautor) {
        Autor autor = modelMapper.map(DTOautor, Autor.class);
        autorRepository.save(autor);
        DTOAutor autorDTOCreated = modelMapper.map(autor, DTOAutor.class); 
        return autorDTOCreated;
    }

    @Override
    @Transactional(readOnly = true)
    public DTOAutor retrieve(Long id) throws Exception {
        Optional<Autor> exam = autorRepository.findById(id);
        if(exam.isPresent()){
            throw new Exception("Exan not found");
        }
        //.orElseThrow(()-> new Exception("Exam not found"));
        return modelMapper.map(exam.get(), DTOAutor.class);
    }

    @Override
    @Transactional
    public DTOAutor update(DTOAutor DTOautor, Long id) throws Exception {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(()-> new Exception("Exam not found"));
        
        autor.setId(id);
        autor = modelMapper.map(DTOautor, Autor.class);
        autorRepository.save(autor);       

        return modelMapper.map(autor, DTOAutor.class);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(()-> new Exception("Exam not found"));        
        autorRepository.deleteById(autor.getId());        
    }

}
