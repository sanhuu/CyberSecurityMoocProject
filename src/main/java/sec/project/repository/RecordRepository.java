/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.project.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import sec.project.domain.Record;

/**
 *
 * @author Sanna
 */
public interface RecordRepository extends JpaRepository<Record, Long> {
    Record findByRecordId(String recordId);
     List<Record> findByStudentId(String studentId);
     List<Record> findByCourseId(String courseId);

}
