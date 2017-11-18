/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author benja
 */
@Entity
@Table(name = "carrera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carrera.findAll", query = "SELECT c FROM Carrera c")
    , @NamedQuery(name = "Carrera.findByIdCarrera", query = "SELECT c FROM Carrera c WHERE c.idCarrera = :idCarrera")
    , @NamedQuery(name = "Carrera.findByNombreCarrera", query = "SELECT c FROM Carrera c WHERE c.nombreCarrera = :nombreCarrera")
    , @NamedQuery(name = "Carrera.findByRutDirector", query = "SELECT c FROM Carrera c WHERE c.rutDirector = :rutDirector")})
public class Carrera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "id_carrera")
    private String idCarrera;
    @Size(max = 300)
    @Column(name = "nombre_carrera")
    private String nombreCarrera;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rut_director")
    private int rutDirector;

    public Carrera() {
    }

    public Carrera(String idCarrera, String nombreCarrera, int rutDirector) {
        this.idCarrera = idCarrera;
        this.nombreCarrera = nombreCarrera;
        this.rutDirector = rutDirector;
    }

    public Carrera(String idCarrera) {
        this.idCarrera = idCarrera;
    }

    public Carrera(String idCarrera, int rutDirector) {
        this.idCarrera = idCarrera;
        this.rutDirector = rutDirector;
    }

    public String getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(String idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public int getRutDirector() {
        return rutDirector;
    }

    public void setRutDirector(int rutDirector) {
        this.rutDirector = rutDirector;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarrera != null ? idCarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrera)) {
            return false;
        }
        Carrera other = (Carrera) object;
        if ((this.idCarrera == null && other.idCarrera != null) || (this.idCarrera != null && !this.idCarrera.equals(other.idCarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Carrera[ idCarrera=" + idCarrera + " ]";
    }
    
}
