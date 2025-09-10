package com.yorsh.APIREST.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.yorsh.APIREST.model.Categoria;

public interface CategoriaRepository extends MongoRepository<Categoria, ObjectId>{
    
}
