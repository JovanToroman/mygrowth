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
@Table(name = "teacher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t")
    , @NamedQuery(name = "Teacher.findByTeacherCode", query = "SELECT t FROM Teacher t WHERE t.teacherCode = :teacherCode")
    , @NamedQuery(name = "Teacher.findByFirstName", query = "SELECT t FROM Teacher t WHERE t.firstName = :firstName")
    , @NamedQuery(name = "Teacher.findByLastName", query = "SELECT t FROM Teacher t WHERE t.lastName = :lastName")
    , @NamedQuery(name = "Teacher.findByCountryOfResidence", query = "SELECT t FROM Teacher t WHERE t.countryOfResidence = :countryOfResidence")
    , @NamedQuery(name = "Teacher.findByEducationalInstitutionName", query = "SELECT t FROM Teacher t WHERE t.educationalInstitutionName = :educationalInstitutionName")
    , @NamedQuery(name = "Teacher.findByEmail", query = "SELECT t FROM Teacher t WHERE t.email = :email")})
public class Teacher implements Serializable, Record {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Collection<Migrantteacher> migrantteacherCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TeacherCode")
    private String teacherCode;
    @Size(max = 20)
    @Column(name = "FirstName")
    private String firstName;
    @Size(max = 40)
    @Column(name = "LastName")
    private String lastName;
    @Size(max = 30)
    @Column(name = "CountryOfResidence")
    private String countryOfResidence;
    @Size(max = 100)
    @Column(name = "EducationalInstitutionName")
    private String educationalInstitutionName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "Email")
    private String email;

    public Teacher() {
    }

    public Teacher(String teacherCode) {
        this.teacherCode = teacherCode;
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    public void setCountryOfResidence(String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    public String getEducationalInstitutionName() {
        return educationalInstitutionName;
    }

    public void setEducationalInstitutionName(String educationalInstitutionName) {
        this.educationalInstitutionName = educationalInstitutionName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @XmlTransient
    public Collection<Migrantteacher> getMigrantteacherCollection() {
        return migrantteacherCollection;
    }
    
    public void setMigrantteacherCollection(Collection<Migrantteacher> migrantteacherCollection) {
        this.migrantteacherCollection = migrantteacherCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teacherCode != null ? teacherCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.teacherCode == null && other.teacherCode != null) || (this.teacherCode != null && !this.teacherCode.equals(other.teacherCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Teacher[ teacherCode=" + teacherCode + " ]";
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
        try {
            Teacher t = em.find(Teacher.class, this.getTeacherCode());
            if (t == null) {
                throw new Exception("Wrong teacher code!");
            }
            return t;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw e;
        }
    }

    @Override
    public List<?> getRecords(EntityManager em, UserTransaction userTxn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
