/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import modelo.Justificacion;

/**
 *
 * @author benja
 */
public interface GeneralJustificacionDAO {
    public abstract ArrayList mostrarDatos();
    public abstract Justificacion buscarDatos(int id) ;
    public abstract int agregar(Justificacion justificacion);
    public abstract int eliminar(int id);
    public abstract int actualizar(Justificacion justificacion); 
}
