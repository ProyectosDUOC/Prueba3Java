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
@Table(name = "alumno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a")
    , @NamedQuery(name = "Alumno.findByRutAlumno", query = "SELECT a FROM Alumno a WHERE a.rutAlumno = :rutAlumno")
    , @NamedQuery(name = "Alumno.findByDvAlumno", query = "SELECT a FROM Alumno a WHERE a.dvAlumno = :dvAlumno")
    , @NamedQuery(name = "Alumno.findByPnombre", query = "SELECT a FROM Alumno a WHERE a.pnombre = :pnombre")
    , @NamedQuery(name = "Alumno.findBySnombre", query = "SELECT a FROM Alumno a WHERE a.snombre = :snombre")
    , @NamedQuery(name = "Alumno.findByAppaterno", query = "SELECT a FROM Alumno a WHERE a.appaterno = :appaterno")
    , @NamedQuery(name = "Alumno.findByApmaterno", query = "SELECT a FROM Alumno a WHERE a.apmaterno = :apmaterno")
    , @NamedQuery(name = "Alumno.findByEmail", query = "SELECT a FROM Alumno a WHERE a.email = :email")
    , @NamedQuery(name = "Alumno.findByIdCarrera", query = "SELECT a FROM Alumno a WHERE a.idCarrera = :idCarrera")})
public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "rut_alumno")
    private Integer rutAlumno;
    @Size(max = 1)
    @Column(name = "dv_alumno")
    private String dvAlumno;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "id_carrera")
    private String idCarrera;

    public Alumno() {
    }

    public Alumno(Integer rutAlumno) {
        this.rutAlumno = rutAlumno;
    }

    public Alumno(Integer rutAlumno, String idCarrera) {
        this.rutAlumno = rutAlumno;
        this.idCarrera = idCarrera;
    }

    public Integer getRutAlumno() {
        return rutAlumno;
    }

    public void setRutAlumno(Integer rutAlumno) {
        this.rutAlumno = rutAlumno;
    }

    public String getDvAlumno() {
        return dvAlumno;
    }

    public void setDvAlumno(String dvAlumno) {
        this.dvAlumno = dvAlumno;
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

    public String getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(String idCarrera) {
        this.idCarrera = idCarrera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutAlumno != null ? rutAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.rutAlumno == null && other.rutAlumno != null) || (this.rutAlumno != null && !this.rutAlumno.equals(other.rutAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Alumno[ rutAlumno=" + rutAlumno + " ]";
    }
    
}
