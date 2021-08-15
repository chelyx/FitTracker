package entities;

import Notificador.Notifier;
import entities.Nivel;
import entities.Rutina;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USUARIO")
public class User extends EntidadPersistente{
    @Column(name="USUARIO")
    private String usuario;

    @Column(name="CONTRASEÑA")
    private String contraseña;

    @Column(name="NOMBRE")
    private String nombre;

    @Column(name="APELLIDO")
    private String apellido;

    @Column(name="TELEFONO")
    private Long telefono;

    @Column(name="MAIL")
    private String mail;

    @Column(name="PESO")
    private Float peso;

    @Column(name="ALTURA")
    private int altura;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Nivel nivel;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Rutina> misRutinas;

    @Transient
    private List<Notifier> formasDeNotificar;

    public User() {}

    public String getNombre() {
        return nombre;
    }

    public Long getTelefono() {
        return telefono;
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
