package com.library.system.librarysystem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EstudianteListDTO {
    private Long id;
    private String codigoEst;
    private String nombreEst;
    private String apellidoEst;
    private String direccionEst;
    private int telefonoEst;
    private String emailEst;
    private String facultadEst;
}
