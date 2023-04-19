package edu.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.exam.Entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByQualificationContaining(String qualification);

	List<Student> findByNameContaining(String name);

}
