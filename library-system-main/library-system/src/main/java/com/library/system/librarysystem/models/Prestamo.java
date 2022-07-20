package com.library.system.librarysystem.models;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TBL_PRESTAMOS")
@Getter
@Setter

public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name ="FECHA_PRE")
    private Date fechaPre;

    @Column(name ="FECHA_ENTREGA_PRE")
    private Date fechaEntPre;

    @Column(name ="DIA_PRE")
    private int diaPre;

    @Column(name ="CANTIDAD_PRE")
    private int cantidadPre;

    @Column(name ="OBSERVACION_PRE")
    private String observacionPre;

    @Column(name = "CREATED_DATE")    
    private Calendar createdDate;
    @Column(name = "CREATED_BY")    
    private String createdBy;  


    @Column(name = "UPDATED_DATE")    
    private Calendar updatedDate;
    @Column(name = "UPDATED_BY")    
    private String updatedBy;  

    @PrePersist
    public void prePersist(){
        createdDate = Calendar.getInstance();
        createdBy = "user1";
    }

    @PreUpdate
    public void preUpdate(){
        updatedDate = Calendar.getInstance();
        updatedBy = "user2";
    }

    @ManyToOne
    @JoinColumn(name="LIBRO_ID", nullable=false)
    private Libro libro;

    @ManyToOne
    @JoinColumn(name="ESTUDIANTE_ID", nullable=false)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name="USUARIO_ID", nullable=false)
    private Usuario usuario;
    
}
