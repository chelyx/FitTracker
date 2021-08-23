package entities;

import Repositorios.EjercicioRepository;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

@Entity
@DiscriminatorValue("AVANZADO")
public class NivelAvanzado extends Nivel implements Serializable {
    private static final EjercicioRepository ejerciciosRepo = new EjercicioRepository();

    public Rutina sugerir(){
        return new RutinaCompuesta("Dominadas");
    }

    public void mostrarRutina(Rutina r) {
        List<Ejercicio> ejercicios = ejerciciosRepo.findByRutina(r.getNombre());
        System.out.println("Rutina: " + r.getNombre()
                + "\nDificultad: " + r.getDificultad()
                + "\nMúsculos: " + r.getMusculos()
                + "\nCalorías quemadas: " + r.getKcal()
                + "\nTiempo estimado: " + r.getTiempo());
        if(ejercicios.size() > 0) {
            System.out.println("Ejercicios:");
            ejercicios.forEach(e -> {
                System.out.println(e.getNombre()
                        + ": \nRepeticiones" + e.getRepeticiones()
                        + ": \nMúsculos" + e.getMusculos()
                        + ": \nDificultad" + e.getNivelDificultad());
            });
        }

    }

    public Rutina crearRutina(String nombre) {
        System.out.println("1- Rutina Simple \n2- Rutina Compuesta");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt() == 1 ? new RutinaSimple(nombre) : new RutinaCompuesta(nombre);
    }

    public String getNombreNivel(){return "AVANZADO";}
}
