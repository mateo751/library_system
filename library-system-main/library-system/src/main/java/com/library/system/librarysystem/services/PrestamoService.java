package com.library.system.librarysystem.services;

import com.library.system.librarysystem.dto.DTOPrestamo;
import com.library.system.librarysystem.dto.NewPrestamoDTO;

public interface PrestamoService {
    public DTOPrestamo create(NewPrestamoDTO DTOPrestamo);
    public DTOPrestamo retrieve(Long id) throws Exception;
    public DTOPrestamo update(DTOPrestamo DTOPrestamo, Long id) throws Exception;
    public void delete(Long id) throws Exception;
}
