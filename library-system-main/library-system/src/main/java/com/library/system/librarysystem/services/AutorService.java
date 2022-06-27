package com.library.system.librarysystem.services;

import java.util.List;

import com.library.system.librarysystem.dto.DTOAutor;
import com.library.system.librarysystem.dto.NewAutorDTO;

public interface AutorService {

    public DTOAutor create(NewAutorDTO DTOAutor);
    public DTOAutor retrieve(Long id) throws Exception;
    public DTOAutor update(DTOAutor DTOAutor, Long id) throws Exception;
    public void delete(Long id) throws Exception;

    public List<DTOAutor> list();
}
