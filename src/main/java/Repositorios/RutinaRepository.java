package Repositorios;

import db.EntityManagerHelper;
import entities.Rutina;
import entities.RutinaCompuesta;

import javax.persistence.Query;
import java.util.List;

public class RutinaRepository {

    public void save(Rutina rutina) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.persist(rutina);
        EntityManagerHelper.commit();
    }

    public void remove(Rutina rutina) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().remove(rutina);
        EntityManagerHelper.commit();
    }

    public List<Rutina> findByUsuario(String usuario) {
        List<Rutina> lista = null;
        try {
            Query query = EntityManagerHelper.createQuery("select umr from Usuario u " +
                    "join u.misRutinas umr " +
                    "where u.usuario= ?1")
                    .setParameter(1, usuario);
           lista = query.getResultList();
        } catch (Exception e) {
            //TODO: mongoDB loggueo
        }
        return lista;
    }

    public Rutina findByNombre(String nombre) {
        return (Rutina) EntityManagerHelper.createQuery("from Rutina " +
                "where nombre = ?1").setParameter(1, nombre).getSingleResult();
    }

    public List<Rutina> findAll() {
        return (List<Rutina>) EntityManagerHelper.createQuery("from Rutina").getResultList();
    }
}
