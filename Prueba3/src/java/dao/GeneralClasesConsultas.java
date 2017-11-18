/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
public interface GeneralClasesConsultas {

    public abstract ArrayList mostrarMotivos();
    public abstract Motivo buscarMotivos(int id);
    
    public abstract ArrayList mostrarRamos();
    public abstract Ramo buscarRamos(String id); 
    
    public abstract ArrayList mostrarSeccion();
    public abstract Seccion buscarSeccion(String id);
    
    public abstract ArrayList mostrarTipoUsuario();
    public abstract TipoUsuario buscarTipoUsuario(int id);    
    
    public abstract ArrayList mostrarEstadoJustificativo();
    public abstract EstadoJustificativo buscarEstadoJustificativo(int id);
    
    public abstract ArrayList mostrarEstadoInasistencia();
    public abstract EstadoInasistencia buscarEstadoInasistencia(int id);
    
    public abstract ArrayList mostrarEstadoCorreo();
    public abstract EstadoCorreo buscarEstadoCorreo(int id);

    
}
