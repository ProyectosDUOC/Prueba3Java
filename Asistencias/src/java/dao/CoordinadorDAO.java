/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Coordinador;

/**
 *
 * @author benja
 */
public class CoordinadorDAO implements GeneralCoordinadorDAO{
     private ArrayList<Coordinador> arrayCoordinadores = new ArrayList<>();
    @Override
    public ArrayList mostrarDatos() {
       try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");

            Statement statement = connection.createStatement();

            String consultaSQL = "SELECT * FROM coordinador;";

            ResultSet results = statement.executeQuery(consultaSQL);

            int rut;
            String dv, pnombre, snombre, appaterno, apmaterno, email;

            /* rut_coordinador   INT NULL,
                dv_coordinador    VARCHAR(1),
                pnombre      VARCHAR(30),
                snombre      VARCHAR(30),
                appaterno    VARCHAR(30),
                apmaterno    VARCHAR(30),
                email        VARCHAR(30),
             */
            arrayCoordinadores.removeAll(arrayCoordinadores);
            while (results.next()) {
                rut = results.getInt("rut_coordinador");
                dv = results.getString("dv_coordinador");
                pnombre = results.getString("pnombre");
                snombre = results.getString("snombre");
                appaterno = results.getString("appaterno");
                apmaterno = results.getString("apmaterno");
                email = results.getString("email");
                arrayCoordinadores.add(new Coordinador(rut, dv, pnombre, snombre, appaterno, apmaterno, email));
            }
            connection.close();
        } catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }
        return arrayCoordinadores;
    }

    @Override
    public Coordinador buscarDatos(int rut) {
        Coordinador obj = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");

            Statement statement = connection.createStatement();
            String query = "SELECT * FROM coordinador WHERE rut_coordinador=" + rut + ";";

            ResultSet results = statement.executeQuery(query);

            int rut1;
            String dv, pnombre, snombre, appaterno, apmaterno, email;

            while (results.next()) {
                rut1 = results.getInt("rut_coordinador");
                dv = results.getString("dv_coordinador");
                pnombre = results.getString("pnombre");
                snombre = results.getString("snombre");
                appaterno = results.getString("appaterno");
                apmaterno = results.getString("apmaterno");
                email = results.getString("email");

                if (rut1 == rut) {
                    obj = new Coordinador(rut1, dv, pnombre, snombre, appaterno, apmaterno, email);
                    break;
                }
            }
            connection.close();
        } catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }
        return obj;
    }

    @Override
    public int agregar(Coordinador coordinador) {
       try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");
            Statement statement = connection.createStatement();
            String agregarSQL = "INSERT INTO coordinador VALUES(" + coordinador.getRutCoordinador()+ ",'" + coordinador.getDvCoordinador()+"','" + coordinador.getPnombre() + "','" + coordinador.getSnombre() + "','" + coordinador.getAppaterno() + "','" + coordinador.getApmaterno() + "','" + coordinador.getEmail() + "');";
            int results = statement.executeUpdate(agregarSQL);
            connection.close();
            return results;
        } catch (java.lang.Exception ex) {
            return 0;
        }
    }

    @Override
    public int eliminar(int rut) {
         try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");
            Statement statement = connection.createStatement();
            String query = "DELETE FROM coordinador WHERE rut_coordinador=" + rut;
            int results = statement.executeUpdate(query);
            connection.close();
            System.out.println("valor---> " + results);
            return results;
        } catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
            return 2;
        }
    }
    @Override
    public int actualizar(Coordinador cordinador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
