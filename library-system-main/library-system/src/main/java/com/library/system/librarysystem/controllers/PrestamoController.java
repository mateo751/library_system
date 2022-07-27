package com.library.system.librarysystem.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.library.system.librarysystem.dto.PrestamoListDTO;
import com.library.system.librarysystem.services.PrestamoService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/prestamo")
public class PrestamoController {
    private final PrestamoService service;

    @Autowired
    public PrestamoController(PrestamoService srv){
        this.service =srv;
    }

    /* ================ CREATE ================ */
    @PostMapping("/{id}/prestamo")
    public ResponseEntity<DTOPrestamo> create(@PathVariable("id") Long id, @Valid @RequestBody NewPrestamoDTO dtoPrestamo){
        DTOPrestamo result= service.create(id, dtoPrestamo);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }
    /* ================ RETRIEVE ================ */
    
    @GetMapping("/{idLibro}/prestamo/{id}")
    public ResponseEntity<DTOPrestamo> retrive(@PathVariable("idLibro") Long idLibro, @PathVariable("id") Long id){
        DTOPrestamo result = service.retrieve(idLibro, id);
        return ResponseEntity.ok().body(result);        
    }
   

    /* ================ UPDATE ================ */
    @PutMapping("/{idLibro}/prestamo/{id}")
    public ResponseEntity<DTOPrestamo> update(@RequestBody DTOPrestamo dtoPrestamo, @PathVariable("idLibro") Long idLibro, @PathVariable("id") Long id) {
        DTOPrestamo result = service.update(dtoPrestamo, idLibro,id);
        return ResponseEntity.ok().body(result);
    }

    /* ================ DELETE ================ */
    @DeleteMapping("/{iLibro}/prestamo/{id}")
    public ResponseEntity<String> delete(@PathVariable("idLibro") Long idLibro, @PathVariable("id") Long id){
        service.delete(idLibro, id);
        return ResponseEntity.ok().body("Prestamo Eliminado!");        
    }

    /* ================ LIST ================ */
    @GetMapping("/{id}/libro")//el verbo es diferente a create ya que va
    public ResponseEntity<List<PrestamoListDTO>> list(
    /* @PathVariable("page") int page, 
        @PathVariable("size") int size,
        @RequestParam(name = "sort", required = false) String sort*/
    @PathVariable("idLibro") Long idLibro
    ){
        List<PrestamoListDTO> result = service.list(idLibro);
        return ResponseEntity.ok().body(result);        
    }

    /* ================ COUNT ================ */
    @GetMapping("/count")
    public ResponseEntity<Long> count(){
        long result = service.count();
        return ResponseEntity.ok().body(result);        
    }
}
