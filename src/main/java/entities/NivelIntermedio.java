package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("INTERMEDIO")
public class NivelIntermedio extends Nivel {

    public Rutina sugerir(){
        return new RutinaSimple("Gemelos");
    }
}
