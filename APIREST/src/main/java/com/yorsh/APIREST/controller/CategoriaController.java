package com.yorsh.APIREST.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yorsh.APIREST.model.Categoria;
import com.yorsh.APIREST.service.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/crear-categoria")
    public ResponseEntity<?> guardar(@RequestBody Categoria categoria){
        Categoria nuevo = categoriaService.guardarCategoria(categoria);

        return ResponseEntity.ok("Categoria Guardada con exito!");
    }

    @GetMapping("/listar-categorias")
    public ResponseEntity<List<Categoria>> listarTodos(){
        return ResponseEntity.ok(categoriaService.listarCategorias());
    }

    @PutMapping("/actualizar-categoria/{id}")
    public ResponseEntity<Categoria> actualizar(@PathVariable ObjectId id, @RequestBody Categoria categoria){
        return ResponseEntity.ok(categoriaService.actualizarCategoria(id, categoria));
    }

    @DeleteMapping("/eliminar-categoria/{id}")
    public ResponseEntity<String> eliminar(@PathVariable ObjectId id){
        categoriaService.eliminarCategoria(id);
        
        return ResponseEntity.ok("Categoria eliminada con exito!");
    }
}
