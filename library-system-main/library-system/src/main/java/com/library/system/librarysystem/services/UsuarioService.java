package com.library.system.librarysystem.services;

import java.util.List;

import com.library.system.librarysystem.dto.DTOUsuario;
import com.library.system.librarysystem.dto.NewUsuarioDTO;
import com.library.system.librarysystem.dto.UsuarioListDTO;

public interface UsuarioService {
    public DTOUsuario create(NewUsuarioDTO dtoUsuario);
    public DTOUsuario retrieve(Long id);
    public DTOUsuario update(DTOUsuario dtoUsuario, Long id);
    public void delete(Long id);
    public long count();

    public List<UsuarioListDTO> list(int page, int size, String sort);
}
