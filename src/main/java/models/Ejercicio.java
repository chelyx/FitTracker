package models;

public class Ejercicio {
    String nombre;
    String musculos;
    int nivelDificultad;
    int kcalPorRep;
    int duracionPorRep;

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
}
