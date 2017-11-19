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
import modelo.Docente;

/**
 *
 * @author benja
 */
public class DocenteDAO implements GeneralDocenteDAO {

    private ArrayList<Docente> arrayDocentes = new ArrayList<>();

    @Override
    public ArrayList mostrarDatos() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");

            Statement statement = connection.createStatement();

            String consultaSQL = "SELECT * FROM docente;";

            ResultSet results = statement.executeQuery(consultaSQL);

            int rut;
            String dv, pnombre, snombre, appaterno, apmaterno, email;

            /* rut_docente   INT NULL,
                dv_docente    VARCHAR(1),
                pnombre      VARCHAR(30),
                snombre      VARCHAR(30),
                appaterno    VARCHAR(30),
                apmaterno    VARCHAR(30),
                email        VARCHAR(30),
             */
            arrayDocentes.removeAll(arrayDocentes);
            while (results.next()) {
                rut = results.getInt("rut_docente");
                dv = results.getString("dv_docente");
                pnombre = results.getString("pnombre");
                snombre = results.getString("snombre");
                appaterno = results.getString("appaterno");
                apmaterno = results.getString("apmaterno");
                email = results.getString("email");
                arrayDocentes.add(new Docente(rut, dv, pnombre, snombre, appaterno, apmaterno, email));
            }
            connection.close();
        } catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }
        return arrayDocentes;
    }

    @Override
    public Docente buscarDatos(int rut) {
        Docente obj = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");

            Statement statement = connection.createStatement();
            String query = "SELECT * FROM docente WHERE rut_docente=" + rut + ";";

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
                    obj = new Docente(rut1, dv, pnombre, snombre, appaterno, apmaterno, email);
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
    public int agregar(Docente docente) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");
            Statement statement = connection.createStatement();
            String agregarSQL = "INSERT INTO docente VALUES(" + docente.getRutDocente() + ",'" + docente.getDvDocente() + "','" + docente.getPnombre() + "','" + docente.getSnombre() + "','" + docente.getAppaterno() + "','" + docente.getApmaterno() + "','" + docente.getEmail() + "');";
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
            String query = "DELETE FROM docente WHERE rut_docente=" + rut;
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
    public int actualizar(Docente docente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
