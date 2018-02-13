/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import modelo.Coordinador;

/**
 *
 * @author benja
 */
public interface GeneralCoordinadorDAO {
    public abstract ArrayList mostrarDatos();
    public abstract Coordinador buscarDatos(int rut) ;
    public abstract int agregar(Coordinador cordinador);
    public abstract int eliminar(int rut);
    public abstract int actualizar(Coordinador cordinador); 
}
