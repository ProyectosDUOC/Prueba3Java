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
import modelo.EstadoCorreo;
import modelo.EstadoInasistencia;
import modelo.EstadoJustificativo;
import modelo.Motivo;
import modelo.Ramo;
import modelo.Seccion;
import modelo.TipoUsuario;

/**
 *
 * @author benja
 */
public class ClasesConsultas implements GeneralClasesConsultas {

    private ArrayList<Motivo> arrayMotivos = new ArrayList<>();

    @Override
    public ArrayList mostrarMotivos() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");
            Statement statement = connection.createStatement();
            String consultaSQL = "SELECT * FROM motivo;";
            ResultSet results = statement.executeQuery(consultaSQL);
            int id;
            String nombre;
            /*  id_motivo       INT NOT NULL,
                 nombre_motivo   VARCHAR(100)*/
            arrayMotivos.removeAll(arrayMotivos);
            while (results.next()) {
                id = results.getInt("id_motivo");
                nombre = results.getString("nombre_motivo");
                arrayMotivos.add(new Motivo(id, nombre));
            }
            connection.close();
        } catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }
        return arrayMotivos;
    }

    @Override
    public Motivo buscarMotivos(int id) {
        Motivo obj = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");
            /*  id_motivo       INT NOT NULL,
                nombre_motivo   VARCHAR(100)*/
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM motivo WHERE id_motivo=" + id + ";";
            ResultSet results = statement.executeQuery(query);
            int id1;
            String nombre;
            while (results.next()) {
                id1 = results.getInt("id_motivo");
                nombre = results.getString("nombre_motivo");
                if (id1 == id) {
                    obj = new Motivo(id, nombre);
                    break;
                }
            }
            connection.close();
        } catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }
        return obj;
    }

    private ArrayList<Ramo> arrayRamos = new ArrayList<>();

    @Override
    public ArrayList mostrarRamos() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");
            Statement statement = connection.createStatement();
            String consultaSQL = "SELECT * FROM ramo;";
            ResultSet results = statement.executeQuery(consultaSQL);
            String id, nombre;
            /*  id_ramo       VARCHAR(30) NOT NULL,
                 nombre_ramo   VARCHAR(100)*/
            arrayRamos.removeAll(arrayRamos);
            while (results.next()) {
                id = results.getString("id_ramo");
                nombre = results.getString("nombre_ramo");
                arrayRamos.add(new Ramo(id, nombre));
            }
            connection.close();
        } catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }
        return arrayRamos;
    }

    @Override
    public Ramo buscarRamos(String id) {
        Ramo obj = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM ramo WHERE id_ramo='" + id + "';";
            ResultSet results = statement.executeQuery(query);
            String id1, nombre;
            while (results.next()) {
                id1 = results.getString("id_ramo");
                nombre = results.getString("nombre_ramo");
                if (id1.equals(id)) {
                    obj = new Ramo(id, nombre);
                    break;
                }
            }
            connection.close();
        } catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }
        return obj;
    }

    private ArrayList<Seccion> arraySecciones = new ArrayList<>();

    @Override
    public ArrayList mostrarSeccion() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");
            Statement statement = connection.createStatement();
            String consultaSQL = "SELECT * FROM seccion;";
            ResultSet results = statement.executeQuery(consultaSQL);
            int rutDocente;
            String idSeccion, idRamo;
            /*  id_seccion    VARCHAR(30) NOT NULL,
                id_ramo       VARCHAR(30) NOT NULL,
                rut_docente   INT NOT NULL*/
            arraySecciones.removeAll(arraySecciones);
            while (results.next()) {
                idSeccion = results.getString("id_seccion");
                idRamo = results.getString("id_ramo");
                rutDocente = results.getInt("rut_docente");
                arraySecciones.add(new Seccion(idSeccion, idRamo, rutDocente));
            }
            connection.close();
        } catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }
        return arraySecciones;
    }

    @Override
    public Seccion buscarSeccion(String id) {
        Seccion obj = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM seccion WHERE id_seccion='" + id + "';";
            ResultSet results = statement.executeQuery(query);
            int rutDocente;
            String idSeccion, idRamo;
            /*  id_seccion    VARCHAR(30) NOT NULL,
                id_ramo       VARCHAR(30) NOT NULL,
                rut_docente   INT NOT NULL*/
            while (results.next()) {
                idSeccion = results.getString("id_seccion");
                idRamo = results.getString("id_ramo");
                rutDocente = results.getInt("rut_docente");
                if (idSeccion.equals(id)) {
                    obj = new Seccion(idSeccion, idRamo, rutDocente);
                    break;
                }
            }
            connection.close();
        } catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }
        return obj;
    }
    
    public Seccion buscarSeccionRut(int rut) {
        Seccion obj = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM seccion WHERE rut_docente=" + rut + ";";
            ResultSet results = statement.executeQuery(query);
            int rutDocente;
            String idSeccion, idRamo;
            /*  id_seccion    VARCHAR(30) NOT NULL,
                id_ramo       VARCHAR(30) NOT NULL,
                rut_docente   INT NOT NULL*/
            while (results.next()) {
                
                idSeccion = results.getString("id_seccion");
                idRamo = results.getString("id_ramo");
                rutDocente = results.getInt("rut_docente");
                if (rutDocente == rut ) {
                    obj = new Seccion(idSeccion, idRamo, rutDocente);
                    break;
                }
            }
            connection.close();
        } catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }
        return obj;
    }
    private ArrayList<TipoUsuario> arrayTipoUsarios = new ArrayList<>();

    @Override
    public ArrayList mostrarTipoUsuario() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");
            Statement statement = connection.createStatement();
            String consultaSQL = "SELECT * FROM tipo_usuario;";
            ResultSet results = statement.executeQuery(consultaSQL);
            int id;
            String nombre;
            /*  id_tipo_usuario   INT NOT NULL,
                tipou_nombre      VARCHAR(30)*/
            arrayTipoUsarios.removeAll(arrayTipoUsarios);
            while (results.next()) {
                id = results.getInt("id_tipo_usuario");
                nombre = results.getString("tipou_nombre");
                arrayTipoUsarios.add(new TipoUsuario(id, nombre));
            }
            connection.close();
        } catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }
        return arrayTipoUsarios;
    }

    @Override
    public TipoUsuario buscarTipoUsuario(int id) {
        TipoUsuario obj = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM tipo_usuario WHERE id_tipo_usuario=" + id + ";";
            ResultSet results = statement.executeQuery(query);
            int id1;
            String nombre;
            /*  id_tipo_usuario   INT NOT NULL,
                tipou_nombre      VARCHAR(30)*/
            while (results.next()) {
                id1 = results.getInt("id_tipo_usuario");
                nombre = results.getString("tipou_nombre");
                if (id1 == id) {
                    obj = new TipoUsuario(id, nombre);
                    break;
                }
            }
            connection.close();
        } catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }
        return obj;
    }

    private ArrayList<EstadoJustificativo> arrayEstadoJ = new ArrayList<>();

    @Override
    public ArrayList mostrarEstadoJustificativo() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");
            Statement statement = connection.createStatement();
            String consultaSQL = "SELECT * FROM  estado_justificativo;";
            ResultSet results = statement.executeQuery(consultaSQL);
            int id;
            String nombre;
            /* id_estadoj       INT NOT NULL,
                nombre_estadoj   VARCHAR(30)*/
            arrayEstadoJ.removeAll(arrayEstadoJ);
            while (results.next()) {
                id = results.getInt("id_estadoj");
                nombre = results.getString("nombre_estadoj");
                arrayEstadoJ.add(new EstadoJustificativo(id, nombre));
            }
            connection.close();
        } catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }
        return arrayEstadoJ;
    }

    @Override
    public EstadoJustificativo buscarEstadoJustificativo(int id) {
        EstadoJustificativo obj = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM estado_justificativo WHERE id_estadoj=" + id + ";";
            ResultSet results = statement.executeQuery(query);
            int id1;
            String nombre;
            /* id_estadoj       INT NOT NULL,
               nombre_estadoj   VARCHAR(30)*/
            while (results.next()) {
                id1 = results.getInt("id_estadoj");
                nombre = results.getString("nombre_estadoj");
                if (id1 == id) {
                    obj = new EstadoJustificativo(id, nombre);
                    break;
                }
            }
            connection.close();
        } catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }
        return obj;
    }

    private ArrayList<EstadoInasistencia> arrayEstadoI = new ArrayList<>();

    @Override
    public ArrayList mostrarEstadoInasistencia() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");
            Statement statement = connection.createStatement();
            String consultaSQL = "SELECT * FROM  estado_inasistencia;";
            ResultSet results = statement.executeQuery(consultaSQL);
            int id;
            String nombre;
            /* id_estadoi       INT NOT NULL,
                nombre_estadoi   VARCHAR(30)*/
            arrayEstadoI.removeAll(arrayEstadoI);
            while (results.next()) {
                id = results.getInt("id_estadoi");
                nombre = results.getString("nombre_estadoi");
                arrayEstadoI.add(new EstadoInasistencia(id, nombre));
            }
            connection.close();
        } catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }
        return arrayEstadoI;    
    }

    @Override
    public EstadoInasistencia buscarEstadoInasistencia(int id) {
        EstadoInasistencia obj = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM estado_inasistencia WHERE id_estadoi=" + id + ";";
            ResultSet results = statement.executeQuery(query);
            int id1;
            String nombre;
            /* id_estadoj       INT NOT NULL,
               nombre_estadoj   VARCHAR(30)*/
            while (results.next()) {
                id1 = results.getInt("id_estadoi");
                nombre = results.getString("nombre_estadoi");
                if (id1 == id) {
                    obj = new EstadoInasistencia(id, nombre);
                    break;
                }
            }
            connection.close();
        } catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }
        return obj;
    }

    private ArrayList<EstadoCorreo> arrayEstadoC = new ArrayList<>();

    @Override
    public ArrayList mostrarEstadoCorreo() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");
            Statement statement = connection.createStatement();
            String consultaSQL = "SELECT * FROM  estado_correo;";
            ResultSet results = statement.executeQuery(consultaSQL);
            int id;
            String nombre;
            /* CREATE TABLE estado_correo (
               id_estadoc       INT NOT NULL,
               nombre_estadoc   VARCHAR(30)
                                             );*/
            arrayEstadoC.removeAll(arrayEstadoC);
            while (results.next()) {
                id = results.getInt("id_estadoc");
                nombre = results.getString("nombre_estadoc");
                arrayEstadoC.add(new EstadoCorreo(id, nombre));
            }
            connection.close();
        } catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }
        return arrayEstadoC;    
    }

    @Override
    public EstadoCorreo buscarEstadoCorreo(int id) {
          EstadoCorreo obj = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM estado_correo WHERE id_estadoc=" + id + ";";
            ResultSet results = statement.executeQuery(query);
            int id1;
            String nombre;
            /* id_estadoj       INT NOT NULL,
               nombre_estadoj   VARCHAR(30)*/
            while (results.next()) {
                id1 = results.getInt("id_estadoc");
                nombre = results.getString("nombre_estadoc");
                if (id1 == id) {
                    obj = new EstadoCorreo(id, nombre);
                    break;
                }
            }
            connection.close();
        } catch (java.lang.Exception ex) {
            System.out.println("Error: " + ex);
        }
        return obj;
    }

}
