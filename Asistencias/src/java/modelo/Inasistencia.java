/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author benja
 */
@Entity
@Table(name = "inasistencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inasistencia.findAll", query = "SELECT i FROM Inasistencia i")
    , @NamedQuery(name = "Inasistencia.findByIdInasistencia", query = "SELECT i FROM Inasistencia i WHERE i.idInasistencia = :idInasistencia")
    , @NamedQuery(name = "Inasistencia.findByRutAlumno", query = "SELECT i FROM Inasistencia i WHERE i.rutAlumno = :rutAlumno")
    , @NamedQuery(name = "Inasistencia.findByIdSeccion", query = "SELECT i FROM Inasistencia i WHERE i.idSeccion = :idSeccion")
    , @NamedQuery(name = "Inasistencia.findByFecha", query = "SELECT i FROM Inasistencia i WHERE i.fecha = :fecha")
    , @NamedQuery(name = "Inasistencia.findByIdEstadoi", query = "SELECT i FROM Inasistencia i WHERE i.idEstadoi = :idEstadoi")})
public class Inasistencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_inasistencia")
    private Integer idInasistencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rut_alumno")
    private int rutAlumno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "id_seccion")
    private String idSeccion;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estadoi")
    private int idEstadoi;

    public Inasistencia() {
    }

    public Inasistencia(Integer idInasistencia) {
        this.idInasistencia = idInasistencia;
    }

    public Inasistencia(Integer idInasistencia, int rutAlumno, String idSeccion, Date fecha, int idEstadoi) {
        this.idInasistencia = idInasistencia;
        this.rutAlumno = rutAlumno;
        this.idSeccion = idSeccion;
        this.fecha = fecha;
        this.idEstadoi = idEstadoi;
    }

    public Inasistencia(Integer idInasistencia, int rutAlumno, String idSeccion, int idEstadoi) {
        this.idInasistencia = idInasistencia;
        this.rutAlumno = rutAlumno;
        this.idSeccion = idSeccion;
        this.idEstadoi = idEstadoi;
    }

    public Integer getIdInasistencia() {
        return idInasistencia;
    }

    public void setIdInasistencia(Integer idInasistencia) {
        this.idInasistencia = idInasistencia;
    }

    public int getRutAlumno() {
        return rutAlumno;
    }

    public void setRutAlumno(int rutAlumno) {
        this.rutAlumno = rutAlumno;
    }

    public String getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(String idSeccion) {
        this.idSeccion = idSeccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdEstadoi() {
        return idEstadoi;
    }

    public void setIdEstadoi(int idEstadoi) {
        this.idEstadoi = idEstadoi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInasistencia != null ? idInasistencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inasistencia)) {
            return false;
        }
        Inasistencia other = (Inasistencia) object;
        if ((this.idInasistencia == null && other.idInasistencia != null) || (this.idInasistencia != null && !this.idInasistencia.equals(other.idInasistencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Inasistencia[ idInasistencia=" + idInasistencia + " ]";
    }
    
}
