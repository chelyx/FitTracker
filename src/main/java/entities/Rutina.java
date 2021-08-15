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

    String getNombre() {
        return null;
    }
    int getKcal(){
        return 0;
    }
    int getTiempo(){
        return 0;
    }
    int getDificultad(){
        return 0;
    }
    List<String> getSubEjercicios(){
        return null;
    }
    String getMusculos(){
        return null;
    }
}
