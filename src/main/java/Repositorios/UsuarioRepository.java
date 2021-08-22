package Repositorios;

import db.EntityManagerHelper;
import entities.Usuario;

import java.util.List;

public class UsuarioRepository  {

   public void save(Usuario usuario) {
       EntityManagerHelper.beginTransaction();
       EntityManagerHelper.persist(usuario);
       EntityManagerHelper.commit();
   }

   public void remove(Usuario usuario) {
       EntityManagerHelper.beginTransaction();
       EntityManagerHelper.getEntityManager().remove(usuario);
       EntityManagerHelper.commit();
   }

   public Usuario findByUsuario(String usuario) {
       return (Usuario) EntityManagerHelper.createQuery("from Usuario where usuario = ?1")
               .setParameter(1, usuario)
               .getSingleResult();
   }

    public Usuario findByUsuarioYContra(String usuario, String contrasenia) {
        return (Usuario) EntityManagerHelper.createQuery("from Usuario where usuario = ?1 and contraseña = ?2")
                .setParameter(1, usuario)
                .setParameter(2, contrasenia)
                .getSingleResult();
    }

   public List<Usuario> findAll() {
       return (List<Usuario>) EntityManagerHelper.createQuery("from Usuario").getResultList();
   }
}
