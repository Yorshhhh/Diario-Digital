package com.yorsh.APIREST.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.multipart.MultipartFile;

import com.yorsh.APIREST.model.Noticia;
import com.yorsh.APIREST.service.NoticiaService;

@RestController
@RequestMapping("/api/noticias")
public class NoticiaController {
    @Autowired
    private NoticiaService noticiaService;

    @PostMapping(value = "/publicar-noticia", consumes = { "multipart/form-data" })
    public ResponseEntity<?> publicar(@RequestParam("titular") String titular,
            @RequestParam("lead") String lead,
            @RequestParam("cuerpoNoticia") String cuerpoNoticia,
            @RequestParam("categoriaId") String categoriaId,
            @RequestParam(value = "imagenes", required = false) List<MultipartFile> imagenes,
            @RequestParam(value = "audios", required = false) List<MultipartFile> audios,
            @RequestParam(value = "videos", required = false) List<MultipartFile> videos) {

        try {
            List<String> rutasImagenes = noticiaService.guardarArchivos(imagenes, "imagenes");
            List<String> rutasAudios = noticiaService.guardarArchivos(audios, "audios");
            List<String> rutasVideos = noticiaService.guardarArchivos(videos, "videos");

            Noticia noticia = new Noticia();
            noticia.setTitular(titular);
            noticia.setLead(lead);
            noticia.setCuerpoNoticia(cuerpoNoticia);
            noticia.setCategoriaId(categoriaId);
            noticia.setImagenes(rutasImagenes);
            noticia.setAudios(rutasAudios);
            noticia.setVideos(rutasVideos);
            noticia.setFechaPublicacion(LocalDateTime.now());

            Noticia nueva = noticiaService.publicarNoticia(noticia);

            return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al guardar archivos: " + e.getMessage());
        }
    }

    @GetMapping("listar-noticias")
    public ResponseEntity<List<Noticia>> listarNoticias() {
        return ResponseEntity.ok(noticiaService.listarNoticias());
    }

    @DeleteMapping("/eliminar-noticia/{id}")
    public ResponseEntity<String> eliminarNoticia(@PathVariable String id) {
        noticiaService.eliminarNoticia(id);
        return ResponseEntity.ok("Noticia eliminada con exito!");
    }

    @PostMapping("/incrementar-vistas/{id}")
    public ResponseEntity<Noticia> incrementarVistas(@PathVariable String id) {
        Noticia noticia = noticiaService.incrementarVistas(id);

        return ResponseEntity.ok(noticia);
    }
}
