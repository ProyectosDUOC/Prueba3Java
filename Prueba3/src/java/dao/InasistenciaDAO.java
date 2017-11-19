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
import java.util.Date;
import modelo.Inasistencia;

/**
 *
 * @author carlos
 */
public class InasistenciaDAO implements GeneralInasistenciaDAO{

    private ArrayList<Inasistencia> arrayInasistencias = new ArrayList<>();
    
    @Override
    public ArrayList mostrarDatos() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");

            Statement statement = connection.createStatement();

            String consultaSQL = "SELECT * FROM inasistencia;";

            ResultSet results = statement.executeQuery(consultaSQL);

            int idInasistencia;
            int rutAlumno; 
            String idSeccion;
            Date fecha;
            int idEstadoi;
            
            /* 
            id_inasistencia   INT NOT NULL AUTO_INCREMENT,
            rut_alumno        INT NOT NULL,
            id_seccion    VARCHAR(30) NOT NULL,
            fecha             DATE,
            id_estadoi        INT NOT NULL,
            */
            arrayInasistencias.removeAll(arrayInasistencias);
            while (results.next()) {
                idInasistencia = results.getInt("id_inasistencia");
                rutAlumno = results.getInt("rut_alumno");
                idSeccion = results.getString("id_Seccion");
                fecha = results.getDate("fecha");
                idEstadoi = results.getInt("id_estadoi");
                
                arrayInasistencias.add(new Inasistencia(idInasistencia, rutAlumno, idSeccion, fecha, idEstadoi));
            }
            connection.close();
        } catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }
        return arrayInasistencias;
    }

    @Override
    public Inasistencia buscar(int idInasistencia) {
        Inasistencia obj = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");

            Statement statement = connection.createStatement();
            String query = "SELECT * FROM inasistencia WHERE id_inasistencia = " + idInasistencia + ";";

            ResultSet results = statement.executeQuery(query);

            int idInasistencia1;
            int rutAlumno; 
            String idSeccion;
            Date fecha;
            int idEstadoi;

            while (results.next()) {
                idInasistencia1 = results.getInt("id_inasistencia");
                rutAlumno = results.getInt("rut_alumno");
                idSeccion = results.getString("id_Seccion");
                fecha = results.getDate("fecha");
                idEstadoi = results.getInt("id_estadoi");

                if (idInasistencia1 == idInasistencia) {
                    obj = new Inasistencia(idInasistencia, rutAlumno, idSeccion, fecha, idEstadoi);
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
    public int agregar(Inasistencia inasistencia) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");
            Statement statement = connection.createStatement();
            String agregarSQL = "INSERT INTO inasistencia (rut_alumno,id_seccion,fecha,id_estadoi) VALUES(" + inasistencia.getRutAlumno() + ",'" + inasistencia.getIdSeccion() + "','" + inasistencia.getFecha() + "'," + inasistencia.getIdEstadoi() + ");";
            int results = statement.executeUpdate(agregarSQL);
            connection.close();
            return results;
        } catch (java.lang.Exception ex) {
            return 0;
        }
    }

    @Override
    public int eliminar(int idInasistencia) {
       try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");
            Statement statement = connection.createStatement();
            String query = "DELETE FROM inasistencia WHERE id_inasistencia=" + idInasistencia;
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
    public int actualizar(Inasistencia inasistencia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}