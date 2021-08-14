package entities;

import Notificador.Notifier;
import entities.Nivel;
import entities.Rutina;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;

@Entity
@Table(name = "usuarios")
public class User extends EntidadPersistente{
    @Column
    private String usuario;
    @Column
    private String contraseña;
    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    private Long phone;
    @Column
    private String mail;
    @Column
    private Float weight;
    @Column
    private int height;

    @Transient
    private Nivel nivel;
    @Transient
    private ArrayList<Rutina> misRutinas;
    @Transient
    private ArrayList<Notifier> formasDeNotificar;

    public User() {}

    public String getName() {
        return name;
    }

    public Long getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    public void cambiarNivel(Nivel nivel){
        this.nivel = nivel;
    }

    public Rutina obtenerSugerencia(){
        return this.nivel.sugerir();
    }

    private void cargarRutina(Rutina unaRutina){
        this.misRutinas.add(unaRutina);
    }

}
