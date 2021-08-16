package Repositorios;

import db.EntityManagerHelper;
import entities.Ejercicio;
import entities.Rutina;

import javax.persistence.Query;
import java.util.List;

public class EjercicioRepository {
    public void save(Ejercicio ejercicio) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.persist(ejercicio);
        EntityManagerHelper.commit();
    }

    public void remove(Ejercicio ejercicio) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().remove(ejercicio);
        EntityManagerHelper.commit();
    }

    public List<Ejercicio> findByRutina(String nombreRutina) {
        List<Ejercicio> lista = null;
        try {
            Query query = EntityManagerHelper.createQuery("select ejer from Rutina r " +
                    "join r.ejercicios ejer " +
                    "where r.nombre = ?1")
                    .setParameter(1, nombreRutina);
            lista = query.getResultList();
        } catch (Exception e) {
            //TODO: mongoDB loggueo
        }
        return lista;
    }

    public List<Ejercicio> findAll() {
        return (List<Ejercicio>) EntityManagerHelper.createQuery("from Ejercicio").getResultList();
    }
}
