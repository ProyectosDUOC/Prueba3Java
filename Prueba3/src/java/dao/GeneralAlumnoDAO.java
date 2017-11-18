/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import modelo.Alumno;

/**
 *
 * @author benja
 */
public interface GeneralAlumnoDAO {
    public abstract ArrayList mostrarDatos();
    public abstract Alumno buscarDatos(int rut) ;
    public abstract int agregar(Alumno alumno);
    public abstract int eliminar(int rut);
    public abstract int actualizar(Alumno alumno); 
}
