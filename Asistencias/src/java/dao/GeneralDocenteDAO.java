/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import modelo.Docente;


/**
 *
 * @author benja
 */
public interface GeneralDocenteDAO {     
    public abstract ArrayList mostrarDatos();
    public abstract Docente buscarDatos(int rut) ;
    public abstract int agregar(Docente docente);
    public abstract int eliminar(int rut);
    public abstract int actualizar(Docente docente); 
}
