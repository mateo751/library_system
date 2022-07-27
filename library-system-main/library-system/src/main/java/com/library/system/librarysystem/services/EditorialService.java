package com.library.system.librarysystem.services;

import java.util.List;

import com.library.system.librarysystem.dto.DTOEditorial;
import com.library.system.librarysystem.dto.EditorialListDTO;
import com.library.system.librarysystem.dto.NewEditorialDTO;

public interface EditorialService {
    public DTOEditorial create(NewEditorialDTO dtoEditorial);
    public DTOEditorial retrieve(Long id);
    public DTOEditorial update(DTOEditorial dtoEditorial, Long id);
    public void delete(Long id);
    public long count();

    public List<EditorialListDTO> list(int page, int size, String sort);
}
