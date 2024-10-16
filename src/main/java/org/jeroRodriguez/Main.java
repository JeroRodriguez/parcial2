package org.jeroRodriguez;

import org.jeroRodriguez.entity.Deportista;
import org.jeroRodriguez.service.DeportistaService;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final DeportistaService deportistaService = new DeportistaService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- CRUD de Deportistas ---");
            System.out.println("1. Crear deportista");
            System.out.println("2. Leer deportista");
            System.out.println("3. Actualizar deportista");
            System.out.println("4. Eliminar deportista");
            System.out.println("5. Listar todos los deportistas");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1 -> crearDeportista();
                case 2 -> leerDeportista();
                case 3 -> actualizarDeportista();
                case 4 -> eliminarDeportista();
                case 5 -> listarDeportista();
                case 6 -> salir = true;
                default -> System.out.println("Opción no válida");
            }
        }
        deportistaService.cerrar();
        scanner.close();
    }

    private static void crearDeportista() {
        System.out.print("Nombre del deportista: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido del deportista: ");
        String apellido = scanner.next();
        System.out.print("Edad del deportista: ");
        String edad = scanner.next();
        System.out.print("Documento del deportista: ");
        String documentoIdentificacion = scanner.next();
        System.out.print("Deporte que practica el deportista: ");
        String deporte = scanner.next();

        Deportista deportista = new Deportista();
        deportista.setNombre(nombre);
        deportista.setApellido(apellido);
        deportista.setEdad(edad);
        deportista.setDocumentoIdentificacion(documentoIdentificacion);
        deportista.setDeporte(deporte);

        deportistaService.crearDeportista(deportista);
        System.out.println("Deportista creado con éxito");
    }

    private static void leerDeportista() {
        System.out.print("ID del deportista: ");
        Long id = scanner.nextLong();
        Deportista deportista = deportistaService.obtenerDeportista(id);
        if (deportista != null) {
            System.out.println(deportista);
        } else {
            System.out.println("Deportista no encontrado");
        }
    }

    private static void actualizarDeportista() {
        System.out.print("ID del deportista a actualizar: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consumir el salto de línea

        Deportista deportista = deportistaService.obtenerDeportista(id);
        if (deportista != null) {
            System.out.print("Nuevo nombre (deje en blanco para mantener el actual): ");
            String nombre = scanner.nextLine();
            if (!nombre.isEmpty()) {
                deportista.setNombre(nombre);
            }

            System.out.print("Nuevo Apellido (deje en blanco para mantener el actual): ");
            String apellido = scanner.nextLine();
            if (!apellido.isEmpty()) {
                deportista.setApellido(apellido);
            }

            System.out.print("Nueva Edad (deje en blanco para mantener el actual): ");
            String edad = scanner.nextLine();
            if (!edad.isEmpty()) {
                deportista.setEdad(edad);
            }

            System.out.print("Nuevo Documento de Identificacion (deje en blanco para mantener el actual): ");
            String documentoIdentificacion = scanner.nextLine();
            if (!documentoIdentificacion.isEmpty()) {
                deportista.setDocumentoIdentificacion(documentoIdentificacion);
            }

            System.out.print("Nuevo Deporte (deje en blanco para mantener el actual): ");
            String deporte = scanner.nextLine();
            if (!deporte.isEmpty()) {
                deportista.setDeporte(deporte);
            }

            deportistaService.actualizarDeportista(deportista);
            System.out.println("Deportista actualizado con éxito");
        } else {
            System.out.println("Deportista no encontrado");
        }
    }

    private static void eliminarDeportista() {
        System.out.print("ID del deportista a eliminar: ");
        Long id = scanner.nextLong();
        deportistaService.eliminarDeportista(id);
        System.out.println("Deportista eliminado con éxito");
    }

    private static void listarDeportista() {
        List<Deportista> deportistas = deportistaService.obtenerTodosLosDeportistas();
        if (deportistas.isEmpty()) {
            System.out.println("No hay Deportistas registrados");
        } else {
            for (Deportista deportista : deportistas) {
                System.out.println(deportista);
            }
        }
    }
}