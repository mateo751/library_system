package com.library.system.librarysystem.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.system.librarysystem.dto.DTOEstudiante;
import com.library.system.librarysystem.dto.NewEstudianteDTO;
import com.library.system.librarysystem.exepciones.ResourceNotFoundException;
import com.library.system.librarysystem.models.Estudiante;
import com.library.system.librarysystem.repositories.EstudianteRepository;
import com.library.system.librarysystem.services.EstudianteService;

@Service
public class EstudianteServiceImpl implements EstudianteService {
    final ModelMapper modelMapper;
    final EstudianteRepository estudianteRepository;

    @Autowired
    public EstudianteServiceImpl(@Autowired EstudianteRepository repository, ModelMapper mapper){
        this.estudianteRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public DTOEstudiante create(NewEstudianteDTO DTOEstudiante) {
        Estudiante estudiante = modelMapper.map(DTOEstudiante, Estudiante.class);
        estudianteRepository.save(estudiante);
        DTOEstudiante estudianteDTOCreated = modelMapper.map(estudiante, DTOEstudiante.class); 
        return estudianteDTOCreated;
    }

    @Override
    @Transactional(readOnly = true)
    public DTOEstudiante retrieve(Long id){
        Estudiante estudiante = estudianteRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Estudiante not found"));
        return modelMapper.map(estudiante, DTOEstudiante.class);
    }

    @Override
    @Transactional
    public DTOEstudiante update(DTOEstudiante DTOestudiante, Long id)  {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Exam not found"));
        
        estudiante.setId(id);
        estudiante = modelMapper.map(DTOestudiante, Estudiante.class);
        estudianteRepository.save(estudiante);       

        return modelMapper.map(estudiante, DTOEstudiante.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Estudiante estudiante = estudianteRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Exam not found"));        
        estudianteRepository.deleteById(estudiante.getId());
        
    }

    @Override
    @Transactional(readOnly = true)
    public List<DTOEstudiante> list() {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        return estudiantes.stream().map(estudiante -> modelMapper.map(estudiante, DTOEstudiante.class))
            .collect(Collectors.toList());
    }
}
