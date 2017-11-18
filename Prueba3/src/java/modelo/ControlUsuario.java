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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author benja
 */
@Entity
@Table(name = "control_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ControlUsuario.findAll", query = "SELECT c FROM ControlUsuario c")
    , @NamedQuery(name = "ControlUsuario.findByIdControl", query = "SELECT c FROM ControlUsuario c WHERE c.idControl = :idControl")
    , @NamedQuery(name = "ControlUsuario.findByUsuario", query = "SELECT c FROM ControlUsuario c WHERE c.usuario = :usuario")
    , @NamedQuery(name = "ControlUsuario.findByClave", query = "SELECT c FROM ControlUsuario c WHERE c.clave = :clave")
    , @NamedQuery(name = "ControlUsuario.findByRutUsuario", query = "SELECT c FROM ControlUsuario c WHERE c.rutUsuario = :rutUsuario")
    , @NamedQuery(name = "ControlUsuario.findByIdTipoUsuario", query = "SELECT c FROM ControlUsuario c WHERE c.idTipoUsuario = :idTipoUsuario")})
public class ControlUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_control")
    private Integer idControl;
    @Size(max = 30)
    @Column(name = "usuario")
    private String usuario;
    @Size(max = 30)
    @Column(name = "clave")
    private String clave;
    @Column(name = "rut_usuario")
    private Integer rutUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_usuario")
    private int idTipoUsuario;

    public ControlUsuario() {
    }

    public ControlUsuario(Integer idControl) {
        this.idControl = idControl;
    }

    public ControlUsuario(Integer idControl, int idTipoUsuario) {
        this.idControl = idControl;
        this.idTipoUsuario = idTipoUsuario;
    }

    public Integer getIdControl() {
        return idControl;
    }

    public void setIdControl(Integer idControl) {
        this.idControl = idControl;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Integer getRutUsuario() {
        return rutUsuario;
    }

    public void setRutUsuario(Integer rutUsuario) {
        this.rutUsuario = rutUsuario;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idControl != null ? idControl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ControlUsuario)) {
            return false;
        }
        ControlUsuario other = (ControlUsuario) object;
        if ((this.idControl == null && other.idControl != null) || (this.idControl != null && !this.idControl.equals(other.idControl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ControlUsuario[ idControl=" + idControl + " ]";
    }
    
}
