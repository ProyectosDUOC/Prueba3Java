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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
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
    , @NamedQuery(name = "DetalleSeccion.findByIdDetalleSeccion", query = "SELECT d FROM DetalleSeccion d WHERE d.idDetalleSeccion = :idDetalleSeccion")
    , @NamedQuery(name = "DetalleSeccion.findByIdSeccion", query = "SELECT d FROM DetalleSeccion d WHERE d.idSeccion = :idSeccion")
    , @NamedQuery(name = "DetalleSeccion.findByRutAlumno", query = "SELECT d FROM DetalleSeccion d WHERE d.rutAlumno = :rutAlumno")
    , @NamedQuery(name = "DetalleSeccion.findByAnio", query = "SELECT d FROM DetalleSeccion d WHERE d.anio = :anio")
    , @NamedQuery(name = "DetalleSeccion.findBySemestre", query = "SELECT d FROM DetalleSeccion d WHERE d.semestre = :semestre")})
public class DetalleSeccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_seccion")
    private Integer idDetalleSeccion;
    @Size(max = 30)
    @Column(name = "id_seccion")
    private String idSeccion;
    @Column(name = "rut_alumno")
    private Integer rutAlumno;
    @Column(name = "anio")
    private Integer anio;
    @Column(name = "semestre")
    private Integer semestre;

    public DetalleSeccion() {
    }

    public DetalleSeccion(Integer idDetalleSeccion, String idSeccion, Integer rutAlumno, Integer anio, Integer semestre) {
        this.idDetalleSeccion = idDetalleSeccion;
        this.idSeccion = idSeccion;
        this.rutAlumno = rutAlumno;
        this.anio = anio;
        this.semestre = semestre;
    }

    public DetalleSeccion(Integer idDetalleSeccion) {
        this.idDetalleSeccion = idDetalleSeccion;
    }

    public Integer getIdDetalleSeccion() {
        return idDetalleSeccion;
    }

    public void setIdDetalleSeccion(Integer idDetalleSeccion) {
        this.idDetalleSeccion = idDetalleSeccion;
    }

    public String getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(String idSeccion) {
        this.idSeccion = idSeccion;
    }

    public Integer getRutAlumno() {
        return rutAlumno;
    }

    public void setRutAlumno(Integer rutAlumno) {
        this.rutAlumno = rutAlumno;
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
        hash += (idDetalleSeccion != null ? idDetalleSeccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleSeccion)) {
            return false;
        }
        DetalleSeccion other = (DetalleSeccion) object;
        if ((this.idDetalleSeccion == null && other.idDetalleSeccion != null) || (this.idDetalleSeccion != null && !this.idDetalleSeccion.equals(other.idDetalleSeccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.DetalleSeccion[ idDetalleSeccion=" + idDetalleSeccion + " ]";
    }
    
}
