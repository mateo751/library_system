package com.library.system.librarysystem.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TBL_PRESTAMOS")
@Getter
@Setter

public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name ="FECHA_PRE")
    private Date fecha_pre;

    @Column(name ="FECHA_ENTREGA_PRE")
    private Date fecha_ent_pre;

    @Column(name ="DIA_PRE")
    private int dia_pre;

    @Column(name ="CANTIDAD_PRE")
    private int cantidad_pre;

    @Column(name ="OBSERVACION_PRE")
    private String observacion_pre;

    @ManyToOne
    @JoinColumn(name="LIBRO_ID", nullable=false)
    private Libro libro;

    @ManyToOne
    @JoinColumn(name="ESTUDIANTE_ID", nullable=false)
    private Estudiante estudiante;
    
}
