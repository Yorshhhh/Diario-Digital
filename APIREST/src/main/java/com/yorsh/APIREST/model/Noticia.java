package com.yorsh.APIREST.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    private String categoriaId;
    private List<String> imagenes;
    private List<String> audios;
    private List<String> videos;
    
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime fechaPublicacion;
    private long vistas;
    //private Periodista periodista;
}