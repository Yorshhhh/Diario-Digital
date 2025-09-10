package com.yorsh.APIREST.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yorsh.APIREST.model.Noticia;
import com.yorsh.APIREST.repository.NoticiaRepository;

@Service
public class NoticiaService {
    @Value("${multimedia.upload-dir}")
    private String uploadDir;

    @Autowired
    private NoticiaRepository noticiaRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Noticia publicarNoticia(Noticia noticia) {
        return noticiaRepository.save(noticia);
    }

    public List<String> guardarArchivos(List<MultipartFile> archivos, String carpeta) throws IOException {
        List<String> rutas = new ArrayList<>();

        if (archivos != null) {
            File directorio = new File(uploadDir + carpeta);
            if (!directorio.exists()) {
                directorio.mkdirs();
            }
            for (MultipartFile archivo : archivos) {
                String nombreArchivo = System.currentTimeMillis() + "_" + archivo.getOriginalFilename();
                Path ruta = Paths.get(uploadDir + carpeta, nombreArchivo);
                Files.write(ruta, archivo.getBytes());
                rutas.add(ruta.toString());
            }
        }
        return rutas;
    }

    public List<Noticia> listarNoticias() {
        return noticiaRepository.findAll();
    }

    public void eliminarNoticia(String id) {
        noticiaRepository.deleteById(id);
    }

    public Noticia incrementarVistas(String noticiaId) {
        Query query = new Query(Criteria.where("_id").is(noticiaId));
        Update update = new Update().inc("vistas", 1);

        return mongoTemplate.findAndModify(
                query,
                update,
                FindAndModifyOptions.options().returnNew(true),
                Noticia.class);
    }
}
