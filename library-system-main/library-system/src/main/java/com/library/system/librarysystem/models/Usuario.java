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
@Table(name="TBL_USUARIOS")
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name ="NOMBRE_USR")
    private String nombre_usr;

    @Column(name ="APELLIDO_USR")
    private String apellido_usr;

    @Column(name ="DIRECCION_USR")
    private String direccion_usr;

    @Column(name ="TELEFONO_USR")
    private int telefono_usr;

    @Column(name ="EMAIL_USR")
    private String email_usr;

    @Column(name ="FACULTAD_USR")
    private String facultad_usr;
    
}
