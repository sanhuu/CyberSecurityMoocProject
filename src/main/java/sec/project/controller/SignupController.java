package sec.project.controller;

import java.util.ArrayList;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.Course;
import sec.project.domain.Record;
import sec.project.domain.Signup;
import sec.project.domain.Student;
import sec.project.repository.CourseRepository;
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
    

    @RequestMapping("*")
    public String defaultMapping() {
        
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
        
        for(Student opiskelija: opiskelijat) {
            System.out.println(opiskelija.getName());
            Integer suorituksia = random.nextInt(4);
            System.out.println("suorituksia lisätään: " + suorituksia);
            for(int i=0; i <= suorituksia; i++) {
                Course kurssi = courseRepository.findBycourseid(kurssit.get(random.nextInt(4)).getNro());
                System.out.println("kurssi: " + kurssi.getNro());
                if(opiskelija.getRecords().isEmpty() || (!(opiskelija.getRecords().contains(recordRepository.findByRecordId(opiskelija.getNro() + kurssi.getNro()))))) {
                    System.out.println("päädyttiin if-lauseeseen");
                    Record suoritus = new Record(opiskelija.getNro(), kurssi.getNro(), random.nextInt(4)+1);
                    System.out.println("luotiin arvosana: " + suoritus.getEvaluation());
                    recordRepository.save(suoritus);
                    studentRepository.findByStudentnumber(opiskelija.getNro()).setRecords(recordRepository.findByRecordId(opiskelija.getNro() + kurssi.getNro()));
                    
                }
                System.out.println(opiskelija.getName() + ": if-loop loppui");
            }
            System.out.println(opiskelija.getName() + ": for-loop loppui");
            }
        System.out.println("tallennettiin opiskelijoille suoritukset, esim. ted: " + studentRepository.findByName("Ted").getRecords().size() + "suoritusta");

        
        for(Student opiskelija: opiskelijat) {
            for(Record kurssi: opiskelija.getRecords()) {
                opiskelija.setEnrols(courseRepository.findBycourseid(kurssi.getCourseId()));
            }
        }

        
        
        
        
        
        
        
        
        
        return "redirect:/menu";
        //tämä muutettu, aiemmin /form
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String loadMenu() {
        return "menu";
    }
    

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(@RequestParam String name, @RequestParam String address) {
        signupRepository.save(new Signup(name, address));
        return "done";
    }
    
    
    
    @RequestMapping(value = "/records", method = RequestMethod.GET)
    public String loadRecords() {
        return "records";
    }
    
    
    @RequestMapping(value = "/enrolments", method = RequestMethod.GET)
    public String loadEnrolments() {
        return "enrolments";
    }

    
    
    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String loadCourses() {
        
               

    
        
        

        return "courses";
    }

}
