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

import com.library.system.librarysystem.dto.DTOUsuario;
import com.library.system.librarysystem.dto.NewUsuarioDTO;
import com.library.system.librarysystem.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService service;

    @Autowired
    public UsuarioController(UsuarioService srv){
        this.service =srv;
    }
    
    @PostMapping()
    public ResponseEntity<DTOUsuario> create(@Valid @RequestBody NewUsuarioDTO DTOUsuario){
        DTOUsuario result = service.create(DTOUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }


    @GetMapping("/{id}")
    public ResponseEntity<DTOUsuario> retrive(@PathVariable("id") Long id) throws Exception{
        DTOUsuario result = service.retrieve(id);
        return ResponseEntity.ok().body(result);        
    }

    @GetMapping() //el verbo es diferente a create ya que va
    public ResponseEntity<List<DTOUsuario>> list(){
        List<DTOUsuario> result  = service.list();
        return ResponseEntity.ok().body(result);        
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTOUsuario> update(@RequestBody DTOUsuario DTOusuario, @PathVariable("id") Long id) throws Exception{
        DTOUsuario result = service.update(DTOusuario, id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) throws Exception{
        service.delete(id);
        return ResponseEntity.ok().body("Usuario Eliminado!");        
    }
}
