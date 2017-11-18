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
import modelo.Alumno;

/**
 *
 * @author benja
 */
public class AlumnoDAO implements GeneralAlumnoDAO {

    private ArrayList<Alumno> arrayAlumnos = new ArrayList<>();

    @Override
    public ArrayList mostrarDatos() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");

            Statement statement = connection.createStatement();

            String consultaSQL = "SELECT * FROM alumno;";

            ResultSet results = statement.executeQuery(consultaSQL);

            int rut;
            String dv, pnombre, snombre, appaterno, apmaterno, email, idCarrera;

            /* rut_alumno   INT NULL,
                dv_alumno    VARCHAR(1),
                pnombre      VARCHAR(30),
                snombre      VARCHAR(30),
                appaterno    VARCHAR(30),
                apmaterno    VARCHAR(30),
                email        VARCHAR(30),
                id_carrera   VARCHAR(30) NOT NULL*/
            arrayAlumnos.removeAll(arrayAlumnos);
            while (results.next()) {
                rut = results.getInt("rut_alumno");
                dv = results.getString("dv_alumno");
                pnombre = results.getString("pnombre");
                snombre = results.getString("snombre");
                appaterno = results.getString("appaterno");
                apmaterno = results.getString("apmaterno");
                email = results.getString("emial");
                idCarrera = results.getString("id_carrera");
                arrayAlumnos.add(new Alumno(rut, dv, pnombre, snombre, appaterno, apmaterno, email, idCarrera));
            }
            connection.close();
        } catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }
        return arrayAlumnos;
    }

    @Override
    public Alumno buscarDatos(int rut) {
        Alumno obj = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");

            Statement statement = connection.createStatement();
            String query = "SELECT * FROM alumno WHERE rut_alumno=" + rut + ";";

            ResultSet results = statement.executeQuery(query);

            int rut1;
            String dv, pnombre, snombre, appaterno, apmaterno, email, idCarrera;

            while (results.next()) {
                rut1 = results.getInt("rut_alumno");
                dv = results.getString("dv_alumno");
                pnombre = results.getString("pnombre");
                snombre = results.getString("snombre");
                appaterno = results.getString("appaterno");
                apmaterno = results.getString("apmaterno");
                email = results.getString("emial");
                idCarrera = results.getString("id_carrera");

                if (rut1 == rut) {
                    obj = new Alumno(rut1, dv, pnombre, snombre, appaterno, apmaterno, email, idCarrera);
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
    public int agregar(Alumno alumno) {
        try {
            //Constructor               
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");

            Statement statement = connection.createStatement();
                        
           String agregarSQL="INSERT INTO alumno VALUES("+alumno.getRutAlumno()+",'"+alumno.getDvAlumno()+"','"+alumno.getPnombre()+"','"+alumno.getSnombre()+"','"+alumno.getAppaterno()+"','"+alumno.getApmaterno()+"','"+alumno.getEmail()+"','"+alumno.getIdCarrera()+"');"; 
            int results = statement.executeUpdate(agregarSQL);        
            connection.close();
            return results;
        } 
        catch (java.lang.Exception ex) {
            return 0;
        }
    }

    @Override
    public int eliminar(int rut) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizar(Alumno alumno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
