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
 * @author Sanna
 */
@Entity
@Table(name = "Record")
public class Record extends AbstractPersistable<Long>  {
    
    @Column(unique = true)
    private String recordId;
    private String studentId;
    private String courseId;
    private Integer evaluation;
    
    public Record(String studentId, String courseId, Integer evaluation) {
        this.recordId = studentId + courseId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.evaluation = evaluation;
    }
    
    public String getRecordId() {
        return this.recordId;
    }

    public void setRecordId(String id) {
        this.recordId = id;
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
    
    public Integer getEvaluation() {
        return this.evaluation;
    }

    public void setEvaluation(Integer nro) {
        this.evaluation = nro;
    }
    
    
}
