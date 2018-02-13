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
import modelo.DetalleSeccion;

/**
 *
 * @author carlos
 */
public class DetalleSeccionDAO implements GeneralDetalleSeccionDAO{

    private ArrayList<DetalleSeccion> arrayDetalleSecciones = new ArrayList<>();
    
    @Override
    public ArrayList mostrarDatos() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");

            Statement statement = connection.createStatement();

            String consultaSQL = "SELECT * FROM detalle_seccion;";

            ResultSet results = statement.executeQuery(consultaSQL);

            int idDetalleSeccion;
            String idSeccion;
            int rutAlumno;
            int anio;
            int semestre;
            
            /*
            id_detalle_seccion INT NOT NULL AUTO_INCREMENT,
            id_seccion   VARCHAR(30) NOT NULL,
            rut_alumno   INT NOT NULL,
            anio         INT,
            semestre     INT
            
            */
            arrayDetalleSecciones.removeAll(arrayDetalleSecciones);
            while (results.next()) {
                idDetalleSeccion = results.getInt("id_detalle_seccion");
                idSeccion = results.getString("id_seccion");
                rutAlumno = results.getInt("rut_alumno");
                anio = results.getInt("anio");
                semestre = results.getInt("semestre");
                arrayDetalleSecciones.add(new DetalleSeccion(idDetalleSeccion ,idSeccion, rutAlumno, anio, semestre));
            }
            connection.close();
        } catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }
        return arrayDetalleSecciones;
    }

    @Override
    public DetalleSeccion buscarDatos(int idDetalleSeccion) {
        DetalleSeccion obj = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");

            Statement statement = connection.createStatement();
            String query = "SELECT * FROM detalle_seccion WHERE id_detalle_seccion =" + idDetalleSeccion + ";";

            ResultSet results = statement.executeQuery(query);

            int idDetalleSeccion1;
            String idSeccion;
            int rutAlumno;
            int anio;
            int semestre;

            while (results.next()) {
                idDetalleSeccion1 = results.getInt("id_detalle_seccion");
                idSeccion = results.getString("id_seccion");
                rutAlumno = results.getInt("rut_alumno");
                anio = results.getInt("anio");
                semestre = results.getInt("semestre");

                if ( idDetalleSeccion1 == idDetalleSeccion ) {
                    obj = new DetalleSeccion(idDetalleSeccion ,idSeccion, rutAlumno, anio, semestre);
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
    public int agregar(DetalleSeccion detalleSecion) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");
            Statement statement = connection.createStatement();
            String agregarSQL = "INSERT INTO detalle_seccion (id_seccion,rut_alumno,anio,semestre) VALUES('" + detalleSecion.getIdSeccion() + "','" + detalleSecion.getRutAlumno() + "','" + detalleSecion.getAnio() + "','" + detalleSecion.getSemestre() + "');";
            int results = statement.executeUpdate(agregarSQL);
            connection.close();
            return results;
        } catch (java.lang.Exception ex) {
            return 0;
        }
    }

    @Override
    public int eliminar(int idDetalleSeccion) {
       try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");
            Statement statement = connection.createStatement();
            String query = "DELETE FROM detalle_seccion WHERE id_detalle_seccion =" + idDetalleSeccion ;
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
    public int actualizar(DetalleSeccion detalleSecion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
