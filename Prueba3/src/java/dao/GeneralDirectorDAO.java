/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import modelo.Director;


/**
 *
 * @author benja
 */
public interface GeneralDirectorDAO {
    public abstract ArrayList mostrarDatos();
    public abstract Director buscarDatos(int rut) ;
    public abstract int agregar(Director director);
    public abstract int eliminar(int rut);
    public abstract int actualizar(Director director); 
}
