package com.yorsh.APIREST.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yorsh.APIREST.model.Noticia;

public interface NoticiaRepository extends MongoRepository<Noticia, String> {
    List<Noticia> findByCategoria(String categoria);
}
