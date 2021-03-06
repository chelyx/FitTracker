package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@DiscriminatorValue("COMPUESTA")
public class RutinaCompuesta extends Rutina implements Serializable {

    @Column(name="NOMBRE")
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Rutina> rutinas;

    public RutinaCompuesta() {
    }

    public RutinaCompuesta(String nombre) {
        this.nombre = nombre;
        this.rutinas = new ArrayList<Rutina>();
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getKcal() {
        return this.rutinas.stream().mapToInt(r -> r.getKcal()).sum();
    }

    @Override
    public int getTiempo() {
        return this.rutinas.stream().mapToInt(r -> r.getTiempo()).sum();
    }

    @Override
    public int getDificultad() {
        int dif = this.rutinas.stream().mapToInt(r -> r.getDificultad()).sum();
        int total = this.rutinas.size();
        return dif/total;
    }

    @Override
    public List<String> getSubEjercicios() {
        List<List<String>> list = this.rutinas.stream().map(r -> r.getSubEjercicios()).collect(Collectors.toList());
        return list.stream().flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public String getMusculos() {
        return this.rutinas.stream().map(r -> r.getMusculos()).collect(Collectors.joining(", "));
    }

    public void addRutina(Rutina r) {
        this.rutinas.add(r);
    }

    public void removeRutina(String nombre) {
        this.rutinas.removeIf(r -> r.getNombre().equals(nombre));
    }

    @Override
    public void addEjercicio(Ejercicio ejercicio) {
        this.rutinas.forEach(e -> e.addEjercicio(ejercicio));
    }

    @Override
    public void removeEjercicio(Ejercicio ejercicio) {
        this.rutinas.forEach(r -> r.removeEjercicio(ejercicio));
    }
}
