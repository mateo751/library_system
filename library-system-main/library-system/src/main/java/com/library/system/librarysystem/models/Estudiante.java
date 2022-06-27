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
    private String codigoEst;

    @Column(name ="NOMBRE_EST")
    private String nombreEst;

    @Column(name ="APELLIDO_EST")
    private String apellidoEst;

    @Column(name ="DIRECCION_EST")
    private String direccionEst;

    @Column(name ="TELEFONO_EST")
    private int telefonoEst;

    @Column(name ="EMAIL_EST")
    private String emailEst;

    @Column(name ="FACULTAD_EST")
    private String facultadEst;
}
