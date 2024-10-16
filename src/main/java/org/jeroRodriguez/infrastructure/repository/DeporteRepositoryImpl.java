package org.jeroRodriguez.infrastructure.repository;

import org.jeroRodriguez.domain.Deportista;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DeporteRepositoryImpl implements DeporteRepository {
    private static final String ARCHIVO = "deportistas.txt";
    private List<Deportista> deportistas;

    public DeporteRepositoryImpl() {
        this.deportistas = leerDeArchivo();
    }

    @Override
    public void guardarDeportista(Deportista deportista) {
        deportistas.add(deportista);
        escribirEnArchivo(deportistas);
    }

    @Override
    public Deportista buscarDeportistaPorId(int id) {
        return deportistas.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Deportista> listarDeportistas() {
        return deportistas;
    }

    @Override
    public void eliminarDeportista(int id) {
        deportistas.removeIf(d -> d.getId() == id);
        escribirEnArchivo(deportistas);
    }

    // Métodos para serialización
    private void escribirEnArchivo(List<Deportista> deportistas) {
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("deportistas.txt"))) {
            for (Deportista deportista : deportistas) {
                writer.writeObject("\n" + deportista.getId() + "," + deportista.getNombre() + "," + deportista.getEdad() + "," + deportista.getDeporte());
            }
            System.out.println("Datos guardados exitosamente en archivo de texto.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Deportista> leerDeArchivo() {
        List<Deportista> deportistas = new ArrayList<>();
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream("deportistas.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                Deportista deportista = new Deportista(
                        Integer.parseInt(partes[0]), // id
                        partes[1],                   // nombre
                        Integer.parseInt(partes[2]),  // edad
                        partes[3]                    // deporte
                );
                deportistas.add(deportista);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return deportistas;
    }
}
