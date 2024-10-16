package org.jeroRodriguez.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.jeroRodriguez.entity.Deportista;

import java.util.List;

public class DeporteRepository {

    private final EntityManagerFactory emf;

    public DeporteRepository() {

        emf = Persistence.createEntityManagerFactory("deportistaPU");
    }

    public void crear(Deportista deportista) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(deportista);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Deportista leer(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Deportista.class, id);
        } finally {
            em.close();
        }
    }

    public List<Deportista> leerTodos() {
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT p FROM Deportista p", Deportista.class)
                    .getResultList();
        }
    }

    public void actualizar(Deportista deportista) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(deportista);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void eliminar(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Deportista deportista = em.find(Deportista.class, id);
            if (deportista != null) {
                em.remove(deportista);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void cerrar() {
        emf.close();
    }
}
