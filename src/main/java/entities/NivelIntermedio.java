package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Scanner;

@Entity
@DiscriminatorValue("INTERMEDIO")
public class NivelIntermedio extends Nivel {

    public Rutina sugerir(){
        Rutina r = new RutinaSimple("Brazos");
        r.addEjercicio(new Ejercicio("Vuelos Laterales", "hombros", 2, 5, 10, 8));
        return r;
    }

    public void mostrarRutina(Rutina r) {
        System.out.println("Rutina: " + r.getNombre()
                + "\nDificultad: " + r.getDificultad());
        if(r.getSubEjercicios().size() > 0) {
            System.out.println("Ejercicios:");
            r.getSubEjercicios().forEach(ej -> {
                System.out.println(ej);
            });
        }
    }

    public Rutina crearRutina(String nombre) {
        System.out.println("1- Rutina Simple \n2- Rutina Compuesta");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt() == 1 ? new RutinaSimple(nombre) : new RutinaCompuesta(nombre);
    }

    public String getNombreNivel(){return "INTERMEDIO";}
}

/*Diciendo que queríamos loguear esa info pero como no se relacionaba
    con el modelo de objetos lo persistimos en mongo
    Y que es bueno para almacenar gran cantidad de info

 */