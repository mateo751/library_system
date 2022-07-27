package com.library.system.librarysystem.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.system.librarysystem.dto.DTOEstudiante;
import com.library.system.librarysystem.dto.EstudianteListDTO;
import com.library.system.librarysystem.dto.NewEstudianteDTO;
import com.library.system.librarysystem.exepciones.NoContentException;
import com.library.system.librarysystem.exepciones.ResourceNotFoundException;
import com.library.system.librarysystem.models.Estudiante;
import com.library.system.librarysystem.repositories.EstudianteRepository;
import com.library.system.librarysystem.services.EstudianteService;

@Service
public class EstudianteServiceImpl implements EstudianteService {
    final ModelMapper modelMapper;
    final EstudianteRepository estudianteRepository;

    public EstudianteServiceImpl(EstudianteRepository repository, ModelMapper mapper){
        this.estudianteRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public DTOEstudiante create(NewEstudianteDTO dtoEstudiante) {
        Estudiante estudiante = modelMapper.map(dtoEstudiante, Estudiante.class);
        estudianteRepository.save(estudiante);
        return modelMapper.map(estudiante, DTOEstudiante.class); 
    }

    @Override
    @Transactional(readOnly = true)
    public DTOEstudiante retrieve(Long id){
        Estudiante estudiante = estudianteRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Student not found"));
        return modelMapper.map(estudiante, DTOEstudiante.class);
    }

    @Override
    @Transactional
    public DTOEstudiante update(DTOEstudiante dtoEstudiante, Long id)  {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Estudiante not found"));
        
        Estudiante estudianteUpdated = modelMapper.map(dtoEstudiante,Estudiante.class);
        estudianteUpdated.setCreatedBy(estudiante.getCreatedBy());
        estudianteUpdated.setCreatedDate(estudiante.getCreatedDate());
        estudianteRepository.save(estudianteUpdated);  
        return modelMapper.map( estudianteUpdated, DTOEstudiante.class);
    }

    @Override
    @Transactional
    public void delete(Long id)  {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Estudiante not found"));        
        estudianteRepository.deleteById(estudiante.getId());        
    }

    @Override
    @Transactional(readOnly = true)
    public List<EstudianteListDTO> list(int page, int size, String sort) {
        Pageable pageable = sort == null || sort.isEmpty() ? 
                    PageRequest.of(page, size) 
                :   PageRequest.of(page, size,  Sort.by(sort));

        Page<Estudiante> estudiantes = estudianteRepository.findAll(pageable);
        if(estudiantes.isEmpty()) throw new NoContentException("Estudiantes is empty");
        return estudiantes.stream().map(estudiante -> modelMapper.map(estudiantes, EstudianteListDTO.class))
            .collect(Collectors.toList()); 
    }

    @Override
    public long count() {        
        return estudianteRepository.count();
    }
}
