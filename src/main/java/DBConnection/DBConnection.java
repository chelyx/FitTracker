package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {

    Connection con;
    public static void main(String[] args) {/*puse un main aca solo para testear esta shit*/
        DBConnection cn = new DBConnection();
        Statement st;
        ResultSet rs;

        try{
        } catch (Exception e){

        }

        try {
            st=cn.con.createStatement();
            rs=st.executeQuery("select * from TEST1");
            while (rs.next()) {
                System.out.println(rs.getString("id")+" " +rs.getString("Nombre")+" " +rs.getString("Contraseña"));
            }
            cn.con.close();
        } catch (Exception e) {
        }

    }
    public DBConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://db4free.net:3306/tpgrp9dds2021","tpgrp9dds2021","38b7315b");
        } catch (Exception e) {
            System.err.println("Error:" +e);
        }
    }
}

