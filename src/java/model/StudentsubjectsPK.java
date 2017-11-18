/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author solstinger
 */
@Embeddable
public class StudentsubjectsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "StudentCode")
    private String studentCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SubjectName")
    private String subjectName;

    public StudentsubjectsPK() {
    }

    public StudentsubjectsPK(String studentCode, String subjectName) {
        this.studentCode = studentCode;
        this.subjectName = subjectName;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentCode != null ? studentCode.hashCode() : 0);
        hash += (subjectName != null ? subjectName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentsubjectsPK)) {
            return false;
        }
        StudentsubjectsPK other = (StudentsubjectsPK) object;
        if ((this.studentCode == null && other.studentCode != null) || (this.studentCode != null && !this.studentCode.equals(other.studentCode))) {
            return false;
        }
        if ((this.subjectName == null && other.subjectName != null) || (this.subjectName != null && !this.subjectName.equals(other.subjectName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.StudentsubjectsPK[ studentCode=" + studentCode + ", subjectName=" + subjectName + " ]";
    }
    
}
