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
import modelo.ControlUsuario;

/**
 *
 * @author benja
 */
public class ControlUsuarioDAO implements GeneralControlUDAO {

    private ArrayList<ControlUsuario> arrayControlU = new ArrayList<>();

    @Override
    public ArrayList mostrarDatos() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");

            Statement statement = connection.createStatement();

            String consultaSQL = "SELECT * FROM alumno;";

            ResultSet results = statement.executeQuery(consultaSQL);

            int rut, id, tipo_usuario;
            String usuario, clave;

            /*  id_control        INT NOT NULL AUTO_INCREMENT,
                usuario           VARCHAR(30),
                clave             VARCHAR(30),
                rut_usuario       INT,
                id_tipo_usuario   INT NOT NULL,
                PRIMARY KEY (id_control)*/
            arrayControlU.removeAll(arrayControlU);
            while (results.next()) {
                rut = results.getInt("rut_usuario");
                id = results.getInt("id_control");
                usuario = results.getString("usuario");
                clave = results.getString("clave");  
                tipo_usuario = results.getInt("id_tipo_usuario");
                arrayControlU.add(new ControlUsuario(id, usuario, clave, rut, tipo_usuario));
            }
            connection.close();
        } catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }
        return arrayControlU;
    }

    @Override
    public ControlUsuario buscarDatos(int rut) {
        ControlUsuario obj = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");

            Statement statement = connection.createStatement();
            String query = "SELECT * FROM control_usuario WHERE rut_usuario=" + rut + ";";

            ResultSet results = statement.executeQuery(query);

            int rut1, id, tipo_usuario;
            String usuario, clave;


            while (results.next()) {              
                rut1 = results.getInt("rut_usuario");
                id = results.getInt("id_control");
                usuario = results.getString("usuario");
                clave = results.getString("clave");  
                tipo_usuario = results.getInt("id_tipo_usuario");

                if (rut1 == rut) {
                    obj = new ControlUsuario(id,usuario, clave, rut1, tipo_usuario);
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
    public ControlUsuario buscarDatosLogin(String username) {
         ControlUsuario obj = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");

            Statement statement = connection.createStatement();
            String query = "SELECT * FROM control_usuario WHERE usuario='" + username + "';";

            ResultSet results = statement.executeQuery(query);

            int rut1, id, tipo_usuario;
            String usuario1, clave;


            while (results.next()) {              
                rut1 = results.getInt("rut_usuario");
                id = results.getInt("id_control");
                usuario1 = results.getString("usuario");
                clave = results.getString("clave");  
                tipo_usuario = results.getInt("id_tipo_usuario");

                if (usuario1.equals(username)) {
                    obj = new ControlUsuario(id,usuario1, clave, rut1, tipo_usuario);
                    break;
                }
            }
            connection.close();
        } catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }
        return obj;   }

    @Override
    public int agregar(ControlUsuario control) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(int rut) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizar(ControlUsuario control) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
