package com.library.system.librarysystem.services;

import com.library.system.librarysystem.dto.DTOEditorial;
import com.library.system.librarysystem.dto.NewEditorialDTO;

public interface EditorialService {
    public DTOEditorial create(NewEditorialDTO DTOEditorial);
    public DTOEditorial retrieve(Long id) throws Exception;
    public DTOEditorial update(DTOEditorial DTOEditorial, Long id) throws Exception;
    public void delete(Long id) throws Exception;
}
