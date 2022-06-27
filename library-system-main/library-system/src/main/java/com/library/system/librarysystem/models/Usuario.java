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
    private String nombreUsr;

    @Column(name ="APELLIDO_USR")
    private String apellidoUsr;

    @Column(name ="DIRECCION_USR")
    private String direccionUsr;

    @Column(name ="TELEFONO_USR")
    private int telefonoUsr;

    @Column(name ="EMAIL_USR")
    private String emailUsr;

    @Column(name ="FACULTAD_USR")
    private String facultadUsr;

    @Column(name ="PROFECION_USR")
    private String prodecionUsr;

    @Column(name ="CARGO_USR")
    private String cargoUsr;

    @Column(name ="LOGIN_URS")
    private String loginUsr;

    @Column(name ="CONTRASENA_USR")
    private String contrasenaUsr;
    
}
