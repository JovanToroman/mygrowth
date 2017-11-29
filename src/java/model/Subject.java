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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author solstinger
 */
@Entity
@Table(name = "subject")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subject.findAll", query = "SELECT s FROM Subject s")
    , @NamedQuery(name = "Subject.findBySubjectName", query = "SELECT s FROM Subject s WHERE s.subjectName = :subjectName")
    , @NamedQuery(name = "Subject.findByImageUrl", query = "SELECT s FROM Subject s WHERE s.imageUrl = :imageUrl")})
public class Subject implements Serializable, Record {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SubjectName")
    private String subjectName;
    @Size(max = 100)
    @Column(name = "ImageUrl")
    private String imageUrl;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subject")
    private Collection<Studentsubjects> studentsubjectsCollection;

    public Subject() {
    }
    
    public Subject(String subjectName, String imageUrl) {
        this.subjectName = subjectName;
        this.imageUrl = imageUrl;
    }

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @XmlTransient
    public Collection<Studentsubjects> getStudentsubjectsCollection() {
        return studentsubjectsCollection;
    }

    public void setStudentsubjectsCollection(Collection<Studentsubjects> studentsubjectsCollection) {
        this.studentsubjectsCollection = studentsubjectsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subjectName != null ? subjectName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subject)) {
            return false;
        }
        Subject other = (Subject) object;
        if ((this.subjectName == null && other.subjectName != null) || (this.subjectName != null && !this.subjectName.equals(other.subjectName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Subject[ subjectName=" + subjectName + " ]";
    }
    
    @Override
    public void deleteRecord(EntityManager em, UserTransaction userTxn) {
        try {
            userTxn.begin();
                Subject s = em.find(Subject.class, this.getSubjectName());
                System.out.println("U subjectu find: "+s);
                em.remove(s);
            userTxn.commit();
        } catch (SecurityException | IllegalStateException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SystemException | NotSupportedException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("baca neki cudan exception u deleteRecord od subjecta");
        }
    }

    @Override
    public void addRecord(EntityManager em, UserTransaction userTxn) {
        Subject s = em.find(Subject.class, this.getSubjectName());
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
    public Object getRecord(EntityManager em, UserTransaction userTxn) {
        Subject s = em.find(Subject.class, this.getSubjectName());
        return s;
    }

    @Override
    public List<? extends Record> getRecords(EntityManager em, UserTransaction userTxn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateRecord(EntityManager em, UserTransaction userTxn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
