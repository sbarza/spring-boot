package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner -> {
            // createStudent(studentDAO);
            
            createMultipleStudents(studentDAO);

            // readStudent(studentDAO);

            // queryForStudents(studentDAO);

            // queryForStudentsByLastName(studentDAO);

            // updateStudent(studentDAO);

            // deleteStudent(studentDAO);

            // deleteAllStudents(studentDAO);

        };

    }

    private void deleteAllStudents(StudentDAO studentDAO) {

        System.out.println("Deleting all students ...");
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("Deleted row count: " + numRowsDeleted);

    }

    private void deleteStudent(StudentDAO studentDAO) {

        int studentId = 3;
        System.out.println("Deleting student id: " + studentId);
        studentDAO.delete(studentId);

    }

    private void updateStudent(StudentDAO studentDAO) {

        // Retrieve student based on the id: primary key
        int studentId = 1;
        System.out.println("Getting student with id: " + studentId);
        Student myStudent = studentDAO.findById(1);

        // Change first name to "Scooby"
        System.out.println("Updating student ...");
        myStudent.setFirstName("John");

        // Update the student
        studentDAO.update(myStudent);

        // Display the updated student
        System.out.println("Updated student: " + myStudent);

    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {

        // Get a list of students
        List<Student> theStudents = studentDAO.findByLastName("Doe");

        // Display list of students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {

        // Get a list of students
        List<Student> theStudents = studentDAO.findAll();

        // Display list of students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }

    }

    private void readStudent(StudentDAO studentDAO) {

        // Create a Student object
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");

        // Save the Student
        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        // Display id of the saved Student
        int theId = tempStudent.getId();
        System.out.println("Saved student. Generated id: " + theId);

        // Retrieve Student based on the id: primary key
        System.out.println("Retrieving student with id: " + theId);
        Student myStudent = studentDAO.findById(theId);

        // Display Student
        System.out.println("Found the student: " + myStudent);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {

        // Create multiple Students
        System.out.println("Creating 3 new student objects ...");
        Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
        Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
        Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

        // Save the Student object
        System.out.println("Saving the students ...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

    }

    private void createStudent(StudentDAO studentDAO) {

        // Create the Student object
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Paul", "Dow", "paul@luv2code.com");

        // Save the Student object
        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        // Display id of the saved Student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());

    }

}
