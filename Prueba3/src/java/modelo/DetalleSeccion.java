/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author benja
 */
@Entity
@Table(name = "detalle_seccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleSeccion.findAll", query = "SELECT d FROM DetalleSeccion d")
    , @NamedQuery(name = "DetalleSeccion.findByIdSeccion", query = "SELECT d FROM DetalleSeccion d WHERE d.detalleSeccionPK.idSeccion = :idSeccion")
    , @NamedQuery(name = "DetalleSeccion.findByRutAlumno", query = "SELECT d FROM DetalleSeccion d WHERE d.detalleSeccionPK.rutAlumno = :rutAlumno")
    , @NamedQuery(name = "DetalleSeccion.findByAnio", query = "SELECT d FROM DetalleSeccion d WHERE d.anio = :anio")
    , @NamedQuery(name = "DetalleSeccion.findBySemestre", query = "SELECT d FROM DetalleSeccion d WHERE d.semestre = :semestre")})
public class DetalleSeccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleSeccionPK detalleSeccionPK;
    @Column(name = "anio")
    private Integer anio;
    @Column(name = "semestre")
    private Integer semestre;

    public DetalleSeccion() {
    }

    public DetalleSeccion(DetalleSeccionPK detalleSeccionPK) {
        this.detalleSeccionPK = detalleSeccionPK;
    }

    public DetalleSeccion(String idSeccion, int rutAlumno) {
        this.detalleSeccionPK = new DetalleSeccionPK(idSeccion, rutAlumno);
    }

    public DetalleSeccionPK getDetalleSeccionPK() {
        return detalleSeccionPK;
    }

    public void setDetalleSeccionPK(DetalleSeccionPK detalleSeccionPK) {
        this.detalleSeccionPK = detalleSeccionPK;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleSeccionPK != null ? detalleSeccionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleSeccion)) {
            return false;
        }
        DetalleSeccion other = (DetalleSeccion) object;
        if ((this.detalleSeccionPK == null && other.detalleSeccionPK != null) || (this.detalleSeccionPK != null && !this.detalleSeccionPK.equals(other.detalleSeccionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.DetalleSeccion[ detalleSeccionPK=" + detalleSeccionPK + " ]";
    }
    
}
