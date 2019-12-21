package sec.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import sec.project.domain.Course;
import sec.project.domain.Student;

@SpringBootApplication
public class CyberSecurityBaseProjectApplication {

    public static void main(String[] args) throws Throwable {
       
        SpringApplication.run(CyberSecurityBaseProjectApplication.class);
        
    }
}
        
        
   //       Connection connection = DriverManager.getConnection("jdbc:h2:./henkilotietokanta", "sa", "");
   //     
   //     PreparedStatement stmt = connection.prepareStatement("SELECT nimi FROM Opiskelija");
   //     ResultSet rs = stmt.executeQuery();
   //     
   //     while (rs.next()) {
   //         String nimi = rs.getString("nimi");
   //         System.out.println(nimi);
//}
        
 //        stmt.close();
  //       rs.close();
  //
   //      connection.close();
    //     
   //  }
 
 //   private static void alustaTietokantaJaLuoNimia() {
        // mikäli poistat vahingossa tietokannan tai teet siihen muutoksia,
        // voit ajaa tämän metodin jolloin tietokantataulu luodaan uudestaan
        // ja siihen lisätään nimiä
 
        
 //       ArrayList<Student> opiskelijat = new ArrayList();
 //       opiskelijat.add(new Student("0123456", "Ted"));
 //       opiskelijat.add(new Student("1234567", "Aki"));
 //       opiskelijat.add(new Student("2345678", "Lea"));
 //       opiskelijat.add(new Student("3456789", "Aino"));
 //       opiskelijat.add(new Student("4567891", "Leo"));
        
//        ArrayList<Course> kurssit = new ArrayList();

//        kurssit.add(new Course("HY12345", "Tietokantojen perusteet", "Kurssi on osa tietojenkäsittelytieteen kandiohjelman perusopintoja", "kevät 2020"));
//        kurssit.add(new Course("HY23456", "Ohjelmoinnin johdanto", "Kurssi on osa tietojenkäsittelytieteen kandiohjelman perusopintoja", "kevät 2020"));
//        kurssit.add(new Course("HY34567", "Ohjelmoinnin jatkokurssi", "Kurssi on osa tietojenkäsittelytieteen kandiohjelman perusopintoja", "kevät 2020"));
//        kurssit.add(new Course("HY45678", "Johdatus tietojenkäsittelytieteeseen", "Kurssi on osa tietojenkäsittelytieteen kandiohjelman perusopintoja", "kevät 2020"));
//        kurssit.add(new Course("HY45678", "Tietokoneen toiminta", "Kurssi on osa tietojenkäsittelytieteen kandiohjelman perusopintoja", "kevät 2020"));
//        kurssit.add(new Course("HY56789", "Introduction to Cyber Security", "Course is part of bachelor-level course Introduction to Cyber Security", "spring 2020"));
//        kurssit.add(new Course("HY67891", "Securing Software", "Course is part of bachelor-level course Introduction to Cyber Security", "spring 2020"));
//        kurssit.add(new Course("HY78912", "Course Project I", "Course is part of bachelor-level course Introduction to Cyber Security", "spring 2020"));
//        kurssit.add(new Course("HY89123", "Advanced Topics", "Course is part of master-level course Cyber Security II", "spring 2020"));
//        kurssit.add(new Course("HY91234", "Course Project II", "Course is part of master-level course Cyber Security II", "spring 2020"));
  
        
        
 //       Random random = new Random();
        
 //       for(Student opiskelija: opiskelijat) {
 //           Integer suorituksia = random.nextInt(4);
 //           for(int i=0; i <= suorituksia; i++) {
 //               Course kurssi = kurssit.get(random.nextInt(4));
 //               if(!(opiskelija.getSuoritukset().keySet().contains(kurssi))) {
 //                   opiskelija.setSuoritus(kurssi, random.nextInt(4)+1);
 //               }
 //           }
  //          }

        
 //       for(Student opiskelija: opiskelijat) {
 //           for(Course kurssi: opiskelija.getSuoritukset().keySet()) {
 //               opiskelija.setIlmo(kurssi);
 //           }
 //       }
            
        
        
       
        
        
  //        try (Connection conn = DriverManager.getConnection("jdbc:h2:./henkilotietokanta", "sa", "")) {
      //        conn.prepareStatement("DROP TABLE Henkilo IF EXISTS;").executeUpdate();
      //        conn.prepareStatement("DROP TABLE Kurssit IF EXISTS;").executeUpdate();
      //        conn.prepareStatement("DROP TABLE Ilmoittautumiset IF EXISTS;").executeUpdate();
      //        
      //        conn.prepareStatement(
      //                "CREATE TABLE Opiskelija("
      //                        + "opiskelijanumero VARCHAR(20) PRIMARY KEY, "
      //                        + "nimi varchar(255));").executeUpdate();
      //        
      //        conn.prepareStatement(
      //                "CREATE TABLE Kurssit("
      //                        + "kurssi_id VARCHAR(20) PRIMARY KEY, "
      //                        + "nimi varchar(255), "
      //                        + "kuvaus varchar(500), "
      //                        + "aika varchar(255);").executeUpdate();
      //        
      //        conn.prepareStatement(
      //                "CREATE TABLE Suoritukset("
      //        //                + "id VARCHAR(20) PRIMARY KEY, "
      //                        + "opiskelijanumero Varchar(20), "
      //                        + "kurssi_id VARCHAR(20), "
      //                        + "arvosana INTEGER),"
      //                        + "FOREIGN KEY (opiskelijanumero) REFERENCES Opiskelija(opiskelijanumero)," 
      //                        + "FOREIGN KEY (kurssi_id) REFERENCES Kurssit(kurssi_id);").executeUpdate();
      //        
      //        
      //        for(Student opiskelija: opiskelijat) {  
      //        
      //            PreparedStatement statement =
      //                conn.prepareStatement("INSERT INTO Opiskelija (opiskelijanumero, nimi) VALUES (?, ?)");
      //                statement.setString(1, opiskelija.getNro());
      //                statement.setString(2, opiskelija.getNimi());
      //                statement.executeUpdate();
      //        }
      //        
      //        
      //        for(Course kurssi: kurssit) {  
      //        
      //            PreparedStatement statement =
      //                conn.prepareStatement("INSERT INTO Kurssit (kurssi_id, nimi, kuvaus, aika) VALUES (?, ?, ?, ?)");
      //                statement.setString(1, kurssi.getNro());
      //                statement.setString(2, kurssi.getNimi());
      //                statement.setString(3, kurssi.getKuvaus());
      //                statement.setString(4, kurssi.getAika());
      //                statement.executeUpdate();
      //        }
      //        
      //         for(Student opiskelija: opiskelijat) {  
      //             for(Course kurssi: opiskelija.getSuoritukset().keySet()) {  
  //
      //            PreparedStatement statement =
      //                conn.prepareStatement("INSERT INTO Suoritukset (opiskelijanumero, kurssi_id, arvosana) VALUES (?, ?, ?, ?)");
      //                statement.setString(1, opiskelija.getNro());
      //                statement.setString(2, kurssi.getNro());
      //                statement.setInt(3, opiskelija.getSuoritukset().get(kurssi));
      //                statement.executeUpdate();
      //        }
      //         }
      //        
      //        
      //            
     //         conn.prepareStatement("INSERT INTO Opiskelija (opiskelijanumero, nimi) VALUES (?, ?)"); 
   //         statement
   //                 + opiskelija.getNro()
   //                 + opiskelija.getNimi()
   //                 + ".executeLargeUpdate();
   //       } catch (SQLException ex) {
   //           Logger.getLogger(CyberSecurityBaseProjectApplication.class.getName()).log(Level.SEVERE, null, ex);
   //       }
   //   }
   //   }

