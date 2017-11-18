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
 * @author Solstinger_
 */
@Embeddable
public class StudentresultsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ResultID")
    private int resultID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "StudentCode")
    private String studentCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TeacherCode")
    private String teacherCode;

    public StudentresultsPK() {
    }

    public StudentresultsPK(int resultID, String studentCode, String teacherCode) {
        this.resultID = resultID;
        this.studentCode = studentCode;
        this.teacherCode = teacherCode;
    }

    public int getResultID() {
        return resultID;
    }

    public void setResultID(int resultID) {
        this.resultID = resultID;
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
        hash += (int) resultID;
        hash += (studentCode != null ? studentCode.hashCode() : 0);
        hash += (teacherCode != null ? teacherCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentresultsPK)) {
            return false;
        }
        StudentresultsPK other = (StudentresultsPK) object;
        if (this.resultID != other.resultID) {
            return false;
        }
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
        return "model.StudentresultsPK[ resultID=" + resultID + ", studentCode=" + studentCode + ", teacherCode=" + teacherCode + " ]";
    }
    
}
