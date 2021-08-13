package models.Niveles;

import models.Nivel;
import models.Rutina;
import models.RutinaSimple;

public class Principiante implements Nivel {
    public Rutina sugerir(){
        return new RutinaSimple("Abdominales");
    }
}
