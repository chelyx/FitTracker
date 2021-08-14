package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="rutina_compuesta")
public class RutinaCompuesta implements Rutina {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String nombre;
    @Transient
    private List<Rutina> rutinas;

    public RutinaCompuesta(String nombre) {
        this.nombre = nombre;
        this.rutinas = new ArrayList<Rutina>();
    }

    public void add(Rutina r) {
        this.rutinas.add(r);
    }

    public void remove(Rutina r) {
        this.rutinas.remove(r);
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
}