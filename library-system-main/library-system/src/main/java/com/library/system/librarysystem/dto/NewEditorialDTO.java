package com.library.system.librarysystem.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class NewEditorialDTO {
    @NotNull(message = "La descripcion no puede ser nula")
    private String nombreEdi;
    @NotNull(message = "La descripcion no puede ser nula")
    private String descripcionEdi;
}
