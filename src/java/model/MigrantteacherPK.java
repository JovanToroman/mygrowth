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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author solstinger
 */
@Embeddable
public class MigrantteacherPK implements Serializable, Record {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "studentCode")
    private String studentCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "teacherCode")
    private String teacherCode;

    public MigrantteacherPK() {
    }

    public MigrantteacherPK(String studentCode, String teacherCode) {
        this.studentCode = studentCode;
        this.teacherCode = teacherCode;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentCode != null ? studentCode.hashCode() : 0);
        hash += (teacherCode != null ? teacherCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MigrantteacherPK)) {
            return false;
        }
        MigrantteacherPK other = (MigrantteacherPK) object;
        if ((this.studentCode == null && other.studentCode != null) || (this.studentCode != null && !this.studentCode.equals(other.studentCode))) {
            return false;
        }
        if ((this.teacherCode == null && other.teacherCode != null) || (this.teacherCode != null && !this.teacherCode.equals(other.teacherCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.MigrantteacherPK[ studentCode=" + studentCode + ", teacherCode=" + teacherCode + " ]";
    }
    
    @Override
    public void deleteRecord(EntityManager em, UserTransaction userTxn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addRecord(EntityManager em, UserTransaction userTxn) {
        try {
                userTxn.begin();                
                em.persist(this);
                userTxn.commit();
            } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
                Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    @Override
    public void updateRecord(EntityManager em, UserTransaction userTxn) {
        try {
                userTxn.begin();                
                em.merge(this);
                userTxn.commit();
            } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
                Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public Object getRecord(EntityManager em, UserTransaction userTxn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<? extends Record> getRecords(EntityManager em, UserTransaction userTxn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
