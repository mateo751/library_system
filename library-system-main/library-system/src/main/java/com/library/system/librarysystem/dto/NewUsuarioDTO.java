package com.library.system.librarysystem.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class NewUsuarioDTO {
    @NotNull(message = "Campo vacio")
    private String nombreUsr;
    @NotNull(message = "Campo vacio")
    private String apellidoUsr;
    @NotNull(message = "Campo vacio")
    private String direccionUsr;
    @NotNull(message = "Campo vacio")
    private int telefonoUsr;
    @NotNull(message = "Campo vacio")
    private String emailUsr;
    @NotNull(message = "Campo vacio")
    private String facultadUsr;
    @NotNull(message = "Campo vacio")
    private String profecionUsr;
    @NotNull(message = "Campo vacio")
    private String cargoUsr;
    @NotNull(message = "Campo vacio")
    private String loginUsr;
    @NotNull(message = "Campo vacio")
    private String contrasenaUsr;
}
