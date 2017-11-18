/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author solstinger
 */
@Entity
@Table(name = "migrantteacher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Migrantteacher.findAll", query = "SELECT m FROM Migrantteacher m")
    , @NamedQuery(name = "Migrantteacher.findByStudentCode", query = "SELECT m FROM Migrantteacher m WHERE m.migrantteacherPK.studentCode = :studentCode")
    , @NamedQuery(name = "Migrantteacher.findByTeacherCode", query = "SELECT m FROM Migrantteacher m WHERE m.migrantteacherPK.teacherCode = :teacherCode")
    , @NamedQuery(name = "Migrantteacher.findByDateFrom", query = "SELECT m FROM Migrantteacher m WHERE m.dateFrom = :dateFrom")
    , @NamedQuery(name = "Migrantteacher.findByDateTo", query = "SELECT m FROM Migrantteacher m WHERE m.dateTo = :dateTo")})
public class Migrantteacher implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MigrantteacherPK migrantteacherPK;
    @Column(name = "dateFrom")
    @Temporal(TemporalType.DATE)
    private Date dateFrom;
    @Column(name = "dateTo")
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    @JoinColumn(name = "studentCode", referencedColumnName = "StudentCode", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Migrant migrant;
    @JoinColumn(name = "teacherCode", referencedColumnName = "TeacherCode", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Teacher teacher;

    public Migrantteacher() {
    }

    public Migrantteacher(MigrantteacherPK migrantteacherPK) {
        this.migrantteacherPK = migrantteacherPK;
    }

    public Migrantteacher(String studentCode, String teacherCode) {
        this.migrantteacherPK = new MigrantteacherPK(studentCode, teacherCode);
    }

    public MigrantteacherPK getMigrantteacherPK() {
        return migrantteacherPK;
    }

    public void setMigrantteacherPK(MigrantteacherPK migrantteacherPK) {
        this.migrantteacherPK = migrantteacherPK;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
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
        hash += (migrantteacherPK != null ? migrantteacherPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Migrantteacher)) {
            return false;
        }
        Migrantteacher other = (Migrantteacher) object;
        if ((this.migrantteacherPK == null && other.migrantteacherPK != null) || (this.migrantteacherPK != null && !this.migrantteacherPK.equals(other.migrantteacherPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Migrantteacher[ migrantteacherPK=" + migrantteacherPK + " ]";
    }
    
}
