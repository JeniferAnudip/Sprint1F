package edu.exam.service;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.exam.Entity.Student;
import edu.exam.dto.StudentDTO;

@Component
public interface StudentService {
	//To get record of all the Student
		List<Student> getAllStudent();
		
		//To add a new Student
		Student createStudent(StudentDTO studentDTO);
		
		//To update an Student using Id
		Student updateStudent(int id,StudentDTO studentDTO);
		
		//To display an Student using Id
		Student getAllStudentById(int id);
		
		//To display an Student using its name
		List<Student> findByNameContaining(String name);
		
		//To display an Student using graduation year
		List<Student> findByQualificationContaning(String qualification);
		
		//To delete an Student by its Id
		String deleteStudent(int id);
}
