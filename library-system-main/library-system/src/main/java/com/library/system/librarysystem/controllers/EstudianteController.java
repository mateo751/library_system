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

import com.library.system.librarysystem.dto.DTOEstudiante;
import com.library.system.librarysystem.dto.EstudianteListDTO;
import com.library.system.librarysystem.dto.NewEstudianteDTO;
import com.library.system.librarysystem.services.EstudianteService;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {
    private final EstudianteService service;

    @Autowired
    public EstudianteController(EstudianteService srv){
        this.service =srv;
    }
    
    /* ================ CREATE ================ */
    @PostMapping()
    public ResponseEntity<DTOEstudiante> create(@Valid @RequestBody NewEstudianteDTO dtoEstudiante){
        DTOEstudiante result = service.create(dtoEstudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }

    /* ================ RETRIEVE ================ */
    @GetMapping("/{id}")
    public ResponseEntity<DTOEstudiante> retrive(@PathVariable("id") Long id){
        DTOEstudiante result = service.retrieve(id);
        return ResponseEntity.ok().body(result);        
    }

    /* ================ UPDATE ================ */
    @PutMapping("/{id}")
    public ResponseEntity<DTOEstudiante> update(@RequestBody DTOEstudiante dtoEstudiante, @PathVariable("id") Long id) {
        DTOEstudiante result = service.update(dtoEstudiante, id);
        return ResponseEntity.ok().body(result);
    }

    /* ================ DELETE ================ */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().body("Estudiante Eliminado!");        
    }

    /* ================ LIST ================ */
    @GetMapping() //el verbo es diferente a create ya que va
    public ResponseEntity<List<EstudianteListDTO>> list(@PathVariable("page") int page, 
        @PathVariable("size") int size,
        @RequestParam(name = "sort", required = false) String sort){
        List<EstudianteListDTO> result  = service.list(page, size, sort);
        return ResponseEntity.ok().body(result);        
    }
    
    /* ================ COUNT ================ */
    @GetMapping("/count")
    public ResponseEntity<Long> count(){
        long result = service.count();
        return ResponseEntity.ok().body(result);        
    }
}
