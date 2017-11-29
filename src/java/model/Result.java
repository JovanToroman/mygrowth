/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dbbroker.DBBroker;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author solstinger
 */
@Entity
@Table(name = "result")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Result.findAll", query = "SELECT r FROM Result r")
    , @NamedQuery(name = "Result.findByResultID", query = "SELECT r FROM Result r WHERE r.resultID = :resultID")
    , @NamedQuery(name = "Result.findByResultName", query = "SELECT r FROM Result r WHERE r.resultName = :resultName")})
public class Result implements Serializable, Record {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ResultID")
    private Integer resultID;
    @Size(max = 100)
    @Column(name = "ResultName")
    private String resultName;
    @JoinColumn(name = "CompetenceID", referencedColumnName = "CompetenceID")
    @ManyToOne
    private Competence competenceID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "result")
    private Collection<Studentresults> studentresultsCollection;

    public Result() {
    }

    public Result(Integer resultID) {
        this.resultID = resultID;
    }

    public Integer getResultID() {
        return resultID;
    }

    public void setResultID(Integer resultID) {
        this.resultID = resultID;
    }

    public String getResultName() {
        return resultName;
    }

    public void setResultName(String resultName) {
        this.resultName = resultName;
    }

    public Competence getCompetenceID() {
        return competenceID;
    }

    public void setCompetenceID(Competence competenceID) {
        this.competenceID = competenceID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resultID != null ? resultID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Result)) {
            return false;
        }
        Result other = (Result) object;
        if ((this.resultID == null && other.resultID != null) || (this.resultID != null && !this.resultID.equals(other.resultID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Result[ resultName=" + getResultName() + " ]";
    }

    @Override
    public void deleteRecord(EntityManager em, UserTransaction userTxn) {
        try {
            
            userTxn.begin();
                Result r = em.find(Result.class, this.getResultID());
                System.out.println("U resultu find: "+r);
                em.remove(r);
            userTxn.commit();
        } catch (SecurityException | IllegalStateException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SystemException | NotSupportedException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void addRecord(EntityManager em, UserTransaction userTxn) {
        try {
            userTxn.begin();
            em.persist(this);
            userTxn.commit();
        } catch (SecurityException | IllegalStateException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SystemException | NotSupportedException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object getRecord(EntityManager em, UserTransaction userTxn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<? extends Record> getRecords(EntityManager em, UserTransaction userTxn) {
        return em.createQuery("SELECT e FROM Result e").getResultList();
    }

    @Override
    public void updateRecord(EntityManager em, UserTransaction userTxn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
