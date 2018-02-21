/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.InputStream;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "inasistencia_imagen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InasistenciaImagen.findAll", query = "SELECT i FROM InasistenciaImagen i")
    , @NamedQuery(name = "InasistenciaImagen.findByIdInasistencia", query = "SELECT i FROM InasistenciaImagen i WHERE i.idInasistencia = :idInasistencia")
    , @NamedQuery(name = "InasistenciaImagen.findByNombreImagen", query = "SELECT i FROM InasistenciaImagen i WHERE i.nombreImagen = :nombreImagen")
    , @NamedQuery(name = "InasistenciaImagen.findByDescripcion", query = "SELECT i FROM InasistenciaImagen i WHERE i.descripcion = :descripcion")})
public class InasistenciaImagen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_inasistencia")
    private Integer idInasistencia;
    @Size(max = 30)
    @Column(name = "nombre_imagen")
    private String nombreImagen;
    @Lob
    @Column(name = "imagen")
    private byte[] imagen; //mostrsar imagen
    @Size(max = 30)
    @Column(name = "descripcion")
    private String descripcion;

   
    // subir imagen a la base de datos
    InputStream archivoImagen;

    public InasistenciaImagen() {
    }

    public InasistenciaImagen(Integer idInasistencia, String nombreImagen, byte[] imagen, String descripcion) {
        this.idInasistencia = idInasistencia;
        this.nombreImagen = nombreImagen;
        this.imagen = imagen;
        this.descripcion = descripcion;
    }
    
    public InputStream getArchivoImagen() {
        return archivoImagen;
    }

    public void setArchivoImagen(InputStream archivoImagen) {
        this.archivoImagen = archivoImagen;
    }
    public InasistenciaImagen(Integer idInasistencia) {
        this.idInasistencia = idInasistencia;
    }

    public Integer getIdInasistencia() {
        return idInasistencia;
    }

    public void setIdInasistencia(Integer idInasistencia) {
        this.idInasistencia = idInasistencia;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        if (!(object instanceof InasistenciaImagen)) {
            return false;
        }
        InasistenciaImagen other = (InasistenciaImagen) object;
        if ((this.idInasistencia == null && other.idInasistencia != null) || (this.idInasistencia != null && !this.idInasistencia.equals(other.idInasistencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.InasistenciaImagen[ idInasistencia=" + idInasistencia + " ]";
    }
    
}
