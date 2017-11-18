/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author benja
 */
@Embeddable
public class DetalleSeccionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "id_seccion")
    private String idSeccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rut_alumno")
    private int rutAlumno;

    public DetalleSeccionPK() {
    }

    public DetalleSeccionPK(String idSeccion, int rutAlumno) {
        this.idSeccion = idSeccion;
        this.rutAlumno = rutAlumno;
    }

    public String getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(String idSeccion) {
        this.idSeccion = idSeccion;
    }

    public int getRutAlumno() {
        return rutAlumno;
    }

    public void setRutAlumno(int rutAlumno) {
        this.rutAlumno = rutAlumno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSeccion != null ? idSeccion.hashCode() : 0);
        hash += (int) rutAlumno;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleSeccionPK)) {
            return false;
        }
        DetalleSeccionPK other = (DetalleSeccionPK) object;
        if ((this.idSeccion == null && other.idSeccion != null) || (this.idSeccion != null && !this.idSeccion.equals(other.idSeccion))) {
            return false;
        }
        if (this.rutAlumno != other.rutAlumno) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.DetalleSeccionPK[ idSeccion=" + idSeccion + ", rutAlumno=" + rutAlumno + " ]";
    }
    
}
