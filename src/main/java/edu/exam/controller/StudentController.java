package edu.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.exam.Entity.Student;
import edu.exam.dto.StudentDTO;
import edu.exam.service.StudentService;
import jakarta.validation.Valid;

	@RestController
	@RequestMapping("/api")
	public class StudentController {
		
		//Constructor Injection
			@Autowired
			private StudentService studentService;
			
			
			//Adds a new Student
			@PostMapping("/students")
			public ResponseEntity<Student> createStudent(@RequestBody @Valid StudentDTO a) 
			{
				
				     Student a1 = studentService.createStudent(a);
					 return new ResponseEntity<>(a1, HttpStatus.CREATED);
				
			}
			

			//Updates an Student based on their Id
			@PutMapping("/students/{id}")
			public ResponseEntity<Student> updateStudent(@PathVariable("id") int id, @RequestBody StudentDTO studentDTO)
			{
				
				studentService.updateStudent(id, studentDTO);
					return ResponseEntity.ok().body(studentService.updateStudent(id, studentDTO));
				
			}
			

			//Displays an Student based on their name
			@GetMapping("/studentsname")
			public ResponseEntity<List<Student>> getStudentByName(@RequestParam(required = false) String name)
			 {
				
					List<Student> student = studentService.findByNameContaining(name);
					return ResponseEntity.ok(student);
					
			 }

			//Displays an Student based on their Qualification
			@GetMapping("/studentsqualification")
			public ResponseEntity<List<Student>> getStudentByQualification(@RequestParam(required = false) String qualification)
			{
						
					List<Student> student= studentService.findByQualificationContaning(qualification);
					return ResponseEntity.ok(student);
							
			}
			
			//Displays an Student based on their Id
			@GetMapping("/students/{id}")
			public ResponseEntity<Student> getAllStudentById(@PathVariable int id) 
			{
				
				return ResponseEntity.ok().body(studentService.getAllStudentById(id));
			
			}
			

			//Deletes an Student based on their Id
			@DeleteMapping("/students/{id}")
			public ResponseEntity<Student> deleteStudent(@PathVariable int id)
			{
				studentService.deleteStudent(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			}
			
			//Lists all the Student
			@GetMapping("/students")
			public ResponseEntity <List<Student>>fetchAllStudents() 
			{
				
				List<Student> student = studentService.getAllStudent();
				return ResponseEntity.ok(student);
			
			}

	}
