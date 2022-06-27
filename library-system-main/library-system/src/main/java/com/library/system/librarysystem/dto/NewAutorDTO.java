package com.library.system.librarysystem.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class  NewAutorDTO {
    @NotNull(message = "El nombre no puede ser nulo")
    private String nombreAut;
    @NotNull(message = "La descripcion no puede ser nula")
    private String descripcionAut;
}
