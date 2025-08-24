package com.yorsh.APIREST.model;

import com.yorsh.APIREST.model.Periodista;

import java.util.List;
import org.bson.types.ObjectId;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "noticias")
public class Noticia {
    @Id
    private ObjectId id;
    private String titular;
    private String cuerpoNoticia;
    private List<String> imagenes;
    private List<String> audios;
    private List<String> videos;
    private String categoria;
    private Periodista periodista;
}