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
@Table(name = "Course")
public class Course extends AbstractPersistable<Long>{
    
    @Column(unique = true)
    private String courseid;
    private String name;
    private String description;
    private String time;
    
    public Course() {
        
    }
    
    
    public Course(String nro, String name, String description, String time) {
        this.name = name;
        this.courseid = nro;
        this.description = description;
        this.time = time;
    }
    
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
     public String getNro() {
        return this.courseid;
    }
     
     
     public void setNro(String nro) {
        this.courseid = nro;
}
     
     public String getDesc() {
        return this.description;
    }
     
     
     public void setDesc(String description) {
        this.description = description;
}
     
     public String getTime() {
        return this.time;
    }
     
     
     public void setTime(String aika) {
        this.time = time;
}
}
