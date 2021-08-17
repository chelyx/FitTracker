package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "PESAJE")
public class Pesaje extends EntidadPersistente {
    @Column(name = "fecha", columnDefinition = "DATE")
    private LocalDate fecha;
    private Float peso;

    public Pesaje() {
    }

    public Pesaje(LocalDate fecha, Float peso) {
        this.fecha = fecha;
        this.peso = peso;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Float getPeso() {
        return peso;
    }
}
