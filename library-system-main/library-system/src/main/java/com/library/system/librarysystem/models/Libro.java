package com.library.system.librarysystem.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    @Column(name ="AUTOR_LIB" )
    private String autor_lib;

    @Column(name ="TIPO_LIB" )
    private String tipo_lib;

    @Column(name ="TEMA_LIB")
    private String tema_lib;

    @Column(name ="CATEGORIA_LIB")
    private String categoria_lib;
    
    @Column(name ="EDITORIAL_LIB" )
    private String editorial_lib;

    @Column(name ="ESTANTE_LIB" )
    private int estante_lib;

    @Column(name ="PROCEDENCIA_LIB" )
    private String procedencia_lib;

}
