package com.library.system.librarysystem.models;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
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

    //Respaldos
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
    

    @OneToMany(mappedBy="estudiante") 
    private List<Prestamo> prestamos;
}
