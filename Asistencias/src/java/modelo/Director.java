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
@Table(name = "director")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Director.findAll", query = "SELECT d FROM Director d")
    , @NamedQuery(name = "Director.findByRutDirector", query = "SELECT d FROM Director d WHERE d.rutDirector = :rutDirector")
    , @NamedQuery(name = "Director.findByDvDirector", query = "SELECT d FROM Director d WHERE d.dvDirector = :dvDirector")
    , @NamedQuery(name = "Director.findByPnombre", query = "SELECT d FROM Director d WHERE d.pnombre = :pnombre")
    , @NamedQuery(name = "Director.findBySnombre", query = "SELECT d FROM Director d WHERE d.snombre = :snombre")
    , @NamedQuery(name = "Director.findByAppaterno", query = "SELECT d FROM Director d WHERE d.appaterno = :appaterno")
    , @NamedQuery(name = "Director.findByApmaterno", query = "SELECT d FROM Director d WHERE d.apmaterno = :apmaterno")
    , @NamedQuery(name = "Director.findByEmail", query = "SELECT d FROM Director d WHERE d.email = :email")})
public class Director implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "rut_director")
    private Integer rutDirector;
    @Size(max = 1)
    @Column(name = "dv_director")
    private String dvDirector;
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

    public Director() {
    }

    public Director(Integer rutDirector, String dvDirector, String pnombre, String snombre, String appaterno, String apmaterno, String email) {
        this.rutDirector = rutDirector;
        this.dvDirector = dvDirector;
        this.pnombre = pnombre;
        this.snombre = snombre;
        this.appaterno = appaterno;
        this.apmaterno = apmaterno;
        this.email = email;
    }

    public Director(Integer rutDirector) {
        this.rutDirector = rutDirector;
    }

    public Integer getRutDirector() {
        return rutDirector;
    }

    public void setRutDirector(Integer rutDirector) {
        this.rutDirector = rutDirector;
    }

    public String getDvDirector() {
        return dvDirector;
    }

    public void setDvDirector(String dvDirector) {
        this.dvDirector = dvDirector;
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
        hash += (rutDirector != null ? rutDirector.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Director)) {
            return false;
        }
        Director other = (Director) object;
        if ((this.rutDirector == null && other.rutDirector != null) || (this.rutDirector != null && !this.rutDirector.equals(other.rutDirector))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Director[ rutDirector=" + rutDirector + " ]";
    }
    
}
