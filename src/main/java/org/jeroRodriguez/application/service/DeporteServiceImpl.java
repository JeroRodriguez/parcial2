package org.jeroRodriguez.application.service;


import org.jeroRodriguez.domain.Deportista;
import org.jeroRodriguez.infrastructure.repository.DeporteRepository;

import java.util.List;

public class DeporteServiceImpl implements DeporteService {
    private DeporteRepository repository;

    public DeporteServiceImpl(DeporteRepository repository) {
        this.repository = repository;
    }

    @Override
    public void registrarDeportista(Deportista deportista) {
        repository.guardarDeportista(deportista);
    }

    @Override
    public Deportista obtenerDeportistaPorId(int id) {
        return repository.buscarDeportistaPorId(id);
    }

    @Override
    public List<Deportista> obtenerTodosLosDeportistas() {
        return repository.listarDeportistas();
    }

    @Override
    public void eliminarDeportista(int id) {
        repository.eliminarDeportista(id);
    }
}
