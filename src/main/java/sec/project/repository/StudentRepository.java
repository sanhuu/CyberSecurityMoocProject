/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sec.project.domain.Student;

/**
 *
 * @author Sanna
 */
public interface StudentRepository extends JpaRepository<Student, Long>  {
    
    Student findByName(String name);
    Student findByStudentnumber(String studentnumber);
    

    
}
