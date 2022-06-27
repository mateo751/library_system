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

import com.library.system.librarysystem.dto.DTOEstudiante;
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
    
    @PostMapping()
    public ResponseEntity<DTOEstudiante> create(@Valid @RequestBody NewEstudianteDTO DTOEstudiante){
        DTOEstudiante result = service.create(DTOEstudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }


    @GetMapping("/{id}")
    public ResponseEntity<DTOEstudiante> retrive(@PathVariable("id") Long id) throws Exception{
        DTOEstudiante result = service.retrieve(id);
        return ResponseEntity.ok().body(result);        
    }

    @GetMapping() //el verbo es diferente a create ya que va
    public ResponseEntity<List<DTOEstudiante>> list(){
        List<DTOEstudiante> result  = service.list();
        return ResponseEntity.ok().body(result);        
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTOEstudiante> update(@RequestBody DTOEstudiante DTOestudiante, @PathVariable("id") Long id) throws Exception{
        DTOEstudiante result = service.update(DTOestudiante, id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) throws Exception{
        service.delete(id);
        return ResponseEntity.ok().body("Estudiante Eliminado!");        
    }
}
