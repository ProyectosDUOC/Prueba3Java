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
@Table(name = "ramo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ramo.findAll", query = "SELECT r FROM Ramo r")
    , @NamedQuery(name = "Ramo.findByIdRamo", query = "SELECT r FROM Ramo r WHERE r.idRamo = :idRamo")
    , @NamedQuery(name = "Ramo.findByNombreRamo", query = "SELECT r FROM Ramo r WHERE r.nombreRamo = :nombreRamo")})
public class Ramo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "id_ramo")
    private String idRamo;
    @Size(max = 100)
    @Column(name = "nombre_ramo")
    private String nombreRamo;

    public Ramo() {
    }

    public Ramo(String idRamo) {
        this.idRamo = idRamo;
    }

    public String getIdRamo() {
        return idRamo;
    }

    public void setIdRamo(String idRamo) {
        this.idRamo = idRamo;
    }

    public String getNombreRamo() {
        return nombreRamo;
    }

    public void setNombreRamo(String nombreRamo) {
        this.nombreRamo = nombreRamo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRamo != null ? idRamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ramo)) {
            return false;
        }
        Ramo other = (Ramo) object;
        if ((this.idRamo == null && other.idRamo != null) || (this.idRamo != null && !this.idRamo.equals(other.idRamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Ramo[ idRamo=" + idRamo + " ]";
    }
    
}
