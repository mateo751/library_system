package com.library.system.librarysystem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioListDTO {
    private Long i;
    private String nombreUsr;
    private String apellidoUsr;
    private String direccionUsr;
    private String emailUsr;
    private String facultadUsr;
    private String profecionUsr;
    private String cargoUsr;
    private String loginUsr;
    private String contrasenaUsr;
}
