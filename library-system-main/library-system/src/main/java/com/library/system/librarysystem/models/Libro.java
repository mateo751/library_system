package com.library.system.librarysystem.models;

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
@Table(name="TBL_LIBROS")
@Getter
@Setter

public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name ="TITULO_LIB",nullable = false )
    private String tituloLib;

    @Column(name ="CANTIDAD_DISP_LIB" )
    private int cantidadLib;

    @Column(name ="YEAR_EDI_LIB" )
    private String yearLib;

    @Column(name ="NUMERO_PAG_LIB")
    private int numeroLib;

    @Column(name ="FORMATO_LIB")
    private String formatoLib;

    @Column(name ="ESTANTE_LIB" )
    private int estanteLib;

    @Column(name ="PROCEDENCIA_LIB" )
    private String procedenciaLib;

    @Column(name ="DESCRIPCION_LIB" )
    private String descripcionLib;

    @ManyToOne
    @JoinColumn(name="AUTOR_ID", nullable=false)
    private Autor autorLib;

    @ManyToOne
    @JoinColumn(name="EDITORIAL_ID", nullable=false)
    private Editorial editorialLib;

}
