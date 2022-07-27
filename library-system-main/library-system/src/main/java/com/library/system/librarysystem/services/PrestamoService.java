package com.library.system.librarysystem.services;

import java.util.List;

import com.library.system.librarysystem.dto.DTOPrestamo;
import com.library.system.librarysystem.dto.NewPrestamoDTO;
import com.library.system.librarysystem.dto.PrestamoListDTO;

public interface PrestamoService {
    public DTOPrestamo create(Long idLibro,NewPrestamoDTO dtoPrestamo);
    public DTOPrestamo retrieve(Long idLibro, Long id) ;
    public DTOPrestamo update(DTOPrestamo dtoPrestamo, Long idLibro, Long id) ;
    public void delete(Long idLibro ,Long id) ;

    public List<PrestamoListDTO> list(Long idLibro);
    public long count();
}
