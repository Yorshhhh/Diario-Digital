package com.yorsh.APIREST.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yorsh.APIREST.model.Noticia;
import com.yorsh.APIREST.repository.NoticiaRepository;

@Service
public class NoticiaService {
    @Autowired
    private NoticiaRepository noticiaRepository;

    public Noticia publicarNoticia(Noticia noticia) {
        return noticiaRepository.save(noticia);
    }

    public List<Noticia> listarNoticias() {
        return noticiaRepository.findAll();
    }

    public List<Noticia> buscarPorCategoria(String categoria){
        return noticiaRepository.findByCategoria(categoria);
    }

    public void eliminarNoticia(String id) {
        noticiaRepository.deleteById(id);
    }
}
