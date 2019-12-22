/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.project.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import sec.project.domain.Enrolment;


/**
 *
 * @author j
 */
public interface EnrolmentRepository extends JpaRepository<Enrolment, Long> {
        Enrolment findByEnrolId(String enrolId);
        List<Enrolment> findByStudentId(String studentId);
        List<Enrolment> findByCourseId(String courseId);

    
    
}
