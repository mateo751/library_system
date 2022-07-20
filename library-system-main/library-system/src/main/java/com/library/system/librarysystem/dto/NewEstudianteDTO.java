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
    private String codigoEst;
    @NotNull(message = "EL nombre no puede ser nula")
    private String nombreEst;
    @NotNull(message = "El apellido no puede ser nula")
    private String apellidoEst;
    @NotNull(message = "La direccion no puede estar vacio")
    private String direccionEst;
    @NotNull(message = "El telefono no puede estar vacio")
    private String telefonoEst;
    @NotNull(message = "El email no puede estar vacio")
    private String emailEst;
    @NotNull(message = "La facultad no puede estar vacio")
    private String facultadEst;
}
