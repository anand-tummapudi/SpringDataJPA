package com.anand.springdatajpa.test;

import com.anand.springdatajpa.entity.Guardian;
import com.anand.springdatajpa.entity.Student;
import com.anand.springdatajpa.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
//@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                        .emailId("anand@gmail.com")
                        .firstName("Anji").build();
                        /*//.guardianName("Guardian")
                        .guardianEmail("guardian@guarmail.com")
                        .guardianMobile("9848022338").build();
   */     studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Sreya")
                .email("sreya@gmail.com")
                .mobile("9493235452")
                .build();
      Student student = Student.builder()
                      .firstName("Kavya")
                      .lastName("Kurravi")
                      .emailId("kavya@gmail.com")
              .guardian(guardian)
              .build();
      studentRepository.save(student);
    }
    @Test
    public void printAllStudents(){
        List<Student> studentList = studentRepository.findAll();

        studentList.stream().forEach(s-> System.out.println(s));
    }
}
