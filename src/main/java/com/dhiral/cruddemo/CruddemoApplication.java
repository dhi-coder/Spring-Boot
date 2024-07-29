package com.dhiral.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dhiral.cruddemo.dao.StudentDAO;
import com.dhiral.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO thestudentDAO) {
	return runner ->{
		//createStudent(thestudentDAO);
		createMultipleStudent(thestudentDAO);
		// retriveStudentById(thestudentDAO);
		//queryForAllStudents(thestudentDAO);
		
		// queryForStydentByLastName(thestudentDAO);
		//updateStudents(thestudentDAO);
		// deleteStudent(thestudentDAO);
		// deleteAllRows(thestudentDAO);
	};
	}

	private void deleteAllRows(StudentDAO thestudentDAO) {
		System.out.println("Deleting all Students");
		
		int noOfRows = thestudentDAO.DeleteALL();
		
		System.out.println(+noOfRows + " rows have been deleted");
		
	}

	private void deleteStudent(StudentDAO thestudentDAO) {
		int id=3;
		System.out.println("Deleting student with id "+id);
		thestudentDAO.Delete(id);
		
	}

	private void updateStudents(StudentDAO thestudentDAO) {
		// retrive students based on id 
		int studentId =1;
		System.out.println("Retriving details of student with id "+studentId);
		Student myStudent = thestudentDAO.findByid(studentId);
		// change first  name to Sccoby
		System.out.println("Updating student ...");
		myStudent.setFirstName("Scooby");
		// update the styudententityManager
		thestudentDAO.update(myStudent);
		// display updaterd student
		System.out.println("Updated Student "+myStudent);
		
	}

	private void queryForStydentByLastName(StudentDAO thestudentDAO) {
		// get list of Students

		List<Student> theStudents = thestudentDAO.findByLatname("Smith");
		
		// display the students
		
		for(Student theStudent : theStudents) {
			System.out.println(theStudent);
		}
	}

	private void queryForAllStudents(StudentDAO thestudentDAO) {
		// get a list of students
		List<Student> theStudents = thestudentDAO.findAllStudent();
		//display the list of students
		System.out.println("The list of students are ");
		for(Student tempStudent: theStudents ) {
			System.out.println(tempStudent);
		}
	}

	private void retriveStudentById(StudentDAO thestudentDAO) {
		// create student
		System.out.println("Creating new Studenmt Object... ");
		Student tempStudent = new Student("Will", "Smith", "Willsmaith@gmail.com");
		
		// save the student
		System.out.println("Saving student details acc to");

		thestudentDAO.savez(tempStudent);
		
		// display the ifd of the saved 
		
		int id = tempStudent.getId();
		System.out.println("Id of the Student is " +id);
		
		// retrive student by id
		System.out.println("Retriving student details acc to id "+id);
		Student myStudent = thestudentDAO.findByid(id);
		
		// dispaly student
		System.out.println("Student details "+myStudent);
		
	}

	private void createMultipleStudent(StudentDAO thestudentDAO) {
		// create multiple student
		System.out.println("Creating 3 new Studenmt Object... ");
		Student tempStudent1 = new Student("john", "Smith", "johnsmaith@gmail.com");
		Student tempStudent2 = new Student("mark", "twain", "marktwain@gmail.com");
		Student tempStudent3 = new Student("lisa", "moon", "lisamoon@gmail.com");
		
		// save the student object
		System.out.println("Saving the objects");
		thestudentDAO.savez(tempStudent1);
		thestudentDAO.savez(tempStudent2);
		thestudentDAO.savez(tempStudent3);
		
		
	}

	private void createStudent(StudentDAO thestudentDAO) {
		// CREaTE Student object
		System.out.println("Creating new Studenmt Object... ");
		Student tempStudent = new Student("Paul", "Smith", "paulsmaith@gmail.com");
		
		// save the object 
		System.out.println("Saving  Studenmt Object... ");
		thestudentDAO.savez(tempStudent);

		// display student id
		System.out.println("Saved  Studenmt Object, Generated id : "+tempStudent.getId());
		

	}

}
