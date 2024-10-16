package org.jeroRodriguez;

import org.jeroRodriguez.application.service.DeporteService;
import org.jeroRodriguez.application.service.DeporteServiceImpl;
import org.jeroRodriguez.domain.Deportista;
import org.jeroRodriguez.infrastructure.repository.DeporteRepository;
import org.jeroRodriguez.infrastructure.repository.DeporteRepositoryImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DeporteRepository repository = new DeporteRepositoryImpl();
        DeporteService service = new DeporteServiceImpl(repository);

        // Registrar deportistas
        service.registrarDeportista(new Deportista(1, "Arle", 20, "Fútbol"));
        service.registrarDeportista(new Deportista(2, "Sofia", 19, "Volley"));
        service.registrarDeportista(new Deportista(3, "Jeronimo", 18,"Fútbol"));

        // Listar todos los deportistas
        List<Deportista> deportistas = service.obtenerTodosLosDeportistas();
        System.out.println("Deportistas registrados:");
        deportistas.forEach(System.out::println);

        // Buscar un deportista por ID
        Deportista deportista = service.obtenerDeportistaPorId(1);
        System.out.println("Deportista con ID 1: " + deportista);
        Deportista deportista3 = service.obtenerDeportistaPorId(3);
        System.out.println("Deportista con ID 3: " + deportista3);

        // Eliminar un deportista
        service.eliminarDeportista(2);
        System.out.println("Deportistas después de eliminar:");
        service.obtenerTodosLosDeportistas().forEach(System.out::println);
    }
}