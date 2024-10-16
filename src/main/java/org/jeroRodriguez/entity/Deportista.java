package org.jeroRodriguez.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "deportistas")
@EntityListeners(DeportistaListener.class)
public class Deportista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private String edad;

    @Column(nullable = false, unique = true)
    private String documentoIdentificacion;

    @Column(nullable = false)
    private String deporte;

    public Deportista() {}

    public Deportista(String nombre, String apellido, String edad, String documentoIdentificacion, String deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documentoIdentificacion = documentoIdentificacion;
        this.deporte = deporte;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDocumentoIdentificacion() {
        return documentoIdentificacion;
    }

    public void setDocumentoIdentificacion(String documentoIdentificacion) {
        this.documentoIdentificacion = documentoIdentificacion;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    @Override
    public String toString() {
        return "Deportista{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", documentoIdentificacion='" + documentoIdentificacion + '\'' +
                ", deporte='" + deporte + '\'' +
                '}';
    }
}
