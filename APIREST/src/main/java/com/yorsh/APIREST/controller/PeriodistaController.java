package com.yorsh.APIREST.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yorsh.APIREST.service.PeriodistaService;
import com.yorsh.APIREST.model.Periodista;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class PeriodistaController {
    @Autowired
    private PeriodistaService periodistaService;

    @PostMapping("/crear-usuario")
    public ResponseEntity<?> registrar(@RequestBody Periodista periodista){
        Periodista nuevo = periodistaService.crearPeriodista(periodista);
        return ResponseEntity.ok("Periodista Registrado con exito!");
    }

    @GetMapping("/listar-usuarios")
    public ResponseEntity<List<Periodista>> listarTodos() {
        return ResponseEntity.ok(periodistaService.listarPeriodistas());
    }
    
    @PutMapping("/actualizar-usuario/{id}")
    public ResponseEntity<Periodista> actualizar(@PathVariable ObjectId id, @RequestBody Periodista periodista){
        return ResponseEntity.ok(periodistaService.actualizarPeriodista(id, periodista));
    }

    @DeleteMapping("/eliminar-usuario/{id}")
    public ResponseEntity<String> eliminar(@PathVariable ObjectId id){
        periodistaService.eliminarPeriodista(id);
        return ResponseEntity.ok("Usuario eliminado con exito!");
    }
}
