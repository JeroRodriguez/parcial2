package org.jeroRodriguez.application.service;

import org.jeroRodriguez.domain.Deportista;
import java.util.List;

public interface DeporteService {
    void registrarDeportista(Deportista deportista);
    Deportista obtenerDeportistaPorId(int id);
    List<Deportista> obtenerTodosLosDeportistas();
    void eliminarDeportista(int id);
}
