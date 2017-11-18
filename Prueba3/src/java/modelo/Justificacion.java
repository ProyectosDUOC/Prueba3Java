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
@Table(name = "justificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Justificacion.findAll", query = "SELECT j FROM Justificacion j")
    , @NamedQuery(name = "Justificacion.findByIdInasistencia", query = "SELECT j FROM Justificacion j WHERE j.idInasistencia = :idInasistencia")
    , @NamedQuery(name = "Justificacion.findByFechaEnvio", query = "SELECT j FROM Justificacion j WHERE j.fechaEnvio = :fechaEnvio")
    , @NamedQuery(name = "Justificacion.findByIdMotivo", query = "SELECT j FROM Justificacion j WHERE j.idMotivo = :idMotivo")
    , @NamedQuery(name = "Justificacion.findByGlosa", query = "SELECT j FROM Justificacion j WHERE j.glosa = :glosa")
    , @NamedQuery(name = "Justificacion.findByIdEstadoj", query = "SELECT j FROM Justificacion j WHERE j.idEstadoj = :idEstadoj")
    , @NamedQuery(name = "Justificacion.findByIdEstadoc", query = "SELECT j FROM Justificacion j WHERE j.idEstadoc = :idEstadoc")})
public class Justificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_inasistencia")
    private Integer idInasistencia;
    @Column(name = "fecha_envio")
    @Temporal(TemporalType.DATE)
    private Date fechaEnvio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_motivo")
    private int idMotivo;
    @Size(max = 300)
    @Column(name = "glosa")
    private String glosa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estadoj")
    private int idEstadoj;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estadoc")
    private int idEstadoc;

    public Justificacion() {
    }

    public Justificacion(Integer idInasistencia) {
        this.idInasistencia = idInasistencia;
    }

    public Justificacion(Integer idInasistencia, int idMotivo, int idEstadoj, int idEstadoc) {
        this.idInasistencia = idInasistencia;
        this.idMotivo = idMotivo;
        this.idEstadoj = idEstadoj;
        this.idEstadoc = idEstadoc;
    }

    public Integer getIdInasistencia() {
        return idInasistencia;
    }

    public void setIdInasistencia(Integer idInasistencia) {
        this.idInasistencia = idInasistencia;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public int getIdMotivo() {
        return idMotivo;
    }

    public void setIdMotivo(int idMotivo) {
        this.idMotivo = idMotivo;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public int getIdEstadoj() {
        return idEstadoj;
    }

    public void setIdEstadoj(int idEstadoj) {
        this.idEstadoj = idEstadoj;
    }

    public int getIdEstadoc() {
        return idEstadoc;
    }

    public void setIdEstadoc(int idEstadoc) {
        this.idEstadoc = idEstadoc;
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
        if (!(object instanceof Justificacion)) {
            return false;
        }
        Justificacion other = (Justificacion) object;
        if ((this.idInasistencia == null && other.idInasistencia != null) || (this.idInasistencia != null && !this.idInasistencia.equals(other.idInasistencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Justificacion[ idInasistencia=" + idInasistencia + " ]";
    }
    
}
