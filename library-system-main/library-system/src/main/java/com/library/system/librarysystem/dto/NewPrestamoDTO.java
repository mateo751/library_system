package com.library.system.librarysystem.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.library.system.librarysystem.models.Estudiante;
import com.library.system.librarysystem.models.Libro;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class NewPrestamoDTO {
    @NotNull(message = "la fecha del prestamo no puede estar vacio")
    private Date fecha_pre;
    private Date fecha_ent_pre;
    @NotNull(message = "El del prestamo no puede estar vacio")
    private int dia_pre;
    @NotNull(message = "la cantidad no puede estar vacio")
    private int cantidad_pre;
    private String observacion_pre;
    @NotNull(message = "El libro no puede estar vacio")
    private Libro libro;
    @NotNull(message = "El estudiante no puede estar vacio")
    private Estudiante estudiante;
}
