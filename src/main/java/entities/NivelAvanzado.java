package entities;

public class NivelAvanzado implements Nivel {

    public Rutina sugerir(){
        return new RutinaSimple("Dominadas");
    }
}
