package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue("AVANZADO")
public class NivelAvanzado extends Nivel implements Serializable {
    public Rutina sugerir(){
        return new RutinaSimple("Dominadas");
    }
}
