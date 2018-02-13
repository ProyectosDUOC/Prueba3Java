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
@Table(name = "motivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Motivo.findAll", query = "SELECT m FROM Motivo m")
    , @NamedQuery(name = "Motivo.findByIdMotivo", query = "SELECT m FROM Motivo m WHERE m.idMotivo = :idMotivo")
    , @NamedQuery(name = "Motivo.findByNombreMotivo", query = "SELECT m FROM Motivo m WHERE m.nombreMotivo = :nombreMotivo")})
public class Motivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_motivo")
    private Integer idMotivo;
    @Size(max = 100)
    @Column(name = "nombre_motivo")
    private String nombreMotivo;

    public Motivo() {
    }

    public Motivo(Integer idMotivo, String nombreMotivo) {
        this.idMotivo = idMotivo;
        this.nombreMotivo = nombreMotivo;
    }

    public Motivo(Integer idMotivo) {
        this.idMotivo = idMotivo;
    }

    public Integer getIdMotivo() {
        return idMotivo;
    }

    public void setIdMotivo(Integer idMotivo) {
        this.idMotivo = idMotivo;
    }

    public String getNombreMotivo() {
        return nombreMotivo;
    }

    public void setNombreMotivo(String nombreMotivo) {
        this.nombreMotivo = nombreMotivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMotivo != null ? idMotivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Motivo)) {
            return false;
        }
        Motivo other = (Motivo) object;
        if ((this.idMotivo == null && other.idMotivo != null) || (this.idMotivo != null && !this.idMotivo.equals(other.idMotivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Motivo[ idMotivo=" + idMotivo + " ]";
    }
    
}
