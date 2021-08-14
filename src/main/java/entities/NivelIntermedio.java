package entities;

public class NivelIntermedio implements Nivel {

    public Rutina sugerir(){
        return new RutinaSimple("Gemelos");
    }
}
