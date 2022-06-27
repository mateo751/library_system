package com.library.system.librarysystem.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.system.librarysystem.dto.DTOLibro;
import com.library.system.librarysystem.dto.NewLibroDTO;
import com.library.system.librarysystem.services.LibroService;

@RestController
@RequestMapping("/libro")
public class LibroController {
    private final LibroService service;

    @Autowired
    public LibroController(LibroService srv){
        this.service =srv;
    }
    
    @PostMapping()
    public ResponseEntity<DTOLibro> create(@Valid @RequestBody NewLibroDTO DTOLibro){
        DTOLibro result = service.create(DTOLibro);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }


    @GetMapping("/{id}")
    public ResponseEntity<DTOLibro> retrive(@PathVariable("id") Long id) throws Exception{
        DTOLibro result = service.retrieve(id);
        return ResponseEntity.ok().body(result);        
    }

    @GetMapping() //el verbo es diferente a create ya que va
    public ResponseEntity<List<DTOLibro>> list(){
        List<DTOLibro> result  = service.list();
        return ResponseEntity.ok().body(result);        
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTOLibro> update(@RequestBody DTOLibro DTOlibro, @PathVariable("id") Long id) throws Exception{
        DTOLibro result = service.update(DTOlibro, id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) throws Exception{
        service.delete(id);
        return ResponseEntity.ok().body("Libro Eliminado!");        
    }
}
