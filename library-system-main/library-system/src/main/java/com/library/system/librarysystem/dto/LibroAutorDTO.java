package com.library.system.librarysystem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LibroAutorDTO extends DTOLibro{
    private DTOAutor autores;
    
}
