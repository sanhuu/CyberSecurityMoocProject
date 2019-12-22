/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.project.domain;
import javax.persistence.Column;
import javax.persistence.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author Sanna
 */
@Entity
@Table(name = "Student")
public class Student extends AbstractPersistable<Long> {
    
 //   private HashMap<Course, Record> suoritukset;
    
    @Column(unique = true)
    private String studentnumber;
    private String name;
//    private HashMap<String, Kurssi> suoritukset;
//    private HashMap<String, Integer> arvosanat;
    
//      @OneToMany
//      private List<Course> enrolments;
    
//      @OneToMany
//      private List<Record> records;
    
    public Student() {
        super();
    }
    
    public Student(String nro, String name) {
        this.name = name;
        this.studentnumber = nro;
//          this.records = new ArrayList();
//          this.enrolments=new ArrayList();
    }
    
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
     public String getNro() {
        return this.studentnumber;
    }
     
     
     public void setNro(String nro) {
        this.studentnumber = nro;
}
     
     @Override
     public String toString() {
         return this.getName() +" (" + this.getNro() +")";
     }
     
//      public List getEnrols() {
//          return this.enrolments;
//      }
     
     
//       public void setEnrols(Course course) {
//          this.enrolments.add(course);
//  }
     
//      public List<Record> getRecords() {
//          return this.records;
//      }
     
//      public void setRecords(Record record) {
//          this.records.add(record);
//      }
//     public void setSuoritus(String kurssinimi, Kurssi kurssi) {
//        this.suoritukset.put(kurssinimi, kurssi);
//}
     
//    public HashMap getArvosanat() {
//        return this.arvosanat;
//    }
//     
//    public void setArvosana(String kurssinimi, Integer arvosana) {
//        this.arvosanat.put(kurssinimi, arvosana);
//}
     

     
     
     
  //  }
}
