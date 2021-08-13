package Users;

import DBConnection.DBConnection;
import Notificador.Notifier;
import models.Nivel;
import models.Rutina;
import java.sql.*;
import java.util.ArrayList;

public class User {
    Integer id;
    String usuario;
    String contraseña;
    String name;
    String lastName;
    Integer age;
    Long phone;
    String mail;
    Float weight;
    Integer height;
    Nivel nivel;
    ArrayList<Rutina> misRutinas;
    ArrayList<Notifier> FormasDeNotificar;

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
