package managers;

import Repositorios.RutinaRepository;
import entities.Ejercicio;
import entities.Rutina;

public class RutinasManager {
    private static final RutinaRepository rutinasRepository = new RutinaRepository();

    public void crearRutina() {

    }

    public void agregarEjercicioRutina(String nombreRutina, Ejercicio ejercicio) {
        Rutina rutina = rutinasRepository.findByNombre(nombreRutina);
        if (rutina != null) {
            rutina.addEjercicio(ejercicio);
            rutinasRepository.save(rutina);
        } else {
            System.out.println("La rutina no existe");
            //todo: log mongo
        }
    }

    public void eliminarEjercicioRutina(String nombreRutina, Ejercicio ejercicio) {
        Rutina rutina = rutinasRepository.findByNombre(nombreRutina);
        if (rutina != null) {
            rutina.removeEjercicio(ejercicio);
            rutinasRepository.save(rutina);
        } else {
            System.out.println("La rutina no existe");
            //todo: log mongo
        }
    }

    public void agregarRutinaRutina(String rutinaCompuesta, String nombreNuevaRutina) {
        Rutina rutina = rutinasRepository.findByNombre(rutinaCompuesta);
        //rutina.addRutina();
    }
}
