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

import com.library.system.librarysystem.dto.DTOEditorial;
import com.library.system.librarysystem.dto.NewEditorialDTO;
import com.library.system.librarysystem.services.EditorialService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/editorial")
public class EditorialController {
    private final EditorialService service;

    public EditorialController(EditorialService srv){
        this.service =srv;
    }
    
    @PostMapping()
    public ResponseEntity<DTOEditorial> create(@Valid @RequestBody NewEditorialDTO DTOEditorial){
        DTOEditorial result = service.create(DTOEditorial);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }


    @GetMapping("/{id}")
    public ResponseEntity<DTOEditorial> retrive(@PathVariable("id") Long id) throws Exception{
        DTOEditorial result = service.retrieve(id);
        return ResponseEntity.ok().body(result);        
    }

    @GetMapping() //el verbo es diferente a create ya que va
    public ResponseEntity<List<DTOEditorial>> list(){
        List<DTOEditorial> result  = service.list();
        return ResponseEntity.ok().body(result);        
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTOEditorial> update(@RequestBody DTOEditorial DTOeditorial, @PathVariable("id") Long id) throws Exception{
        DTOEditorial result = service.update(DTOeditorial, id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) throws Exception{
        service.delete(id);
        return ResponseEntity.ok().body("Editorial Eliminado!");        
    }
}
