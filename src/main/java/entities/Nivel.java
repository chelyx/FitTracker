package entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "NIVEL")
@DiscriminatorColumn(name = "DESCRIPCION")
public abstract class Nivel {
    @Id
    @GeneratedValue
    private int id;

    Rutina sugerir(){
        return null;
    }
}
