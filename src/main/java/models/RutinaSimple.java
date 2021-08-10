package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RutinaSimple implements Rutina{
    String nombre;
    Map<Ejercicio, Integer> ejercicios;

    public RutinaSimple(String nombre) {
        this.nombre = nombre;
        this.ejercicios = new HashMap<>();
    }

    public void addEjercicio(Ejercicio ej, Integer reps) {
        this.ejercicios.put(ej, reps);
    }

    @Override
    public int getKcal() {
       return this.ejercicios.entrySet().stream()
               .mapToInt((entry) -> entry.getKey().kcalPorRep * entry.getValue()).sum();
    }

    @Override
    public int getTiempo() {
        return this.ejercicios.entrySet().stream()
                .mapToInt((entry) -> entry.getKey().getDuracionPorRep() * entry.getValue()).sum();
    }

    @Override
    public int getDificultad() {
        return this.ejercicios.entrySet()
                .stream()
                .mapToInt(e -> e.getKey().nivelDificultad)
                .sum() / this.ejercicios.entrySet().size();
    }

    @Override
    public List<Ejercicio> getSubEjercicios() {
        return this.ejercicios.entrySet().stream().map(entry -> entry.getKey()).collect(Collectors.toList());
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }
}
