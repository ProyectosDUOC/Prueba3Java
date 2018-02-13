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
@Table(name = "estado_inasistencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoInasistencia.findAll", query = "SELECT e FROM EstadoInasistencia e")
    , @NamedQuery(name = "EstadoInasistencia.findByIdEstadoi", query = "SELECT e FROM EstadoInasistencia e WHERE e.idEstadoi = :idEstadoi")
    , @NamedQuery(name = "EstadoInasistencia.findByNombreEstadoi", query = "SELECT e FROM EstadoInasistencia e WHERE e.nombreEstadoi = :nombreEstadoi")})
public class EstadoInasistencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estadoi")
    private Integer idEstadoi;
    @Size(max = 30)
    @Column(name = "nombre_estadoi")
    private String nombreEstadoi;

    public EstadoInasistencia() {
    }

    public EstadoInasistencia(Integer idEstadoi, String nombreEstadoi) {
        this.idEstadoi = idEstadoi;
        this.nombreEstadoi = nombreEstadoi;
    }

    public EstadoInasistencia(Integer idEstadoi) {
        this.idEstadoi = idEstadoi;
    }

    public Integer getIdEstadoi() {
        return idEstadoi;
    }

    public void setIdEstadoi(Integer idEstadoi) {
        this.idEstadoi = idEstadoi;
    }

    public String getNombreEstadoi() {
        return nombreEstadoi;
    }

    public void setNombreEstadoi(String nombreEstadoi) {
        this.nombreEstadoi = nombreEstadoi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoi != null ? idEstadoi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoInasistencia)) {
            return false;
        }
        EstadoInasistencia other = (EstadoInasistencia) object;
        if ((this.idEstadoi == null && other.idEstadoi != null) || (this.idEstadoi != null && !this.idEstadoi.equals(other.idEstadoi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.EstadoInasistencia[ idEstadoi=" + idEstadoi + " ]";
    }
    
}
