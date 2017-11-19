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
import modelo.Justificacion;

/**
 *
 * @author benja
 */
public class JustificacionDAO implements GeneralJustificacionDAO {

    private ArrayList<Justificacion> arrayJustificaciones = new ArrayList<>();

    @Override
    public ArrayList mostrarDatos() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");

            Statement statement = connection.createStatement();

            String consultaSQL = "SELECT * FROM justificacion;";

            ResultSet results = statement.executeQuery(consultaSQL);

            int idIna, idMotivo, idEstadoJ, idEstadoC;
            Date fecha_envio;
            String glosa;

            /* CREATE TABLE justificacion (
                id_inasistencia   INT NOT NULL,
                fecha_envio                    DATE,
                id_motivo                      INT NOT NULL,
                glosa                          VARCHAR(300),
                id_estadoj                     INT NOT NULL,
                id_estadoc                     INT NOT NULL,
                PRIMARY KEY (id_inasistencia)
);
             */
            arrayJustificaciones.removeAll(arrayJustificaciones);
            while (results.next()) {
                idIna = results.getInt("id_inasistencia");
                fecha_envio = results.getDate("fecha_envio");
                idMotivo = results.getInt("id_motivo");
                glosa = results.getString("glosa");
                idEstadoJ = results.getInt("id_estadoj");
                idEstadoC = results.getInt("id_estadoc");

                arrayJustificaciones.add(new Justificacion(idIna, fecha_envio, idMotivo, glosa, idEstadoJ, idEstadoC));
            }
            connection.close();
        } catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }
        return arrayJustificaciones;
    }

    @Override
    public Justificacion buscarDatos(int id) {
        Justificacion obj = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");

            Statement statement = connection.createStatement();
            String query = "SELECT * FROM justificacion WHERE id_inasistencia=" + id + ";";

            ResultSet results = statement.executeQuery(query);

            int idIna, idMotivo, idEstadoJ, idEstadoC;
            Date fecha_envio;
            String glosa;

            while (results.next()) {
                idIna = results.getInt("id_inasistencia");
                fecha_envio = results.getDate("fecha_envio");
                idMotivo = results.getInt("id_motivo");
                glosa = results.getString("glosa");
                idEstadoJ = results.getInt("id_estadoj");
                idEstadoC = results.getInt("id_estadoc");

                if (idIna == id) {
                    obj = new Justificacion(idIna, fecha_envio, idMotivo, glosa, idEstadoJ, idEstadoC);
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
    public int agregar(Justificacion justificacion) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");
            Statement statement = connection.createStatement();
            String agregarSQL = "INSERT INTO justificacion VALUES(" + justificacion.getIdInasistencia()+ ",'" + justificacion.getFechaEnvio() + "'," + justificacion.getIdMotivo() + ",'" + justificacion.getGlosa() + "'," + justificacion.getIdEstadoj() + "," + justificacion.getIdEstadoc()+");";
            int results = statement.executeUpdate(agregarSQL);
            connection.close();
            return results;
        } catch (java.lang.Exception ex) {
            return 0;
        }
    }

    @Override
    public int eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizar(Justificacion justificacion) {
        int results = 0;

        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");

            Statement statement = connection.createStatement();
            /*
            String agregarSQL = "UPDATE justificacion SET  " + 
                    ",rut_alumno = " + inasistencia.getRutAlumno()+ 
                    ", id_seccion = '"+ inasistencia.getIdSeccion()  +
                    "', fecha = " + inasistencia.getFecha() +
                    ", id_estadoi = " + inasistencia.getIdEstadoi() +
                    " where id_inasistencia = " + inasistencia.getIdInasistencia() + " ";
            
            results = statement.executeUpdate(agregarSQL);*/

            connection.close();

        } //catching excepcion
        catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }

        return results;
    }

}
