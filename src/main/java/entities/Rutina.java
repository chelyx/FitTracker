package entities;

import javax.persistence.MappedSuperclass;
import java.util.List;

@MappedSuperclass
public interface Rutina {
    String getNombre();
    int getKcal();
    int getTiempo();
    int getDificultad();
    List<String> getSubEjercicios();
    String getMusculos();
}
