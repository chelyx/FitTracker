package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Scanner;

@Entity
@DiscriminatorValue("INTERMEDIO")
public class NivelIntermedio extends Nivel {

    public Rutina sugerir(){
        return new RutinaSimple("Gemelos");
    }

    public void mostrarRutina(Rutina r) {
        System.out.println("Rutina: " + r.getNombre()
                + "\nDificultad: " + r.getDificultad()
                +"\nEjercicios: ");
        r.getSubEjercicios().forEach(ej -> {
            System.out.println("    \n"+ej);
        });
    }

    public Rutina crearRutina(String nombre) {
        System.out.println("1- Rutina Simple \n2- Rutina Compuesta");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt() == 1 ? new RutinaSimple(nombre) : new RutinaCompuesta(nombre);
    }
}
