package entities;

import Notificador.Notifier;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "USUARIO")
public class Usuario extends EntidadPersistente{
    @Column(name="USUARIO")
    private String usuario;

    @Column(name="CONTRASEÑA")
    private String password;

    @Column(name="NOMBRE")
    private String nombre;

    @Column(name="APELLIDO")
    private String apellido;

    @Column(name="TELEFONO")
    private Long telefono;

    @Column(name="MAIL")
    private String mail;

    @Column(name="PESO")
    private double peso;

    @Column(name="ALTURA")
    private int altura;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Nivel nivel;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Rutina> misRutinas;

    @OneToMany(cascade = CascadeType.ALL)
    private HashMap<Date, Double> misPesajes;

    @Transient
    private List<Notifier> formasDeNotificar;

    public Usuario() {}

    public Usuario(String usuario, String password, String nombre, String apellido, Long telefono, String mail, Float peso, int altura) {
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.mail = mail;
        this.peso = peso;
        this.altura = altura;
        this.nivel = new NivelPrincipiante();
        this.misRutinas = new ArrayList<>();
        this.misPesajes = new HashMap<Date,Double>();
        this.formasDeNotificar = new ArrayList<>();

    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public String getApellido() {
        return apellido;
    }

    public double getPeso() {
        return peso;
    }

    public int getAltura() {
        return altura;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public List<Rutina> getMisRutinas() {
        return misRutinas;
    }

    public List<Notifier> getFormasDeNotificar() {
        return formasDeNotificar;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getTelefono() {
        return telefono;
    }

    public String getMail() {
        return mail;
    }

    public HashMap<Date,Double> getMisPesajes(){return misPesajes;}

    public void cambiarNivel(Nivel nivel){
        this.nivel = nivel;
    }

    public Rutina obtenerSugerencia(){
        return this.nivel.sugerir();
    }

    public void cargarRutina(Rutina unaRutina){
        this.misRutinas.add(unaRutina);
    }

    public void cargarPesaje(Date fecha,Double pesaje){
        this.misPesajes.put(fecha,pesaje);
    }

    public void dummyUser() {
        this.usuario = "dummy";
        this.password = "pass123";
        this.nombre = "miNombre";
        this.apellido = "miApellido";
        this.telefono = 11111L;
        this.mail = "mail@gmail.com";
        this.peso = 65.0;
        this.altura = 166;
        this.nivel = new NivelPrincipiante();
        this.misRutinas = new ArrayList<>();
        this.misPesajes = new HashMap<Date,Double>();
        this.formasDeNotificar = new ArrayList<>();
    }
    public Usuario dummyUser2()
    {
        Usuario usr = new Usuario();
        usr.usuario = "dummy";
        usr.password= "pass123";
        usr.nombre = "miNombre";
        usr.apellido = "miApellido";
        usr.telefono = +5491124789473l;
        usr.mail = "juanferro1400@gmail.com";
        usr.peso = 65.0;
        usr.altura = 166;
        usr.nivel = new NivelPrincipiante();
        usr.misRutinas = new ArrayList<>();
        usr.misPesajes = new HashMap<Date,Double>();
        usr.formasDeNotificar = new ArrayList<>();
        return usr;
    }
}
