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
@Table(name="TBL_SALAS")
@Getter
@Setter

public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name ="ESPECIALIDAD_SAL")
    private String especialidad_sal;

    @Column(name ="CANTIDAD_SAL")
    private int cantidad_sal;
    
}
