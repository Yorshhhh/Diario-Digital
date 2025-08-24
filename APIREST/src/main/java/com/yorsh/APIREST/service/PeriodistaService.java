package com.yorsh.APIREST.service;

import com.yorsh.APIREST.model.Periodista;
import com.yorsh.APIREST.repository.PeriodistaRepository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PeriodistaService {
    @Autowired
    private PeriodistaRepository periodistaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Periodista crearPeriodista(Periodista periodista) {
        String hashedPassword = passwordEncoder.encode(periodista.getPassword());
        periodista.setPassword(hashedPassword);

        return periodistaRepository.save(periodista);
    }

    public List<Periodista> listarPeriodistas() {
        return periodistaRepository.findAll();
    }

    public Periodista actualizarPeriodista(ObjectId id, Periodista periodista) {
        Periodista existente = periodistaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe un periodista con esta ID"));

        if (periodista.getNombre() != null && !periodista.getNombre().isBlank()) {
            existente.setNombre(periodista.getNombre());
        }
        if (periodista.getApellidos() != null && !periodista.getApellidos().isBlank()) {
            existente.setApellidos(periodista.getApellidos());
        }
        if (periodista.getCorreo() != null && !periodista.getCorreo().isBlank()) {
            existente.setCorreo(periodista.getCorreo());
        }
        if (periodista.getPassword() != null && !periodista.getPassword().isBlank()) {
            String hashedPassword = passwordEncoder.encode(periodista.getPassword());
            existente.setPassword(hashedPassword);
        }

        return periodistaRepository.save(existente);
    }

    public void eliminarPeriodista(ObjectId id) {

        if (!periodistaRepository.existsById(id)) {
            throw new RuntimeException("No existe un usuario con este id");
        }
        periodistaRepository.deleteById(id);
    }
}
