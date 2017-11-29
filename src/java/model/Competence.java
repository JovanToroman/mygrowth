/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.UserTransaction;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Solstinger_
 */
@Entity
@Table(name = "competence")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Competence.findAll", query = "SELECT c FROM Competence c")
    , @NamedQuery(name = "Competence.findByCompetenceID", query = "SELECT c FROM Competence c WHERE c.competenceID = :competenceID")
    , @NamedQuery(name = "Competence.findByCompetenceName", query = "SELECT c FROM Competence c WHERE c.competenceName = :competenceName")})
public class Competence implements Serializable, Record {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CompetenceID")
    private Integer competenceID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CompetenceName")
    private String competenceName;
    @OneToMany(mappedBy = "competenceID")
    private Collection<Result> resultCollection;

    public Competence() {
    }

    public Competence(Integer competenceID) {
        this.competenceID = competenceID;
    }

    public Competence(Integer competenceID, String competenceName) {
        this.competenceID = competenceID;
        this.competenceName = competenceName;
    }

    public Integer getCompetenceID() {
        return competenceID;
    }

    public void setCompetenceID(Integer competenceID) {
        this.competenceID = competenceID;
    }

    public String getCompetenceName() {
        return competenceName;
    }

    public void setCompetenceName(String competenceName) {
        this.competenceName = competenceName;
    }

    @XmlTransient
    public Collection<Result> getResultCollection() {
        return resultCollection;
    }

    public void setResultCollection(Collection<Result> resultCollection) {
        this.resultCollection = resultCollection;
    }

    public int getNumberOfResults(List<Studentresults> lor) {
        int count = 0;
        for (Studentresults sr : lor) {
            if (sr != null && sr.getResult().getCompetenceID().getCompetenceName().equals(this.getCompetenceName())) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (competenceID != null ? competenceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competence)) {
            return false;
        }
        Competence other = (Competence) object;
        if ((this.competenceID == null && other.competenceID != null) || (this.competenceID != null && !this.competenceID.equals(other.competenceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Competence[ competenceID=" + competenceID + " ]";
    }

    @Override
    public Object getRecord(EntityManager em, UserTransaction userTxn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<? extends Record> getRecords(EntityManager em, UserTransaction userTxn) {
        return em.createQuery("SELECT e FROM Competence e").getResultList();
    }

    @Override
    public void deleteRecord(EntityManager em, UserTransaction userTxn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addRecord(EntityManager em, UserTransaction userTxn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateRecord(EntityManager em, UserTransaction userTxn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
