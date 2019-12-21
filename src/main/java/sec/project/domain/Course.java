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
    
    
    public Course(String nro, String name, String description, String time) {
        this.name = name;
        this.courseid = nro;
        this.description = description;
        this.time = time;
    }
    
    
    public String getNimi() {
        return this.name;
    }
    
    public void setNimi(String name) {
        this.name = name;
    }
    
     public String getNro() {
        return this.courseid;
    }
     
     
     public void setNro(String nro) {
        this.courseid = nro;
}
     
     public String getKuvaus() {
        return this.description;
    }
     
     
     public void setKuvaus(String description) {
        this.description = description;
}
     
     public String getAika() {
        return this.time;
    }
     
     
     public void setAika(String aika) {
        this.time = time;
}
}
