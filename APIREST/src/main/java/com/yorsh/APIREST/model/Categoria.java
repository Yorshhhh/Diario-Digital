package com.yorsh.APIREST.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "categorias")
public class Categoria {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId categoriaId;
    private String nombreCategoria;
    private String descripcionCategoria;
}
