/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author j
 */
@Entity
@Table(name = "Enrolments")
public class Enrolment extends AbstractPersistable<Long>  {
    
    @Column(unique = true)
    private String enrolId;
    private String studentId;
    private String courseId;

    
    public Enrolment() { 
        super();
        
    }
    
    public Enrolment(String studentId, String courseId) {
        this.enrolId = studentId + courseId;
        this.studentId = studentId;
        this.courseId = courseId;

    }
    
    public String getEnrolId() {
        return this.enrolId;
    }

    public void setEnrolId(String id) {
        this.enrolId = id;
    }
    
    public String getStudentId() {
        return this.studentId;
    }

    public void setStudentId(String id) {
        this.studentId = id;
    }

    public String getCourseId() {
        return this.courseId;
    }

    public void setCourseId(String id) {
        this.courseId = id;
    }
   
    @Override
    public String toString() {
    return this.courseId + "; " + this.studentId + "; " + this.enrolId;
    }
    
}
    

