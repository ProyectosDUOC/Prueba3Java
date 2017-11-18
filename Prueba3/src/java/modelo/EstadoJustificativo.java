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
@Table(name = "estado_justificativo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoJustificativo.findAll", query = "SELECT e FROM EstadoJustificativo e")
    , @NamedQuery(name = "EstadoJustificativo.findByIdEstadoj", query = "SELECT e FROM EstadoJustificativo e WHERE e.idEstadoj = :idEstadoj")
    , @NamedQuery(name = "EstadoJustificativo.findByNombreEstadoj", query = "SELECT e FROM EstadoJustificativo e WHERE e.nombreEstadoj = :nombreEstadoj")})
public class EstadoJustificativo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estadoj")
    private Integer idEstadoj;
    @Size(max = 30)
    @Column(name = "nombre_estadoj")
    private String nombreEstadoj;

    public EstadoJustificativo() {
    }

    public EstadoJustificativo(Integer idEstadoj) {
        this.idEstadoj = idEstadoj;
    }

    public Integer getIdEstadoj() {
        return idEstadoj;
    }

    public void setIdEstadoj(Integer idEstadoj) {
        this.idEstadoj = idEstadoj;
    }

    public String getNombreEstadoj() {
        return nombreEstadoj;
    }

    public void setNombreEstadoj(String nombreEstadoj) {
        this.nombreEstadoj = nombreEstadoj;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoj != null ? idEstadoj.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoJustificativo)) {
            return false;
        }
        EstadoJustificativo other = (EstadoJustificativo) object;
        if ((this.idEstadoj == null && other.idEstadoj != null) || (this.idEstadoj != null && !this.idEstadoj.equals(other.idEstadoj))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.EstadoJustificativo[ idEstadoj=" + idEstadoj + " ]";
    }
    
}
