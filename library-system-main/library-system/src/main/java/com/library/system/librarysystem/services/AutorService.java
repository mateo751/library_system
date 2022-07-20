package com.library.system.librarysystem.services;

import java.util.List;

import com.library.system.librarysystem.dto.DTOAutor;
import com.library.system.librarysystem.dto.NewAutorDTO;

public interface AutorService {

    public DTOAutor create(NewAutorDTO DTOAutor);
    public DTOAutor retrieve(Long id);
    public DTOAutor update(DTOAutor DTOAutor, Long id);
    public void delete(Long id);
    public long count();
    
    public List<DTOAutor> list();
}
