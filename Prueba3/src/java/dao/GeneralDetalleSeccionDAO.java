/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import modelo.DetalleSeccion;

/**
 *
 * @author carlos
 */
public interface GeneralDetalleSeccionDAO {
    public abstract ArrayList mostrarDatos();
    public abstract DetalleSeccion buscarDatos(int idDetalleSeccion) ;
    public abstract int agregar(DetalleSeccion detalleSecion);
    public abstract int eliminar(int idDetalleSeccion);
    public abstract int actualizar(DetalleSeccion detalleSecion); 
}
