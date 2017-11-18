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
@Table(name = "docente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docente.findAll", query = "SELECT d FROM Docente d")
    , @NamedQuery(name = "Docente.findByRutDocente", query = "SELECT d FROM Docente d WHERE d.rutDocente = :rutDocente")
    , @NamedQuery(name = "Docente.findByDvDocente", query = "SELECT d FROM Docente d WHERE d.dvDocente = :dvDocente")
    , @NamedQuery(name = "Docente.findByPnombre", query = "SELECT d FROM Docente d WHERE d.pnombre = :pnombre")
    , @NamedQuery(name = "Docente.findBySnombre", query = "SELECT d FROM Docente d WHERE d.snombre = :snombre")
    , @NamedQuery(name = "Docente.findByAppaterno", query = "SELECT d FROM Docente d WHERE d.appaterno = :appaterno")
    , @NamedQuery(name = "Docente.findByApmaterno", query = "SELECT d FROM Docente d WHERE d.apmaterno = :apmaterno")
    , @NamedQuery(name = "Docente.findByEmail", query = "SELECT d FROM Docente d WHERE d.email = :email")})
public class Docente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "rut_docente")
    private Integer rutDocente;
    @Size(max = 1)
    @Column(name = "dv_docente")
    private String dvDocente;
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

    public Docente(Integer rutDocente, String dvDocente, String pnombre, String snombre, String appaterno, String apmaterno, String email) {
        this.rutDocente = rutDocente;
        this.dvDocente = dvDocente;
        this.pnombre = pnombre;
        this.snombre = snombre;
        this.appaterno = appaterno;
        this.apmaterno = apmaterno;
        this.email = email;
    }

    public Docente() {
    }

    public Docente(Integer rutDocente) {
        this.rutDocente = rutDocente;
    }

    public Integer getRutDocente() {
        return rutDocente;
    }

    public void setRutDocente(Integer rutDocente) {
        this.rutDocente = rutDocente;
    }

    public String getDvDocente() {
        return dvDocente;
    }

    public void setDvDocente(String dvDocente) {
        this.dvDocente = dvDocente;
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
        hash += (rutDocente != null ? rutDocente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docente)) {
            return false;
        }
        Docente other = (Docente) object;
        if ((this.rutDocente == null && other.rutDocente != null) || (this.rutDocente != null && !this.rutDocente.equals(other.rutDocente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Docente[ rutDocente=" + rutDocente + " ]";
    }
    
}
