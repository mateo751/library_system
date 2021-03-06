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
import org.springframework.web.bind.annotation.RestController;

import com.library.system.librarysystem.dto.DTOPrestamo;
import com.library.system.librarysystem.dto.NewPrestamoDTO;
import com.library.system.librarysystem.services.PrestamoService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/prestamo")
public class PrestamoController {
    private final PrestamoService service;

    public PrestamoController(PrestamoService srv){
        this.service =srv;
    }
    
    @PostMapping()
    public ResponseEntity<DTOPrestamo> create(@Valid @RequestBody NewPrestamoDTO DTOPrestamo){
        DTOPrestamo result = service.create(DTOPrestamo);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }


    @GetMapping("/{id}")
    public ResponseEntity<DTOPrestamo> retrive(@PathVariable("id") Long id) throws Exception{
        DTOPrestamo result = service.retrieve(id);
        return ResponseEntity.ok().body(result);        
    }

    @GetMapping() //el verbo es diferente a create ya que va
    public ResponseEntity<List<DTOPrestamo>> list(){
        List<DTOPrestamo> result  = service.list();
        return ResponseEntity.ok().body(result);        
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTOPrestamo> update(@RequestBody DTOPrestamo DTOprestamo, @PathVariable("id") Long id) throws Exception{
        DTOPrestamo result = service.update(DTOprestamo, id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) throws Exception{
        service.delete(id);
        return ResponseEntity.ok().body("Prestamo Eliminado!");        
    }
}
