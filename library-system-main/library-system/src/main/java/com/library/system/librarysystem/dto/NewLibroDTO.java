package com.library.system.librarysystem.dto;

import javax.validation.constraints.NotNull;

import com.library.system.librarysystem.models.Autor;
import com.library.system.librarysystem.models.Editorial;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class NewLibroDTO {
    @NotNull(message = "El titulo no puede estar vacio")
    private String tituloLib;
    @NotNull(message = "La cantidad disponible no puede estar vacio")
    private int cantidadLib;
    @NotNull(message = "El año no puede estar vacio")
    private String yearLib;
    @NotNull(message = "falta numero de paginas")
    private int numeroLib;
    @NotNull(message = "El formato no puede estar vacio")
    private String formatoLib;
    @NotNull(message = "El estante no puede estar vacio")
    private int estanteLib;
    @NotNull(message = "fata lugar de procedencia")
    private String procedenciaLib;
    private String descripcionLib;
    @NotNull(message = "El autor no puede estar vacio")
    private Autor autor;
    private Editorial editorial;
}
