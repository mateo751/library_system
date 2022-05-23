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
    private String titulo_lib;

    @Column(name ="CANTIDAD_DISP_LIB" )
    private int cantidad_disp_lib;

    @Column(name ="YEAR_EDI_LIB" )
    private String year_edi_lib;

    @Column(name ="NUMERO_PAG_LIB")
    private int numero_pag_lib;

    @Column(name ="FORMATO_LIB")
    private String formato_lib;

    @Column(name ="ESTANTE_LIB" )
    private int estante_lib;

    @Column(name ="PROCEDENCIA_LIB" )
    private String procedencia_lib;

    @Column(name ="DESCRIPCION_LIB" )
    private String descripcion_lib;

    @ManyToOne
    @JoinColumn(name="AUTOR_ID", nullable=false)
    private Autor autor;

    @ManyToOne
    @JoinColumn(name="EDITORIAL_ID", nullable=false)
    private Editorial editorial;

}
