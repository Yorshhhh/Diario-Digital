package com.yorsh.APIREST.repository;

import com.yorsh.APIREST.model.Periodista;

import java.util.Optional;
import org.bson.types.ObjectId;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PeriodistaRepository extends MongoRepository<Periodista, ObjectId> {
    Optional<Periodista> findByCorreo(String correo);
}