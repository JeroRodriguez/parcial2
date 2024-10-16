package org.jeroRodriguez.service;

import org.jeroRodriguez.entity.Deportista;
import org.jeroRodriguez.repository.DeporteRepository;

import java.util.List;

public class DeportistaService {

    private final DeporteRepository repository;

    public DeportistaService() {
        this.repository = new DeporteRepository();
    }

    public void crearDeportista(Deportista deportista) {
        repository.crear(deportista);
    }

    public Deportista obtenerDeportista(Long id) {
        return repository.leer(id);
    }

    public List<Deportista> obtenerTodosLosDeportistas() {
        return repository.leerTodos();
    }

    public void actualizarDeportista(Deportista deportista) {
        repository.actualizar(deportista);
    }

    public void eliminarDeportista(Long id) {
        repository.eliminar(id);
    }

    public void cerrar() {
        repository.cerrar();
    }
}
