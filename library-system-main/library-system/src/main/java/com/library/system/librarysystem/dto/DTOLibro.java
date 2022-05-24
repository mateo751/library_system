package com.library.system.librarysystem.dto;

import com.library.system.librarysystem.models.Autor;
import com.library.system.librarysystem.models.Editorial;

public class DTOLibro {
    private String titulo_lib;
    private int cantidad_disp_lib;
    private String year_edi_lib;
    private int numero_pag_lib;
    private String formato_lib;
    private int estante_lib;
    private String procedencia_lib;
    private String descripcion_lib;
    private Autor autor;
    private Editorial editorial;
}
