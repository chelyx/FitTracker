package managers;

import Repositorios.UsuarioRepository;
import entities.*;

public class UsuarioManager {
    private static final UsuarioRepository userRepo = new UsuarioRepository();
    private static final RutinasManager rutinasManager = new RutinasManager();

    public void registrarUsuario(String usuario, String password, String nombre,
      String apellido, Long telefono, String mail, int altura) throws DatosInvalidosException {
        // logguear inicio mongoDB
        if (usuario.isEmpty() || password.isEmpty() || nombre.isEmpty() || apellido.isEmpty()) {
            throw new DatosInvalidosException("Los datos no son válidos");
        }
        Usuario user = new Usuario(usuario, password, nombre, apellido, telefono, mail, altura);
        userRepo.save(user);
    }

    public void crearRutina(String user, String nombreRutina, boolean simple){
        Usuario usuario = userRepo.findByUsuario(user);
        Rutina rutina = simple ? new RutinaSimple(nombreRutina) : new RutinaCompuesta(nombreRutina);
        try {
            usuario.cargarRutina(rutina);
            userRepo.save(usuario);
        } catch (Exception e) {
            //todo: log mongo
            System.out.println("El usuario no existe");
            throw e;
        }
    }

    public void agregarEjercicioRutina(String user, String nombreRutina, Ejercicio ejercicio) {
        Usuario usuario = userRepo.findByUsuario(user);
        if (usuario != null) {
            rutinasManager.agregarEjercicioRutina(nombreRutina, ejercicio);
        } else {
            //throw new DatosInvalidosException("El usuario es incorrecto.");
        }
    }

}

class DatosInvalidosException extends Exception {
    public DatosInvalidosException(String message) {
        super(message);
    }
}
