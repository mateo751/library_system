package com.library.system.librarysystem.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.system.librarysystem.dto.DTOLibro;
import com.library.system.librarysystem.dto.LibroAutorDTO;
import com.library.system.librarysystem.dto.LibroListDTO;
import com.library.system.librarysystem.dto.NewLibroDTO;
import com.library.system.librarysystem.services.LibroService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/autor")
public class LibroController {
    final LibroService service;

    public LibroController(LibroService srv){
        this.service =srv;
    }
    
    /* ================ CREATE ================ */
    @PostMapping("/{id}/libros")
    public ResponseEntity<DTOLibro> create(@PathVariable("id") Long id, @Valid @RequestBody NewLibroDTO dtoLibro){
        DTOLibro result = service.create(id, dtoLibro);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }

    /* ================ RETRIEVE ================ */
    @GetMapping("/{idAutor}/libros/{id}")
    public ResponseEntity<LibroAutorDTO> retrive(@PathVariable("idAutor") Long idAutor, @PathVariable("id") Long id){
        LibroAutorDTO result = service.retrieve(idAutor, id);
        return ResponseEntity.ok().body(result);        
    }

    /* ================ UPDATE ================ */
    @PutMapping("/{idAutor}/libros/{id}")
    public ResponseEntity<LibroAutorDTO> update(@RequestBody DTOLibro dtoLibro, @PathVariable("idAutor") Long idAutor, @PathVariable("id") Long id){
        LibroAutorDTO result = service.update(dtoLibro, idAutor, id);
        return ResponseEntity.ok().body(result);
    }

    
    /* ================ DELETE ================ */
    @DeleteMapping("/{idAutor}/libros/{id}")
    public ResponseEntity<Void> delete(@PathVariable("idAutor") Long idAutor, @PathVariable("id") Long id) {
        service.delete(idAutor, id);
        return ResponseEntity.noContent().build();        
    }

    /* ================ LIST ================ */
    @GetMapping("/{id}/libros/{page}/{size}")//el verbo es diferente a create ya que va
    public ResponseEntity<List<LibroListDTO>> list(@PathVariable("id") Long id,
    @PathVariable("page") int page,
    @PathVariable("size") int size,
    @RequestParam(name = "sort", required = false) String sort
    ){
        List<LibroListDTO> libros = service.list(id,page, size, sort);
        return ResponseEntity.ok().body(libros);        
    }

    /* ================ COUNT ================ */
    @GetMapping("/count")
    public ResponseEntity<Long> count(){
        long result = service.count();
        return ResponseEntity.ok().body(result);        
    }
}
