package managers;

import Repositorios.RutinaRepository;
import entities.Ejercicio;
import entities.Rutina;
import entities.RutinaCompuesta;
import entities.RutinaSimple;

import java.util.List;

public class RutinasManager {
    private static final RutinaRepository rutinasRepository = new RutinaRepository();

    public void agregarEjercicioRutina(String nombreRutina, Ejercicio ejercicio) {
        try {
            Rutina rutina = rutinasRepository.findByNombre(nombreRutina);
            rutina.addEjercicio(ejercicio);
            rutinasRepository.save(rutina);
        } catch (Exception e) {
            System.out.println("La rutina no existe");
            //todo: log mongo
        }
    }

    public void eliminarEjercicioRutina(String nombreRutina, Ejercicio ejercicio) {
        try {
            Rutina rutina = rutinasRepository.findByNombre(nombreRutina);
            rutina.removeEjercicio(ejercicio);
            rutinasRepository.save(rutina);
        } catch (Exception e) {
            System.out.println("La rutina no existe");
            //todo: log mongo
        }
    }

    public void agregarRutinaRutina(String rutinaCompuesta, String nombreNuevaRutina, boolean simple) {
        RutinaCompuesta rutina = (RutinaCompuesta) rutinasRepository.findByNombre(rutinaCompuesta);
        Rutina r = simple ? new RutinaSimple(nombreNuevaRutina) : new RutinaCompuesta(nombreNuevaRutina);
        rutina.addRutina(r);
        rutinasRepository.save(rutina);
    }

    public void eliminarRutinaRutina(String rutinaCompuesta, String rutinaBorrar) {
        RutinaCompuesta rutina = (RutinaCompuesta) rutinasRepository.findByNombre(rutinaCompuesta);
        rutina.removeRutina(rutinaBorrar);
        rutinasRepository.save(rutina);
    }

    public List<Rutina> getRutinas(String usuario) {
        return rutinasRepository.findByUsuario(usuario);
    }
}
