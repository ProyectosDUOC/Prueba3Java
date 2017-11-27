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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import modelo.Inasistencia;

/**
 *
 * @author carlos
 */
public class InasistenciaDAO implements GeneralInasistenciaDAO{

    private ArrayList<Inasistencia> arrayInasistencias = new ArrayList<>();
    private static DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    
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
            String agregarSQL = "INSERT INTO inasistencia (rut_alumno,id_seccion,fecha,id_estadoi) VALUES(" + inasistencia.getRutAlumno() + ",'" + inasistencia.getIdSeccion() + "','" + formatter.format(inasistencia.getFecha()) + "'," + inasistencia.getIdEstadoi() + ");";
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
        int results = 0;

        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");

            Statement statement = connection.createStatement();

            String agregarSQL = "UPDATE inasistencia SET  " + 
                    ",rut_alumno = " + inasistencia.getRutAlumno()+ 
                    ", id_seccion = '"+ inasistencia.getIdSeccion()  +
                    "', fecha = " + inasistencia.getFecha() +
                    ", id_estadoi = " + inasistencia.getIdEstadoi() +
                    " where id_inasistencia = " + inasistencia.getIdInasistencia() + ";";
 
            results = statement.executeUpdate(agregarSQL);

            connection.close();

        } //catching excepcion
        catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }

        return results;
    }

    @Override
    public int actualizarEnviadoAlumnos(int id, int estadoInasistencia) {
         int results = 0;

        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");

            Statement statement = connection.createStatement();

            String agregarSQL = "UPDATE inasistencia SET  " +
                    " id_estadoi = " + estadoInasistencia +
                    " where id_inasistencia = " +id+"";
 
            results = statement.executeUpdate(agregarSQL);

            connection.close();

        } //catching excepcion
        catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }

        return results;
    }

     private ArrayList<Inasistencia> arrayInasistencias2 = new ArrayList<>();
    @Override
    public ArrayList buscarRut(int rutAlumno) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");

            Statement statement = connection.createStatement();

            String consultaSQL = "SELECT * FROM inasistencia WHERE rut_alumno="+rutAlumno;

            ResultSet results = statement.executeQuery(consultaSQL);

            int idInasistencia;
            int rutAlumno2; 
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
            arrayInasistencias2.removeAll(arrayInasistencias2);
            while (results.next()) {
                rutAlumno2 = results.getInt("rut_alumno");
                if (rutAlumno2==rutAlumno) {
                    idInasistencia = results.getInt("id_inasistencia");
                    rutAlumno = results.getInt("rut_alumno");
                    idSeccion = results.getString("id_Seccion");
                    fecha = results.getDate("fecha");
                    idEstadoi = results.getInt("id_estadoi");                
                   arrayInasistencias2.add(new Inasistencia(idInasistencia, rutAlumno, idSeccion, fecha, idEstadoi));
            
                }
            }
            connection.close();
        } catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }
        return arrayInasistencias2;
    }
     
    
    public ArrayList buscarSeccion(String seccion) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");

            Statement statement = connection.createStatement();

            String consultaSQL = "SELECT * FROM inasistencia WHERE id_seccion='"+seccion+"'";

            ResultSet results = statement.executeQuery(consultaSQL);

            int idInasistencia;
            int rutAlumno2; 
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
            arrayInasistencias2.removeAll(arrayInasistencias2);
            while (results.next()) {                
                    idSeccion = results.getString("id_Seccion");
                if (idSeccion.equals(seccion)) {
                    rutAlumno2 = results.getInt("rut_alumno");
                    idInasistencia = results.getInt("id_inasistencia");
                    rutAlumno2 = results.getInt("rut_alumno");
                    fecha = results.getDate("fecha");
                    idEstadoi = results.getInt("id_estadoi");                
                   arrayInasistencias2.add(new Inasistencia(idInasistencia, rutAlumno2, idSeccion, fecha, idEstadoi));
            
                }
            }
            connection.close();
        } catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }
        return arrayInasistencias2;
    }
    public ArrayList buscarNuevos(int rutAlumno) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");

            Statement statement = connection.createStatement();

            String consultaSQL = "SELECT * FROM inasistencia WHERE rut_alumno="+rutAlumno+" and id_estadoi="+0;

            ResultSet results = statement.executeQuery(consultaSQL);

            int idInasistencia;
            int rutAlumno2; 
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
            arrayInasistencias2.removeAll(arrayInasistencias2);
            while (results.next()) {
                rutAlumno2 = results.getInt("rut_alumno");
                if (rutAlumno2==rutAlumno) {
                    idInasistencia = results.getInt("id_inasistencia");
                    rutAlumno = results.getInt("rut_alumno");
                    idSeccion = results.getString("id_Seccion");
                    fecha = results.getDate("fecha");
                    idEstadoi = results.getInt("id_estadoi");                
                   arrayInasistencias2.add(new Inasistencia(idInasistencia, rutAlumno, idSeccion, fecha, idEstadoi));
            
                }
            }
            connection.close();
        } catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }
        return arrayInasistencias2;
    }
    
}
