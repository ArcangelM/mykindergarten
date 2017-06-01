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
 * @author arK
 */
@Entity
@Table(name = "CHILDRENS")
@XmlRootElement
@NamedQueries({
   
    @NamedQuery(name = "allChildrens", query = "SELECT c FROM Childrens c")
//    , @NamedQuery(name = "Childrens.findAll", query = "SELECT c FROM Childrens c")
//    , @NamedQuery(name = "Childrens.findByName", query = "SELECT c FROM Childrens c WHERE c.name = :name")
//    , @NamedQuery(name = "Childrens.findByEdad", query = "SELECT c FROM Childrens c WHERE c.edad = :edad")
//    , @NamedQuery(name = "Childrens.findByPadre", query = "SELECT c FROM Childrens c WHERE c.padre = :padre")
//    , @NamedQuery(name = "Childrens.findByMadre", query = "SELECT c FROM Childrens c WHERE c.madre = :madre")
//    , @NamedQuery(name = "Childrens.findById", query = "SELECT c FROM Childrens c WHERE c.id = :id")
})
public class Childrens implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EDAD")
    private int edad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PADRE")
    private String padre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MADRE")
    private String madre;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;

    public Childrens() {
    }

    public Childrens(Integer id) {
        this.id = id;
    }

    public Childrens(Integer id,String name, int edad, String padre, String madre) {
        this.id = id;
        this.edad = edad;
        this.padre = padre;
        this.madre = madre;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }

    public String getMadre() {
        return madre;
    }

    public void setMadre(String madre) {
        this.madre = madre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Childrens)) {
            return false;
        }
        Childrens other = (Childrens) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "modelo.Childrens[ id=" + id + " ]";
    }
    
}
