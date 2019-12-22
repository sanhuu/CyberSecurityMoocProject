package sec.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.Course;
import sec.project.domain.Enrolment;
import sec.project.domain.Record;
import sec.project.domain.Signup;
import sec.project.domain.Student;
import sec.project.repository.CourseRepository;
import sec.project.repository.EnrolmentRepository;
import sec.project.repository.RecordRepository;
import sec.project.repository.SignupRepository;
import sec.project.repository.StudentRepository;

@Controller
public class SignupController {

    @Autowired
    private SignupRepository signupRepository;
    
    @Autowired
    private CourseRepository courseRepository;
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private RecordRepository recordRepository;
    
    
    @Autowired
    private EnrolmentRepository enrolmentRepository;
    
    
    private List<Course> searchresult = new ArrayList();
    

    @RequestMapping("*")
    public String defaultMapping() {
        
        System.out.println("päädyttiin deafultMapping -metodiin");
        
        if(studentRepository.findAll().isEmpty()) {
            createDatabase();
        }
        
        
        return "redirect:/menu";
        //tämä muutettu, aiemmin /form
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String loadMenu() {
        System.out.println("päädyttiin loadMenu()-metodiin");
        return "menu";
    }
    

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(@RequestParam String name, @RequestParam String address) {
        signupRepository.save(new Signup(name, address));
        return "done";
    }
    
    
    
    @RequestMapping(value = "/records")
    public String loadRecords(Model model, @RequestParam (required=false) String studentId) {
        List<Record> records = recordRepository.findByStudentId(studentId);
        System.out.println(records);
        if(records == null) {
            records = new ArrayList();
        }
        
        model.addAttribute("records", records);
        
        return "records";
    }
    
    
    @RequestMapping(value = "/enrolments")
    public String loadEnrolments(Model model, @RequestParam (required=false) String courseId, @RequestParam(required=false) String studentId) { //, @PathVariable String courseId, @PathVariable Long courseLongId 
        System.out.println("courseId: " + courseId);
         System.out.println("studentId: " + studentId);
         if(studentId != null) {
            List<Enrolment> enrolments = enrolmentRepository.findByStudentId(studentId);
            if(courseId != null) {
                Course course = courseRepository.findByCourseId(courseId);
                System.out.println("course: " + course);
                if(!enrolments.contains(course)) {
                    Enrolment enrolment = new Enrolment(studentId, course.getNro()); 
                    enrolments.add(enrolment);
                    enrolmentRepository.save(enrolment);
                    System.out.println("enrolments for " + studentRepository.findByStudentnumber(studentId) + ": " + enrolments);
                    }
            }
         if(!enrolments.isEmpty()) {
            List<Course> enrolCourses = new ArrayList();
            for(Enrolment enrol: enrolments) {
                enrolCourses.add(courseRepository.findByCourseId(enrol.getCourseId()));
            }
            System.out.println("enrolments ei ollut null");
            model.addAttribute("enrolCourses", enrolCourses);
        }
         }
         
        return "enrolments";
    }

    
    
    //@RequestMapping(value = "/courses", method = RequestMethod.GET)
   // public String loadCourses(Model model) {
   //     System.out.println("tähän asti ok");
        
       
   //     System.out.println("tämäkin ok");
        
   //     if(!searchresult.isEmpty()) {
   //         System.out.println("searchresult ei ollut null");
   //         model.addAttribute("Course details: " + searchresult);
   //     }
   //     System.out.println("seuraavaksi palautetaan courses");
        
        

     //   return "courses";
   // }
    
    
    
    @RequestMapping(value = "/courses")
    public String searchCourse(Model model, @RequestParam(required=false) String name, @RequestParam (required=false) String courseId) { //, @PathVariable String courseId, @PathVariable Long courseLongId
        System.out.println("tultiin oikeaan metodiin");
        System.out.println(courseId);
        if(courseId != null || name != null) {
            Course course = courseRepository.findByCourseId(courseId);
            System.out.println("löytyikö kurssi: " + course);
            if(!searchresult.contains(course)) {
            if(course == null && name != null) {
                System.out.println("kurssi oli null");
                List<Course> list = new ArrayList();
                list = courseRepository.findAll();
                searchresult = list.stream().filter(a -> a.getName().contains(name)).collect(Collectors.toList());
                System.out.println("listassa nyt: " + searchresult.size());
            } else {searchresult.add(course);}
            }
            
            if(!searchresult.isEmpty()) {
            System.out.println("searchresult ei ollut null");
            model.addAttribute("searchresult", searchresult);
        }
        }           
        

        return "courses";
    
    }
    
    public void createDatabase() {
        
        ArrayList<Student> opiskelijat = new ArrayList();
        opiskelijat.add(new Student("0123456", "Ted"));
        opiskelijat.add(new Student("1234567", "Aki"));
        opiskelijat.add(new Student("2345678", "Lea"));
        opiskelijat.add(new Student("3456789", "Aino"));
        opiskelijat.add(new Student("4567891", "Leo"));
        
        System.out.println("luotiin opiskelijat: " + opiskelijat);
        
        for(Student opiskelija: opiskelijat) {
            studentRepository.save(opiskelija);
        }
        
        System.out.println(studentRepository.findAll());
        
        System.out.println("tallennettiin opiskelijat tietokantaan");
                
        ArrayList<Course> kurssit = new ArrayList();
        kurssit.add(new Course("HY12345", "Tietokantojen perusteet", "Kurssi on osa tietojenkäsittelytieteen kandiohjelman perusopintoja", "kevät 2020"));
        kurssit.add(new Course("HY23456", "Ohjelmoinnin johdanto", "Kurssi on osa tietojenkäsittelytieteen kandiohjelman perusopintoja", "kevät 2020"));
        kurssit.add(new Course("HY34567", "Ohjelmoinnin jatkokurssi", "Kurssi on osa tietojenkäsittelytieteen kandiohjelman perusopintoja", "kevät 2020"));
        kurssit.add(new Course("HY45678", "Johdatus tietojenkäsittelytieteeseen", "Kurssi on osa tietojenkäsittelytieteen kandiohjelman perusopintoja", "kevät 2020"));
        kurssit.add(new Course("HY45679", "Tietokoneen toiminta", "Kurssi on osa tietojenkäsittelytieteen kandiohjelman perusopintoja", "kevät 2020"));
        kurssit.add(new Course("HY56789", "Introduction to Cyber Security", "Course is part of bachelor-level course Introduction to Cyber Security", "spring 2020"));
        kurssit.add(new Course("HY67891", "Securing Software", "Course is part of bachelor-level course Introduction to Cyber Security", "spring 2020"));
        kurssit.add(new Course("HY78912", "Course Project I", "Course is part of bachelor-level course Introduction to Cyber Security", "spring 2020"));
        kurssit.add(new Course("HY89123", "Advanced Topics", "Course is part of master-level course Cyber Security II", "spring 2020"));
        kurssit.add(new Course("HY91234", "Course Project II", "Course is part of master-level course Cyber Security II", "spring 2020"));

        System.out.println("luotiin " + kurssit.size() + "kurssia");
        
        for(Course kurssi: kurssit) {
            courseRepository.save(kurssi);
        }
        
        System.out.println("tallennettiin kurssit tietokantaan");
                
        
        
        Random random = new Random();
        
        for(Student opiskelija: studentRepository.findAll()) {
            System.out.println(opiskelija.getName());
            Integer suorituksia = random.nextInt(4);
            System.out.println("suorituksia lisätään: " + suorituksia);
            for(int i=0; i <= suorituksia; i++) {
                Course kurssi = courseRepository.findByCourseId(kurssit.get(random.nextInt(4)).getNro());
                List<Record> suoritukset = recordRepository.findByStudentId(opiskelija.getNro());
                System.out.println("kurssi: " + kurssi.getNro());
                if(suoritukset.isEmpty() || (!(suoritukset.contains(recordRepository.findByRecordId(opiskelija.getNro() + kurssi.getNro()))))) {
                    System.out.println("päädyttiin if-lauseeseen");
                    Record suoritus = new Record(opiskelija.getNro(), kurssi.getNro(), kurssi.getName(), random.nextInt(4)+1);
                    Enrolment enrolment = new Enrolment(opiskelija.getNro(), kurssi.getNro());
                    System.out.println("luotiin arvosana: " + suoritus.getEvaluation());
                    recordRepository.save(suoritus);
                    enrolmentRepository.save(enrolment);
//                    studentRepository.findByStudentnumber(opiskelija.getNro()).setRecords(recordRepository.findByRecordId(opiskelija.getNro() + kurssi.getNro()));
                    
                }
                System.out.println(opiskelija.getName() + ": if-loop loppui");
            }
            System.out.println(opiskelija.getName() + ": for-loop loppui");
            }
        System.out.println("tallennettiin opiskelijoille suoritukset, esim. ted: " + recordRepository.findByStudentId(studentRepository.findByName("Ted").getNro()).size() + "suoritusta");
        System.out.println("tallennettiin opiskelijoille ilmoittautumiset, esim. ted: " + enrolmentRepository.findByStudentId(studentRepository.findByName("Ted").getNro()).size());
        
 //       for(Student opiskelija: opiskelijat) {
 //           System.out.println(opiskelija.getName());
 //           if(!opiskelija.getRecords().isEmpty()) {
 //           for(Record kurssi: opiskelija.getRecords()) {
 //               
 //               studentRepository.findByName(opiskelija.getName()).setEnrols(courseRepository.findByCourseId(kurssi.getCourseId()));
 //           }
 //       }
 //       }
        
    }

}
