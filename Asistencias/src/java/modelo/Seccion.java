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
@Table(name = "seccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seccion.findAll", query = "SELECT s FROM Seccion s")
    , @NamedQuery(name = "Seccion.findByIdSeccion", query = "SELECT s FROM Seccion s WHERE s.idSeccion = :idSeccion")
    , @NamedQuery(name = "Seccion.findByIdRamo", query = "SELECT s FROM Seccion s WHERE s.idRamo = :idRamo")
    , @NamedQuery(name = "Seccion.findByRutDocente", query = "SELECT s FROM Seccion s WHERE s.rutDocente = :rutDocente")})
public class Seccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "id_seccion")
    private String idSeccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "id_ramo")
    private String idRamo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rut_docente")
    private int rutDocente;

    public Seccion() {
    }

    public Seccion(String idSeccion) {
        this.idSeccion = idSeccion;
    }

    public Seccion(String idSeccion, String idRamo, int rutDocente) {
        this.idSeccion = idSeccion;
        this.idRamo = idRamo;
        this.rutDocente = rutDocente;
    }

    public String getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(String idSeccion) {
        this.idSeccion = idSeccion;
    }

    public String getIdRamo() {
        return idRamo;
    }

    public void setIdRamo(String idRamo) {
        this.idRamo = idRamo;
    }

    public int getRutDocente() {
        return rutDocente;
    }

    public void setRutDocente(int rutDocente) {
        this.rutDocente = rutDocente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSeccion != null ? idSeccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seccion)) {
            return false;
        }
        Seccion other = (Seccion) object;
        if ((this.idSeccion == null && other.idSeccion != null) || (this.idSeccion != null && !this.idSeccion.equals(other.idSeccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Seccion[ idSeccion=" + idSeccion + " ]";
    }
    
}
