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
@Table(name = "estado_correo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoCorreo.findAll", query = "SELECT e FROM EstadoCorreo e")
    , @NamedQuery(name = "EstadoCorreo.findByIdEstadoc", query = "SELECT e FROM EstadoCorreo e WHERE e.idEstadoc = :idEstadoc")
    , @NamedQuery(name = "EstadoCorreo.findByNombreEstadoc", query = "SELECT e FROM EstadoCorreo e WHERE e.nombreEstadoc = :nombreEstadoc")})
public class EstadoCorreo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estadoc")
    private Integer idEstadoc;
    @Size(max = 30)
    @Column(name = "nombre_estadoc")
    private String nombreEstadoc;

    public EstadoCorreo() {
    }

    public EstadoCorreo(Integer idEstadoc, String nombreEstadoc) {
        this.idEstadoc = idEstadoc;
        this.nombreEstadoc = nombreEstadoc;
    }

    public EstadoCorreo(Integer idEstadoc) {
        this.idEstadoc = idEstadoc;
    }

    public Integer getIdEstadoc() {
        return idEstadoc;
    }

    public void setIdEstadoc(Integer idEstadoc) {
        this.idEstadoc = idEstadoc;
    }

    public String getNombreEstadoc() {
        return nombreEstadoc;
    }

    public void setNombreEstadoc(String nombreEstadoc) {
        this.nombreEstadoc = nombreEstadoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoc != null ? idEstadoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoCorreo)) {
            return false;
        }
        EstadoCorreo other = (EstadoCorreo) object;
        if ((this.idEstadoc == null && other.idEstadoc != null) || (this.idEstadoc != null && !this.idEstadoc.equals(other.idEstadoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.EstadoCorreo[ idEstadoc=" + idEstadoc + " ]";
    }
    
}
