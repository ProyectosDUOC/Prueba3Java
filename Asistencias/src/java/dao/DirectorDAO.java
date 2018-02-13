/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Director;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author benja
 */
public class DirectorDAO implements GeneralDirectorDAO {

    private ArrayList<Director> arrayDirectores = new ArrayList<>();

    @Override
    public ArrayList mostrarDatos() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");

            Statement statement = connection.createStatement();

            String consultaSQL = "SELECT * FROM director;";

            ResultSet results = statement.executeQuery(consultaSQL);

            int rut;
            String dv, pnombre, snombre, appaterno, apmaterno, email;

            /* rut_director   INT NULL,
                dv_director    VARCHAR(1),
                pnombre      VARCHAR(30),
                snombre      VARCHAR(30),
                appaterno    VARCHAR(30),
                apmaterno    VARCHAR(30),
                email        VARCHAR(30),
             */
            arrayDirectores.removeAll(arrayDirectores);
            while (results.next()) {
                rut = results.getInt("rut_director");
                dv = results.getString("dv_director");
                pnombre = results.getString("pnombre");
                snombre = results.getString("snombre");
                appaterno = results.getString("appaterno");
                apmaterno = results.getString("apmaterno");
                email = results.getString("email");
                arrayDirectores.add(new Director(rut, dv, pnombre, snombre, appaterno, apmaterno, email));
            }
            connection.close();
        } catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }
        return arrayDirectores;
    }

    @Override
    public Director buscarDatos(int rut) {
        Director obj = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");

            Statement statement = connection.createStatement();
            String query = "SELECT * FROM director WHERE rut_director=" + rut + ";";

            ResultSet results = statement.executeQuery(query);

            int rut1;
            String dv, pnombre, snombre, appaterno, apmaterno, email;

            while (results.next()) {
                rut1 = results.getInt("rut_alumno");
                dv = results.getString("dv_alumno");
                pnombre = results.getString("pnombre");
                snombre = results.getString("snombre");
                appaterno = results.getString("appaterno");
                apmaterno = results.getString("apmaterno");
                email = results.getString("email");

                if (rut1 == rut) {
                    obj = new Director(rut1, dv, pnombre, snombre, appaterno, apmaterno, email);
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
    public int agregar(Director director) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");
            Statement statement = connection.createStatement();
            String agregarSQL = "INSERT INTO director VALUES(" + director.getRutDirector()+ ",'" + director.getDvDirector()+ "','" + director.getPnombre() + "','" + director.getSnombre() + "','" + director.getAppaterno() + "','" + director.getApmaterno() + "','" + director.getEmail() + "');";
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
            String query = "DELETE FROM director WHERE rut_director=" + rut;
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
    public int actualizar(Director director) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
