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
@Table(name="TBL_AUTOR")
@Getter
@Setter

public class Autor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name ="NOMBRE_AUT")
    private String nombre_aut;

    @Column(name ="DESCRIPCION_AUT")
    private String descripcion_aut;
}
