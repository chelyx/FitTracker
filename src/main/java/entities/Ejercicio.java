package entities;

import javax.persistence.*;

@Entity
@Table(name = "ejercicio")
public class Ejercicio extends EntidadPersistente{
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "musculos")
    private String musculos;
    @Column(name = "dificultad")
    private int nivelDificultad;
    @Column(name = "kcal")
    private int kcalPorRep;
    @Column(name = "duracion")
    private int duracionPorRep;

    public Ejercicio() {}

    public Ejercicio(String nombre, String musculo, int nivelDificultad, int kcalPorRep, int duracionPorRep) {
        this.nombre = nombre;
        this.musculos = musculo;
        this.nivelDificultad = nivelDificultad;
        this.kcalPorRep = kcalPorRep;
        this.duracionPorRep = duracionPorRep;
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
}
