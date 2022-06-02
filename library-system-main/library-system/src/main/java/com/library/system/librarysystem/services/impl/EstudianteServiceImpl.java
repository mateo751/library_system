package com.library.system.librarysystem.services.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.system.librarysystem.dto.DTOEstudiante;
import com.library.system.librarysystem.dto.NewEstudianteDTO;
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
    @Transactional
    public DTOEstudiante retrieve(Long id) throws Exception {
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        if(estudiante.isPresent()){
            throw new Exception("Exan not found");
        }
        //.orElseThrow(()-> new Exception("Exam not found"));
        return modelMapper.map(estudiante.get(), DTOEstudiante.class); 
    }

    @Override
    @Transactional
    public DTOEstudiante update(DTOEstudiante DTOestudiante, Long id) throws Exception {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(()-> new Exception("Exam not found"));
        
        estudiante.setId(id);
        estudiante = modelMapper.map(DTOestudiante, Estudiante.class);
        estudianteRepository.save(estudiante);       

        return modelMapper.map(estudiante, DTOEstudiante.class);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        Estudiante estudiante = estudianteRepository.findById(id)
        .orElseThrow(()-> new Exception("Exam not found"));        
        estudianteRepository.deleteById(estudiante.getId());
        
    }
}
