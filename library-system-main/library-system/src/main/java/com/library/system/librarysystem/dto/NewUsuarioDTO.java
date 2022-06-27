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
    private String nombre_usr;
    @NotNull(message = "Campo vacio")
    private String apellido_usr;
    @NotNull(message = "Campo vacio")
    private String direccion_usr;
    @NotNull(message = "Campo vacio")
    private int telefono_usr;
    @NotNull(message = "Campo vacio")
    private String email_usr;
    @NotNull(message = "Campo vacio")
    private String facultad_usr;
    @NotNull(message = "Campo vacio")
    private String prodecion_usr;
    @NotNull(message = "Campo vacio")
    private String cargo_usr;
    @NotNull(message = "Campo vacio")
    private String login_usr;
    @NotNull(message = "Campo vacio")
    private String contrasena_usr;
}
