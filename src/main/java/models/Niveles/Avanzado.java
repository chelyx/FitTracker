package models.Niveles;

import models.Nivel;
import models.Rutina;
import models.RutinaSimple;

public class Avanzado implements Nivel {

    public Rutina sugerir(){
        return new RutinaSimple("Dominadas");
    }
}
