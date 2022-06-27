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
    private String titulo_lib;
    @NotNull(message = "La cantidad disponible no puede estar vacio")
    private int cantidad_disp_lib;
    @NotNull(message = "El año no puede estar vacio")
    private String year_edi_lib;
    @NotNull(message = "falta numero de paginas")
    private int numero_pag_lib;
    @NotNull(message = "El formato no puede estar vacio")
    private String formato_lib;
    @NotNull(message = "El estante no puede estar vacio")
    private int estante_lib;
    @NotNull(message = "fata lugar de procedencia")
    private String procedencia_lib;
    private String descripcion_lib;
    @NotNull(message = "El autor no puede estar vacio")
    private Autor autor;
    private Editorial editorial;
}
