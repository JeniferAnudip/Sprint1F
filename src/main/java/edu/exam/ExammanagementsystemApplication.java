package edu.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import edu.exam.Entity.Student;
import edu.exam.repository.StudentRepository;

@SpringBootApplication
public class ExammanagementsystemApplication implements CommandLineRunner {
	//Constructor Injection
		@Autowired
		private StudentRepository studentrepository;
		
	public static void main(String[] args) {
		SpringApplication.run(ExammanagementsystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student a1 = Student.builder().name("sneha").qualification("BCA").build();
		Student a2 = Student.builder().name("Deva").qualification("BSC").build();
		Student a3 = Student.builder().name("vedhashree").qualification("BCA").build();
		
		
		studentrepository.save(a1);
		studentrepository.save(a2);
		studentrepository.save(a3);
		
		System.out.println("--------------------------All saved-------------------------");

		
	}

}
