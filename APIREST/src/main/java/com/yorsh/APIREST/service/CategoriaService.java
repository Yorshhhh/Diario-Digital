package com.yorsh.APIREST.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yorsh.APIREST.model.Categoria;
import com.yorsh.APIREST.repository.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
    
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria actualizarCategoria(ObjectId id, Categoria categoria) {
        if (categoria.getNombreCategoria() != null && !categoria.getNombreCategoria().isBlank()) {
            categoria.setNombreCategoria(categoria.getNombreCategoria());
        }
        if (categoria.getDescripcionCategoria() != null && !categoria.getDescripcionCategoria().isBlank()) {
            categoria.setDescripcionCategoria(categoria.getDescripcionCategoria());
        }
        return categoriaRepository.save(categoria);
    }

    public void eliminarCategoria(ObjectId id){
        if(!categoriaRepository.existsById(id)){
            throw new RuntimeException("No existe una categoria con este id")
        }
        categoriaRepository.deleteById(id);
    }
}