package com.library.system.librarysystem.services;

import java.util.List;

import com.library.system.librarysystem.dto.DTOLibro;
import com.library.system.librarysystem.dto.NewLibroDTO;

public interface LibroService {
    public DTOLibro create(NewLibroDTO DTOLibro);
    public DTOLibro retrieve(Long id) throws Exception;
    public DTOLibro update(DTOLibro DTOLibro, Long id) throws Exception;
    public void delete(Long id) throws Exception;

    public List<DTOLibro> list();
}
