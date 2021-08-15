package entities;

import javax.persistence.*;

@Entity
@Table(name = "EJERCICIO")
public class Ejercicio extends EntidadPersistente{
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "MUSCULOS")
    private String musculos;
    @Column(name = "DIFICULTAD")
    private int nivelDificultad;
    @Column(name = "KCAL_REP")
    private int kcalPorRep;
    @Column(name = "DUR_REP")
    private int duracionPorRep;
    @Column(name = "REPETICIONES")
    private int repeticiones;

    public Ejercicio() {}

    public Ejercicio(String nombre, String musculo, int nivelDificultad, int kcalPorRep, int duracionPorRep, int repeticiones) {
        this.nombre = nombre;
        this.musculos = musculo;
        this.nivelDificultad = nivelDificultad;
        this.kcalPorRep = kcalPorRep;
        this.duracionPorRep = duracionPorRep;
        this.repeticiones = repeticiones;
    }

    public String getMusculos() {
        return musculos;
    }

    public int getNivelDificultad() {
        return nivelDificultad;
    }

    public int getKcalPorRep() {
        return kcalPorRep;
    }

    public int getDuracionPorRep() {
        return duracionPorRep;
    }

    public String getNombre() {
        return nombre;
    }

    public int getRepeticiones() {
        return repeticiones;
    }
}
