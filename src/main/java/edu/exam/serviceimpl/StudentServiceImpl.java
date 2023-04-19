package edu.exam.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.exam.Entity.Student;
import edu.exam.dto.StudentDTO;
import edu.exam.exception.UserNotFoundException;
import edu.exam.repository.StudentRepository;
import edu.exam.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired // Constructor Injection
	private StudentRepository studentRepository;

	// To display all the Alumni
	@Override
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	// To add an Alumni
	@Override
	public Student createStudent(StudentDTO studentDTO) {
		Student student = Student.builder().name(studentDTO.getName()).qualification(studentDTO.getQualification())
				.build();

		return studentRepository.save(student);
	}

	// To update an Student's details by their Id
	@Override
	public Student updateStudent(int id, StudentDTO studentDTO) throws UserNotFoundException {
		Optional<Student> adata = studentRepository.findById(id);
		if (adata.isPresent()) {
			Student _student = studentRepository.findById(id).get();
			_student.setName(studentDTO.getName());
			_student.setQualification(studentDTO.getQualification());

			return studentRepository.save(_student);
		} else
			throw new UserNotFoundException("No user bearing id " + id + " can be found");
	}

	// To find an Alumni by their Id
	@Override
	public Student getAllStudentById(int id) {
		return studentRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("No user bearing id " + id + " can be found"));
	}

	// To find an Student by their name
	@Override
	public List<Student> findByNameContaining(String name) throws UserNotFoundException {
		if (studentRepository.findByNameContaining(name).isEmpty())

			throw new UserNotFoundException("No student bearing name " + name + " can be found");

		else

			return studentRepository.findByNameContaining(name);
	}

	// To find an Student by their Qualification
	@Override
	public List<Student> findByQualificationContaning(String qualification) {
		if (studentRepository.findByQualificationContaining(qualification).isEmpty())

			throw new UserNotFoundException("No student with Qualification " + qualification + " can be found");

		else

			return studentRepository.findByQualificationContaining(qualification);
	}

	// To delete an Student by their Id
	@Override
	public String deleteStudent(int id) {
		studentRepository.deleteById(id);
		return "Student bearing Id " + id + "has been deleted sucessfully!";
	}

}
