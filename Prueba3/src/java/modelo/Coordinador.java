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
@Table(name = "coordinador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coordinador.findAll", query = "SELECT c FROM Coordinador c")
    , @NamedQuery(name = "Coordinador.findByRutCoordinador", query = "SELECT c FROM Coordinador c WHERE c.rutCoordinador = :rutCoordinador")
    , @NamedQuery(name = "Coordinador.findByDvCoordinador", query = "SELECT c FROM Coordinador c WHERE c.dvCoordinador = :dvCoordinador")
    , @NamedQuery(name = "Coordinador.findByPnombre", query = "SELECT c FROM Coordinador c WHERE c.pnombre = :pnombre")
    , @NamedQuery(name = "Coordinador.findBySnombre", query = "SELECT c FROM Coordinador c WHERE c.snombre = :snombre")
    , @NamedQuery(name = "Coordinador.findByAppaterno", query = "SELECT c FROM Coordinador c WHERE c.appaterno = :appaterno")
    , @NamedQuery(name = "Coordinador.findByApmaterno", query = "SELECT c FROM Coordinador c WHERE c.apmaterno = :apmaterno")
    , @NamedQuery(name = "Coordinador.findByEmail", query = "SELECT c FROM Coordinador c WHERE c.email = :email")})
public class Coordinador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "rut_coordinador")
    private Integer rutCoordinador;
    @Size(max = 1)
    @Column(name = "dv_coordinador")
    private String dvCoordinador;
    @Size(max = 30)
    @Column(name = "pnombre")
    private String pnombre;
    @Size(max = 30)
    @Column(name = "snombre")
    private String snombre;
    @Size(max = 30)
    @Column(name = "appaterno")
    private String appaterno;
    @Size(max = 30)
    @Column(name = "apmaterno")
    private String apmaterno;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "email")
    private String email;

    public Coordinador() {
    }

    public Coordinador(Integer rutCoordinador, String dvCoordinador, String pnombre, String snombre, String appaterno, String apmaterno, String email) {
        this.rutCoordinador = rutCoordinador;
        this.dvCoordinador = dvCoordinador;
        this.pnombre = pnombre;
        this.snombre = snombre;
        this.appaterno = appaterno;
        this.apmaterno = apmaterno;
        this.email = email;
    }

    public Coordinador(Integer rutCoordinador) {
        this.rutCoordinador = rutCoordinador;
    }

    public Integer getRutCoordinador() {
        return rutCoordinador;
    }

    public void setRutCoordinador(Integer rutCoordinador) {
        this.rutCoordinador = rutCoordinador;
    }

    public String getDvCoordinador() {
        return dvCoordinador;
    }

    public void setDvCoordinador(String dvCoordinador) {
        this.dvCoordinador = dvCoordinador;
    }

    public String getPnombre() {
        return pnombre;
    }

    public void setPnombre(String pnombre) {
        this.pnombre = pnombre;
    }

    public String getSnombre() {
        return snombre;
    }

    public void setSnombre(String snombre) {
        this.snombre = snombre;
    }

    public String getAppaterno() {
        return appaterno;
    }

    public void setAppaterno(String appaterno) {
        this.appaterno = appaterno;
    }

    public String getApmaterno() {
        return apmaterno;
    }

    public void setApmaterno(String apmaterno) {
        this.apmaterno = apmaterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutCoordinador != null ? rutCoordinador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coordinador)) {
            return false;
        }
        Coordinador other = (Coordinador) object;
        if ((this.rutCoordinador == null && other.rutCoordinador != null) || (this.rutCoordinador != null && !this.rutCoordinador.equals(other.rutCoordinador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Coordinador[ rutCoordinador=" + rutCoordinador + " ]";
    }
    
}
