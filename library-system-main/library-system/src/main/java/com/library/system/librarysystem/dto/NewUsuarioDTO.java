package com.library.system.librarysystem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class NewUsuarioDTO {
    private String nombre_usr;
    private String apellido_usr;
    private String direccion_usr;
    private int telefono_usr;
    private String email_usr;
    private String facultad_usr;
    private String prodecion_usr;
    private String cargo_usr;
    private String login_usr;
    private String contrasena_usr;
}
