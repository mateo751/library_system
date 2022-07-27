package com.library.system.librarysystem.services;

import java.util.List;

import com.library.system.librarysystem.dto.DTOLibro;
import com.library.system.librarysystem.dto.LibroAutorDTO;
import com.library.system.librarysystem.dto.LibroListDTO;
import com.library.system.librarysystem.dto.NewLibroDTO;

public interface LibroService {
    public DTOLibro create(Long idAutor, NewLibroDTO dtoLibro);
    public LibroAutorDTO  retrieve(Long idAutor, Long id);
    public LibroAutorDTO update(DTOLibro dtoLibro, Long idAutor, Long id);
    public void delete(Long idAutor, Long id);
    public long count();

    public List<LibroListDTO> list(Long idAutor, int page, int size, String sort);
    
}
