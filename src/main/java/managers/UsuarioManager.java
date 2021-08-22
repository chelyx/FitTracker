package managers;

import Repositorios.UsuarioRepository;
import entities.*;

public class UsuarioManager {
    private static final UsuarioRepository userRepo = new UsuarioRepository();
    private static final RutinasManager rutinasManager = new RutinasManager();

    public Usuario registrarUsuario(String usuario, String password, String nombre,
      String apellido, Long telefono, String mail, int altura) throws DatosInvalidosException {
        // logguear inicio mongoDB
        if (usuario.isEmpty() || password.isEmpty() || nombre.isEmpty() || apellido.isEmpty()) {
            throw new DatosInvalidosException("Los datos no son válidos");
        }
        Usuario user = new Usuario(usuario, password, nombre, apellido, telefono, mail, altura);
        userRepo.save(user);
        return user;
    }

    public Usuario validarUsuario(String userName, String password) {
        return userRepo.findByUsuarioYContra(userName, password);
    }

    public void crearRutina(String user, String nombreRutina){
        try {
            Usuario usuario = userRepo.findByUsuario(user);
            usuario.cargarRutina(nombreRutina);
            userRepo.save(usuario);
        } catch (Exception e) {
            //todo: log mongo
            System.out.println("El usuario no existe");
            throw e;
        }
    }

    public void agregarEjercicioRutina(String user, String nombreRutina, Ejercicio ejercicio) {
        Usuario usuario = userRepo.findByUsuario(user);
        rutinasManager.agregarEjercicioRutina(nombreRutina, ejercicio);
    }

    public void agregarNuevoPeso(String user, Pesaje peso) {
        Usuario usuario = userRepo.findByUsuario(user);
        usuario.cargarPesaje(peso);
        userRepo.save(usuario);
    }

}

class DatosInvalidosException extends Exception {
    public DatosInvalidosException(String message) {
        super(message);
    }
}
