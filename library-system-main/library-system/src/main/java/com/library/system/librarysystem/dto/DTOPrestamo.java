package com.library.system.librarysystem.dto;

import java.util.Date;

import com.library.system.librarysystem.models.Estudiante;
import com.library.system.librarysystem.models.Libro;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class DTOPrestamo {
    private Date fecha_pre;
    private Date fecha_ent_pre;
    private int dia_pre;
    private int cantidad_pre;
    private String observacion_pre;
    private Libro libro;
    private Estudiante estudiante;
}
