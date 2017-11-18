/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dbbroker.DBBroker;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.config.CacheUsage;
import org.eclipse.persistence.config.QueryHints;

/**
 *
 * @author solstinger
 */
@Entity
@Table(name = "studentsubjects")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Studentsubjects.findAll", query = "SELECT s FROM Studentsubjects s")
    , @NamedQuery(name = "Studentsubjects.findByStudentCode", query = "SELECT s FROM Studentsubjects s WHERE s.studentsubjectsPK.studentCode = :studentCode")
    , @NamedQuery(name = "Studentsubjects.findBySubjectName", query = "SELECT s FROM Studentsubjects s WHERE s.studentsubjectsPK.subjectName = :subjectName")
    , @NamedQuery(name = "Studentsubjects.findByEvaluation", query = "SELECT s FROM Studentsubjects s WHERE s.evaluation = :evaluation")
    , @NamedQuery(name = "Studentsubjects.findByLevel", query = "SELECT s FROM Studentsubjects s WHERE s.level = :level")})
public class Studentsubjects implements Serializable, Record {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StudentsubjectsPK studentsubjectsPK;
    @Size(max = 300)
    @Column(name = "Evaluation")
    private String evaluation;
    @Size(max = 6)
    @Column(name = "Level")
    private String level;
    @JoinColumn(name = "StudentCode", referencedColumnName = "StudentCode", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Migrant migrant;
    @JoinColumn(name = "SubjectName", referencedColumnName = "SubjectName", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Subject subject;

    public Studentsubjects() {
    }

    public Studentsubjects(StudentsubjectsPK studentsubjectsPK) {
        this.studentsubjectsPK = studentsubjectsPK;
    }

    public Studentsubjects(String studentCode, String subjectName) {
        this.studentsubjectsPK = new StudentsubjectsPK(studentCode, subjectName);
    }

    public StudentsubjectsPK getStudentsubjectsPK() {
        return studentsubjectsPK;
    }

    public void setStudentsubjectsPK(StudentsubjectsPK studentsubjectsPK) {
        this.studentsubjectsPK = studentsubjectsPK;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Migrant getMigrant() {
        return migrant;
    }

    public void setMigrant(Migrant migrant) {
        this.migrant = migrant;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentsubjectsPK != null ? studentsubjectsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studentsubjects)) {
            return false;
        }
        Studentsubjects other = (Studentsubjects) object;
        if ((this.studentsubjectsPK == null && other.studentsubjectsPK != null) || (this.studentsubjectsPK != null && !this.studentsubjectsPK.equals(other.studentsubjectsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Studentsubjects[ studentsubjectsPK=" + studentsubjectsPK + " ]";
    }
    
    @Override
    public void deleteRecord(EntityManager em, UserTransaction userTxn) {
        try {
            userTxn.begin();
                em.clear();
                Studentsubjects ss = em.find(Studentsubjects.class, this.getStudentsubjectsPK());
                System.out.println("U Studentsubjects find: "+ss);
                em.remove(ss);
                em.clear();
            userTxn.commit();
        } catch (SecurityException | IllegalStateException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SystemException | NotSupportedException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void addRecord(EntityManager em, UserTransaction userTxn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Record getRecord(EntityManager em, UserTransaction userTxn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateRecord(EntityManager em, UserTransaction userTxn) {
        Studentsubjects s = em.find(Studentsubjects.class, this.getStudentsubjectsPK());
        if (s == null) {
            try {
                userTxn.begin();
                em.persist(this);
                userTxn.commit();
            } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
                Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                userTxn.begin();
                em.merge(this);
                userTxn.commit();
            } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
                Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<?> getRecords(EntityManager em, UserTransaction userTxn) {        
        Migrant m = em.find(Migrant.class, this.getStudentsubjectsPK().getStudentCode());
        Query q = em.createNamedQuery("Studentsubjects.findByStudentCode").setHint(QueryHints.CACHE_USAGE, CacheUsage.DoNotCheckCache);
        q = q.setParameter("studentCode", m.getStudentCode());
        return q.getResultList();
    }
    
}
