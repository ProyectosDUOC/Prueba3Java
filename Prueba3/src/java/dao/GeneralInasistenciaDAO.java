/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import modelo.Inasistencia;

/**
 *
 * @author carlos
 */
public interface GeneralInasistenciaDAO {
    public abstract ArrayList mostrarDatos();
    public abstract Inasistencia buscar(int idInasistencia);    
    public abstract ArrayList buscarRut(int rutAlumno);
    public abstract int agregar(Inasistencia inasistencia);
    public abstract int eliminar(int idInasistencia);
    public abstract int actualizar(Inasistencia inasistencia); 
    public abstract int actualizarEnviadoAlumnos(int id, int estadoInasistencia); 
}
