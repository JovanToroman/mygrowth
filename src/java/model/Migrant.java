/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dbbroker.DBBroker;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
import org.eclipse.persistence.config.CacheUsage;
import org.eclipse.persistence.config.QueryHints;

/**
 *
 * @author Solstinger_
 */
@Entity
@Table(name = "migrant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Migrant.findAll", query = "SELECT m FROM Migrant m")
    , @NamedQuery(name = "Migrant.findByStudentCode", query = "SELECT m FROM Migrant m WHERE m.studentCode = :studentCode")
    , @NamedQuery(name = "Migrant.findByProfileImageUrl", query = "SELECT m FROM Migrant m WHERE m.profileImageUrl = :profileImageUrl")
    , @NamedQuery(name = "Migrant.findByFirstName", query = "SELECT m FROM Migrant m WHERE m.firstName = :firstName")
    , @NamedQuery(name = "Migrant.findByLastName", query = "SELECT m FROM Migrant m WHERE m.lastName = :lastName")
    , @NamedQuery(name = "Migrant.findByDateOfBirth", query = "SELECT m FROM Migrant m WHERE m.dateOfBirth = :dateOfBirth")
    , @NamedQuery(name = "Migrant.findByCountryOfOrigin", query = "SELECT m FROM Migrant m WHERE m.countryOfOrigin = :countryOfOrigin")
    , @NamedQuery(name = "Migrant.findByMotherTongue", query = "SELECT m FROM Migrant m WHERE m.motherTongue = :motherTongue")})
public class Migrant implements Serializable, Record {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "migrant")
    private Collection<Migrantteacher> migrantteacherCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "StudentCode")
    private String studentCode;
    @Size(max = 100)
    @Column(name = "ProfileImageUrl")
    private String profileImageUrl;
    @Size(max = 50)
    @Column(name = "FirstName")
    private String firstName;
    @Size(max = 100)
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "DateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Size(max = 30)
    @Column(name = "CountryOfOrigin")
    private String countryOfOrigin;
    @Size(max = 30)
    @Column(name = "Email")
    private String email;
    @Size(max = 15)
    @Column(name = "MotherTongue")
    private String motherTongue;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "migrant")
    private Collection<Studentresults> studentresultsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "migrant")
    private Collection<Studentsubjects> studentsubjectsCollection;

    public Migrant() {
    }

    public Migrant(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getMotherTongue() {
        return motherTongue;
    }

    public void setMotherTongue(String motherTongue) {
        this.motherTongue = motherTongue;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Studentresults> getStudentresultsCollection() {
        return studentresultsCollection;
    }

    public void setStudentresultsCollection(Collection<Studentresults> studentresultsCollection) {
        this.studentresultsCollection = studentresultsCollection;
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
        hash += (studentCode != null ? studentCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Migrant)) {
            return false;
        }
        Migrant other = (Migrant) object;
        if ((this.studentCode == null && other.studentCode != null) || (this.studentCode != null && !this.studentCode.equals(other.studentCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Migrant[ studentCode=" + studentCode + " ]";
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

    @XmlTransient
    public Collection<Migrantteacher> getMigrantteacherCollection() {
        return migrantteacherCollection;
    }

    public void setMigrantteacherCollection(Collection<Migrantteacher> migrantteacherCollection) {
        this.migrantteacherCollection = migrantteacherCollection;
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
    public Object getRecord(EntityManager em, UserTransaction userTxn) throws Exception{
        try {
            Migrant m = em.find(Migrant.class,
                    this.getStudentCode());
            if (m == null) {
                throw new Exception("Wrong student code!");
            }
            return m;
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw e;
        }
    }

    @Override
    public List<?> getRecords(EntityManager em, UserTransaction userTxn) { //returns all the results that this student achieved
        Migrant m = em.find(Migrant.class, this.getStudentCode());
        Query q = em.createNamedQuery("Studentresults.findByStudentCode").setHint(QueryHints.CACHE_USAGE, CacheUsage.DoNotCheckCache);
        q = q.setParameter("studentCode", m.getStudentCode());
        System.out.println("Lista rezultata: " + q.getResultList());
        return q.getResultList();
    }
    
}
