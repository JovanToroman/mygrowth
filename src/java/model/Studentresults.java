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
 * @author Solstinger_
 */
@Entity
@Table(name = "studentresults")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Studentresults.findAll", query = "SELECT s FROM Studentresults s")
    , @NamedQuery(name = "Studentresults.findByResultID", query = "SELECT s FROM Studentresults s WHERE s.studentresultsPK.resultID = :resultID")
    , @NamedQuery(name = "Studentresults.findByStudentCode", query = "SELECT s FROM Studentresults s WHERE s.studentresultsPK.studentCode = :studentCode")
    , @NamedQuery(name = "Studentresults.findByTeacherCode", query = "SELECT s FROM Studentresults s WHERE s.studentresultsPK.teacherCode = :teacherCode")
    , @NamedQuery(name = "Studentresults.findByLevel", query = "SELECT s FROM Studentresults s WHERE s.level = :level")
    , @NamedQuery(name = "Studentresults.findByNote", query = "SELECT s FROM Studentresults s WHERE s.note = :note")
    , @NamedQuery(name = "Studentresults.removeStudentResult", query = "DELETE FROM Studentresults s WHERE s.studentresultsPK.resultID = :resultID and s.studentresultsPK.studentCode = :studentCode")})
public class Studentresults implements Serializable, Record {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StudentresultsPK studentresultsPK;
    @Size(max = 6)
    @Column(name = "Level")
    private String level;
    @Size(max = 300)
    @Column(name = "Note")
    private String note;
    @JoinColumn(name = "ResultID", referencedColumnName = "ResultID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Result result;
    @JoinColumn(name = "StudentCode", referencedColumnName = "StudentCode", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Migrant migrant;
    @JoinColumn(name = "TeacherCode", referencedColumnName = "TeacherCode", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Teacher teacher;

    public Studentresults() {
    }

    public Studentresults(StudentresultsPK studentresultsPK) {
        this.studentresultsPK = studentresultsPK;
    }

    public Studentresults(int resultID, String studentCode, String teacherCode) {
        this.studentresultsPK = new StudentresultsPK(resultID, studentCode, teacherCode);
    }

    public StudentresultsPK getStudentresultsPK() {
        return studentresultsPK;
    }

    public void setStudentresultsPK(StudentresultsPK studentresultsPK) {
        this.studentresultsPK = studentresultsPK;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Migrant getMigrant() {
        return migrant;
    }

    public void setMigrant(Migrant migrant) {
        this.migrant = migrant;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentresultsPK != null ? studentresultsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studentresults)) {
            return false;
        }
        Studentresults other = (Studentresults) object;
        if ((this.studentresultsPK == null && other.studentresultsPK != null) || (this.studentresultsPK != null && !this.studentresultsPK.equals(other.studentresultsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Studentresults[ studentresultsPK=" + studentresultsPK + " ]";
    }

    @Override
    public void deleteRecord(EntityManager em, UserTransaction userTxn) {
        try {
            userTxn.begin();
            Query q = em.createNamedQuery("Studentresults.removeStudentResult").setHint(QueryHints.CACHE_USAGE, CacheUsage.DoNotCheckCache);
            q = q.setParameter("studentCode", this.getStudentresultsPK().getStudentCode());
            q = q.setParameter("resultID", this.getStudentresultsPK().getResultID());
            q.executeUpdate();
            userTxn.commit();
        } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
            Logger.getLogger(Studentresults.class.getName()).log(Level.SEVERE, null, ex);
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
    public List<?> getRecords(EntityManager em, UserTransaction userTxn) {
        Migrant m = em.find(Migrant.class, this.getMigrant().getStudentCode());
        Query q = em.createNamedQuery("Studentresults.findByStudentCode").setHint(QueryHints.CACHE_USAGE, CacheUsage.DoNotCheckCache);
        q = q.setParameter("studentCode", m.getStudentCode());
        System.out.println("Lista rezultata: " + q.getResultList());
        return q.getResultList();
    }

    @Override
    public void updateRecord(EntityManager em, UserTransaction userTxn) { //TO-DO : might be obsolete.
        try {
            userTxn.begin();
            if (!em.contains(this)) {
                em.merge(this);
            } else {
                em.persist(this);
            }
            userTxn.commit();
        } catch (SecurityException | IllegalStateException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SystemException | NotSupportedException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
