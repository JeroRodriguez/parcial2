package org.jeroRodriguez.infrastructure.repository;

import org.jeroRodriguez.domain.Deportista;

import java.util.List;

public interface DeporteRepository {
    void guardarDeportista(Deportista deportista);
    Deportista buscarDeportistaPorId(int id);
    List<Deportista> listarDeportistas();
    void eliminarDeportista(int id);
}
