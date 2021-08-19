package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@DiscriminatorValue("SIMPLE")
public class RutinaSimple extends Rutina implements Serializable {
    @Column(name = "NOMBRE")
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Ejercicio> ejercicios;

    public RutinaSimple() {
    }

    public RutinaSimple(String nombre) {
        this.nombre = nombre;
        this.ejercicios = new ArrayList<>();
    }

    @Override
    public int getKcal() {
       return this.ejercicios.stream()
               .mapToInt((entry) -> entry.getKcalPorRep() * entry.getRepeticiones()).sum();
    }

    @Override
    public int getTiempo() {
        return this.ejercicios.stream()
                .mapToInt((entry) -> entry.getDuracionPorRep() * entry.getRepeticiones()).sum();
    }

    @Override
    public int getDificultad() {
        return this.ejercicios.stream()
                .mapToInt(e -> e.getNivelDificultad())
                .sum() / this.ejercicios.size();
    }

    @Override
    public List<String> getSubEjercicios() {
        return this.ejercicios.stream().map(entry -> entry.getNombre()).collect(Collectors.toList());
    }

    @Override
    public String getMusculos() {
        return this.ejercicios.stream().map(e -> e.getMusculos()).collect(Collectors.joining(", "));
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void addEjercicio(Ejercicio ej) {
        this.ejercicios.add(ej);
    }

    @Override
    public void removeEjercicio(Ejercicio ej) {
        this.ejercicios.remove(ej);
    }
}
