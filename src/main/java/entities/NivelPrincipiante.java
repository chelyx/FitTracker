package entities;

import entities.Nivel;
import entities.Rutina;
import entities.RutinaSimple;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PRINCIPIANTE")
public class NivelPrincipiante extends Nivel {
    public Rutina sugerir(){
        return new RutinaSimple("Abdominales");
    }

    public void mostrarRutina(Rutina r) {
        System.out.println("Rutina: " + r.getNombre());
        if(r.getSubEjercicios().size() > 0) {
            System.out.println("Ejercicios:");
            r.getSubEjercicios().forEach(ej -> {
                System.out.println(ej+"\n");
            });
        }
    }

    public Rutina crearRutina(String nombre) {
        return new RutinaSimple(nombre);
    }
    public String getNombreNivel(){return "PRINCIPIANTE";}
}
