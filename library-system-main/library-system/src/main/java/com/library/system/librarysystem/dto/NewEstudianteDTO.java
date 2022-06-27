package com.library.system.librarysystem.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class NewEstudianteDTO {
    @NotNull(message = "La codigo no puede ser nula")
    private String codigo_est;
    @NotNull(message = "EL nombre no puede ser nula")
    private String nombre_est;
    @NotNull(message = "El apellido no puede ser nula")
    private String apellido_est;
    @NotNull(message = "La direccion no puede estar vacio")
    private String direccion_est;
    @NotNull(message = "El telefono no puede estar vacio")
    private int telefono_est;
    @NotNull(message = "El email no puede estar vacio")
    private String email_est;
    @NotNull(message = "La facultad no puede estar vacio")
    private String facultad_est;
}
