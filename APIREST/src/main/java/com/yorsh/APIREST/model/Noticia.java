package com.yorsh.APIREST.model;

import java.time.LocalDateTime;
import java.util.List;

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
    private String id;
    private String titular;
    private String lead;
    private String cuerpoNoticia;
    private List<String> imagenes;
    private List<String> audios;
    private List<String> videos;
    private String categoria;
    private LocalDateTime fechaPublicacion;
    //private Periodista periodista;
}