package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private Connection con = null;

    private void DBConnection1(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://db4free.net:3306/tpgrp9dds2021","tpgrp9dds2021","38b7315b");
            System.out.println("Conexion exitosa");
        } catch (Exception e) {
            System.err.println("Error en la conexion a la Base de Datos:" +e);
        }
    }

    public Connection getConexion(){
        if (con == null){
            DBConnection1();
        }
        return con;
    }
}

