package entities;

import Notificador.Notificador;
import com.twilio.rest.api.v2010.account.availablephonenumbercountry.Local;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;

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

    @Column(name="ALTURA")
    private int altura;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Nivel nivel;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Rutina> misRutinas;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Pesaje> misPesajes;

    @Transient
    private List<Notificador> formasDeNotificar;

    public Usuario() {}

    public Usuario(String usuario, String password, String nombre, String apellido, Long telefono, String mail, int altura) {
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.mail = mail;
        this.altura = altura;
        this.nivel = new NivelPrincipiante();
        this.misRutinas = new ArrayList<>();
        this.misPesajes = new ArrayList<>();
        this.formasDeNotificar = new ArrayList<>();

    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getAltura() {
        return altura;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public List<Rutina> getMisRutinas() {
        return misRutinas;
    }

    public List<Notificador> getFormasDeNotificar() {
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

    public List<Pesaje> getMisPesajes(){return misPesajes;}

    public void cambiarNivel(Nivel nivel){
        this.nivel = nivel;
    }

    public Rutina obtenerSugerencia(){
        return this.nivel.sugerir();
    }

    public void displayRutina(Rutina r) {
     this.nivel.mostrarRutina(r);
    }

    public Rutina cargarRutina(String nombre){
        Rutina r = this.nivel.crearRutina(nombre);
        this.misRutinas.add(r);
        return r;
    }

    public void cargarPesaje(Pesaje peso){
        this.misPesajes.add(peso);
    }

    public int diasUltimoPesaje() throws ParseException {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd");
        LocalDate fechaActual = LocalDate.now();
        misPesajes.sort(Comparator.comparing(Pesaje::getFecha));
        Pesaje ultPesaje = misPesajes.get(0) ;
        Date ultimoPesaje  = date.parse(ultPesaje.getFecha().toString());
        Date hoy = date.parse(fechaActual.toString() );
        return (int) ((hoy.getTime()-ultimoPesaje.getTime()) / (TimeUnit.DAYS.toMillis(1)+1));
    }

    public Float pesoActual(){
       return (this.misPesajes.get(this.misPesajes.size()-1)).getPeso();
    }

    public Usuario dummyUser() {
        this.usuario = "dummy";
        this.password = "pass123";
        this.nombre = "miNombre";
        this.apellido = "miApellido";
        this.telefono = 11111L;
        this.mail = "mail@gmail.com";
        this.altura = 166;
        this.nivel = new NivelPrincipiante();
        this.misRutinas = new ArrayList<>();
        this.misPesajes = new ArrayList<>();
        this.formasDeNotificar = new ArrayList<>();
        return this;
    }
    public Usuario dummyUser2() {
        Usuario usr = new Usuario();
        usr.usuario = "dummy";
        usr.password= "pass123";
        usr.nombre = "miNombre";
        usr.apellido = "miApellido";
        usr.telefono = +5491124789473l;
        usr.mail = "juanferro1400@gmail.com";
        usr.altura = 166;
        usr.nivel = new NivelPrincipiante();
        usr.misRutinas = new ArrayList<>();
        usr.misPesajes = new ArrayList<>();
        usr.formasDeNotificar = new ArrayList<>();
        return usr;
    }
}
