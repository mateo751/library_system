package com.library.system.librarysystem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class DTOEstudiante {
    private String codigo_est;
    private String nombre_est;
    private String apellido_est;
    private String direccion_est;
    private int telefono_est;
    private String email_est;
    private String facultad_est;
}
