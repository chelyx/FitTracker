package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "RUTINA")
@DiscriminatorColumn(name = "TIPO")
public abstract class Rutina {
    @Id
    @GeneratedValue
    private int id;

    public void Rutina() {}

    public String getNombre() {
        return null;
    }
    public int getKcal(){
        return 0;
    }
    public int getTiempo(){
        return 0;
    }
    public int getDificultad(){
        return 0;
    }
    public List<String> getSubEjercicios(){
        return null;
    }
    public String getMusculos(){
        return null;
    }
    public void addEjercicio(Ejercicio ej) {}//TODO: revisar rutinas compuestas comportamiento
    public void removeEjercicio(Ejercicio ej){}
}
