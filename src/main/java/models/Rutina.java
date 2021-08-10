package models;

import java.util.List;

public interface Rutina {
    String getNombre();
    int getKcal();
    int getTiempo();
    int getDificultad();
    List<Ejercicio> getSubEjercicios();
}
