package entities;

import entities.Nivel;
import entities.Rutina;
import entities.RutinaSimple;

public class NivelPrincipiante implements Nivel {
    public Rutina sugerir(){
        return new RutinaSimple("Abdominales");
    }
}
