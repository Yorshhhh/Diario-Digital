package com.yorsh.APIREST.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yorsh.APIREST.model.Noticia;

public interface NoticiaRepository extends MongoRepository<Noticia, String> {
    
}
