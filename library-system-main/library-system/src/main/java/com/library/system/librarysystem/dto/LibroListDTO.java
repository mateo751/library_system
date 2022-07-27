package com.library.system.librarysystem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LibroListDTO {
    private Long id;
    private String tituloLib;
    private int cantidadLib;
    private String yearLib;
    private int numeroLib;
    private String formatoLib;
    private int estanteLib;
    private String procedenciaLib;
    private String descripcionLib;

}
