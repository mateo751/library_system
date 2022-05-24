package com.library.system.librarysystem.dto;

import java.util.Date;

import com.library.system.librarysystem.models.Estudiante;
import com.library.system.librarysystem.models.Libro;

public class NewPrestamoDTO {
    private Date fecha_pre;
    private Date fecha_ent_pre;
    private int dia_pre;
    private int cantidad_pre;
    private String observacion_pre;
    private Libro libro;
    private Estudiante estudiante;
}
