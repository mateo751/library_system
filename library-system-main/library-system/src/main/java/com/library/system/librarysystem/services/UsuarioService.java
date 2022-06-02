package com.library.system.librarysystem.services;

import com.library.system.librarysystem.dto.DTOUsuario;
import com.library.system.librarysystem.dto.NewUsuarioDTO;

public interface UsuarioService {
    public DTOUsuario create(NewUsuarioDTO DTOUsuario);
    public DTOUsuario retrieve(Long id) throws Exception;
    public DTOUsuario update(DTOUsuario DTOUsuario, Long id) throws Exception;
    public void delete(Long id) throws Exception;
}
