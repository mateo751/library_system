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

import com.library.system.librarysystem.dto.DTOAutor;
import com.library.system.librarysystem.dto.NewAutorDTO;
import com.library.system.librarysystem.services.AutorService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/autor")
public class AutorController {
    private final AutorService service;

    public AutorController(AutorService srv){
        this.service =srv;
    }
    /*================ CREATE ================ */
    @PostMapping()
    public ResponseEntity<DTOAutor> create(@Valid @RequestBody NewAutorDTO DTOAutor){
        DTOAutor result = service.create(DTOAutor);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }
    /* ================ RETRIEVE ================ */
    @GetMapping("/{id}")
    public ResponseEntity<DTOAutor> retrive(@PathVariable("id") Long id) throws Exception{
        DTOAutor result = service.retrieve(id);
        return ResponseEntity.ok().body(result);        
    }
    /* ================ LIST ================ */
    @GetMapping() //el verbo es diferente a create ya que va
    public ResponseEntity<List<DTOAutor>> list(){
        List<DTOAutor> result  = service.list();
        return ResponseEntity.ok().body(result);        
    }
    /* ================ UPDATE ================ */
    @PutMapping("/{id}")
    public ResponseEntity<DTOAutor> update(@RequestBody DTOAutor DTOautor, @PathVariable("id") Long id) throws Exception{
        DTOAutor result = service.update(DTOautor, id);
        return ResponseEntity.ok().body(result);
    }
    /* ================ DELETE ================ */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) throws Exception{
        service.delete(id);
        return ResponseEntity.ok().body("Autor Eliminado!");        
    }
    
    /* ================ COUNT ================ */
    @GetMapping("/count")
    public ResponseEntity<Long> count(){
        long result = service.count();
        return ResponseEntity.ok().body(result);        
    }
}
