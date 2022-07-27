package com.library.system.librarysystem.services;

import java.util.List;

import com.library.system.librarysystem.dto.AutorListDTO;
import com.library.system.librarysystem.dto.DTOAutor;
import com.library.system.librarysystem.dto.NewAutorDTO;

public interface AutorService {

    public DTOAutor create(NewAutorDTO dtoAutor);
    public DTOAutor retrieve(Long id);
    public DTOAutor update(DTOAutor dtoAutor, Long id);
    public void delete(Long id);
    public long count();

    public List<AutorListDTO> list(int page, int size, String sort);
}
