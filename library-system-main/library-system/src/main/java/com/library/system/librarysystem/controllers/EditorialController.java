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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.system.librarysystem.dto.DTOEditorial;
import com.library.system.librarysystem.dto.EditorialListDTO;
import com.library.system.librarysystem.dto.NewEditorialDTO;
import com.library.system.librarysystem.services.EditorialService;

@RestController
@RequestMapping("/editorial")
public class EditorialController {
    private final EditorialService service;

    @Autowired
    public EditorialController(EditorialService srv){
        this.service =srv;
    }
    
     /* ================ CREATE ================ */
    @PostMapping()
    public ResponseEntity<DTOEditorial> create(@Valid @RequestBody NewEditorialDTO dtoEditorial){
        DTOEditorial result = service.create(dtoEditorial);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }

    /* ================ RETRIEVE ================ */
    @GetMapping("/{id}")
    public ResponseEntity<DTOEditorial> retrive(@PathVariable("id") Long id){
        DTOEditorial result = service.retrieve(id);
        return ResponseEntity.ok().body(result);        
    }

    /* ================ UPDATE ================ */
    @PutMapping("/{id}")
    public ResponseEntity<DTOEditorial> update(@RequestBody DTOEditorial dtoEditorial, @PathVariable("id") Long id) {
        DTOEditorial result = service.update(dtoEditorial, id);
        return ResponseEntity.ok().body(result);
    }

    /* ================ DELETE ================ */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().body("Editorial Eliminado!");        
    }

    /* ================ LIST ================ */
    @GetMapping("/{page}/{size}") //el verbo es diferente a create ya que va
    public ResponseEntity<List<EditorialListDTO>> list(@PathVariable("page") int page, 
    @PathVariable("size") int size,
    @RequestParam(name = "sort", required = false) String sort){
        List<EditorialListDTO> result  = service.list(page, size, sort);
        return ResponseEntity.ok().body(result);        
    }

    /* ================ COUNT ================ */
    @GetMapping("/count")
    public ResponseEntity<Long> count(){
        long result = service.count();
        return ResponseEntity.ok().body(result);        
    }
    
}
