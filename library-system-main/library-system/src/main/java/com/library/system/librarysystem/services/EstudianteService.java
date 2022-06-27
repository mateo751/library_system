package com.library.system.librarysystem.services;

import java.util.List;

import com.library.system.librarysystem.dto.DTOEstudiante;
import com.library.system.librarysystem.dto.NewEstudianteDTO;

public interface EstudianteService {
    public DTOEstudiante create(NewEstudianteDTO DTOEstudiante);
    public DTOEstudiante retrieve(Long id) throws Exception;
    public DTOEstudiante update(DTOEstudiante DTOEstudiante, Long id) throws Exception;
    public void delete(Long id) throws Exception;

    public List<DTOEstudiante> list();
    
}
