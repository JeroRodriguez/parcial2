package org.jeroRodriguez.entity;

import jakarta.persistence.*;

public class DeportistaListener {


    @PrePersist
    public void prePersist(Deportista deportista) {
        System.out.println("Deportista a ser persistido: " + deportista);
    }

    @PostPersist
    public void postPersist(Deportista deportista) {
        System.out.println("Deportista persistido: " + deportista);
    }

    @PreUpdate
    public void preUpdate(Deportista deportista) {
        System.out.println("Deportista a ser actualizado: " + deportista);
    }

    @PostUpdate
    public void postUpdate(Deportista deportista) {
        System.out.println("Deportista actualizado: " + deportista);
    }

    @PreRemove
    public void preRemove(Deportista deportista) {
        System.out.println("Deportista a ser eliminado: " + deportista);
    }

    @PostRemove
    public void postRemove(Deportista deportista) {
        System.out.println("Deportista eliminado: " + deportista);
    }
}
