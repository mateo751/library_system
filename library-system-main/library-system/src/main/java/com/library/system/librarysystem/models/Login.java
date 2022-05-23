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
@Table(name="TBL_LOGINS")
@Getter
@Setter
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name ="USUARIO_LOG")
    private String usuario_log;

    @Column(name ="CONTRASENA_LOG")
    private String contrasena_log;
    
    
}
