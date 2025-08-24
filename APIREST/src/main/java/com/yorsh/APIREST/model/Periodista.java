package com.yorsh.APIREST.model;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "periodistas")
public class Periodista {
    @Id
    private ObjectId id;
    private String nombre;
    private String apellidos;

    @Indexed(unique = true)
    private String correo;

    private String password;
    private String cargo;
    private String fotoPerfil;
    private String rol;
    private boolean activo = true;
    private LocalDate fechaRegistro = LocalDate.now();
}