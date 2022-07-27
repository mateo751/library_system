package com.library.system.librarysystem.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class PrestamoListDTO {
    private Long id;
    private Date fechaPre;
    private Date fechaEntPre;
    private int diaPre;
    private int cantidadPre;
    private String observacionPre;
    
}
