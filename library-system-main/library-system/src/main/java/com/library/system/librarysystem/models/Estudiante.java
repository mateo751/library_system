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
@Table(name="TBL_ESTUDIANTE")
@Getter
@Setter

public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name ="CODIGO_EST")
    private String codigo_est;

    @Column(name ="NOMBRE_EST")
    private String nombre_est;

    @Column(name ="APELLIDO_EST")
    private String apellido_est;

    @Column(name ="DIRECCION_EST")
    private String direccion_est;

    @Column(name ="TELEFONO_EST")
    private int telefono_est;

    @Column(name ="EMAIL_EST")
    private String email_est;

    @Column(name ="FACULTAD_EST")
    private String facultad_est;
}
