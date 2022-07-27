package com.library.system.librarysystem.services;

import java.util.List;

import com.library.system.librarysystem.dto.DTOEstudiante;
import com.library.system.librarysystem.dto.EstudianteListDTO;
import com.library.system.librarysystem.dto.NewEstudianteDTO;

public interface EstudianteService {
    public DTOEstudiante create(NewEstudianteDTO dtoEstudiante);
    public DTOEstudiante retrieve(Long id) ;
    public DTOEstudiante update(DTOEstudiante dtoEstudiante, Long id) ;
    public void delete(Long id) ;
    public long count();

    public List<EstudianteListDTO> list(int page, int size, String sort);
    
}
