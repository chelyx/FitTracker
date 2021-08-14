package entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RutinaSimple implements Rutina{
    private String nombre;
    private Map<Ejercicio, Integer> ejercicios;

    public RutinaSimple(String nombre) {
        this.nombre = nombre;
        this.ejercicios = new HashMap<>();
    }

    public void addEjercicio(Ejercicio ej, Integer reps) {
        this.ejercicios.put(ej, reps);
    }

    public void removeEjercicio(Ejercicio ej) {
        this.ejercicios.remove(ej);
    }

    @Override
    public int getKcal() {
       return this.ejercicios.entrySet().stream()
               .mapToInt((entry) -> entry.getKey().getKcalPorRep() * entry.getValue()).sum();
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
                .mapToInt(e -> e.getKey().getNivelDificultad())
                .sum() / this.ejercicios.entrySet().size();
    }

    @Override
    public List<String> getSubEjercicios() {
        return this.ejercicios.entrySet().stream().map(entry -> entry.getKey().getNombre()).collect(Collectors.toList());
    }

    @Override
    public String getMusculos() {
        return this.ejercicios.entrySet().stream().map(e -> e.getKey().getMusculos()).collect(Collectors.joining(", "));
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }
}
