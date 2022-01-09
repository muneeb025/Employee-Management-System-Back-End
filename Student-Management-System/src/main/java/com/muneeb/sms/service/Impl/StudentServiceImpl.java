package com.muneeb.sms.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.muneeb.sms.entity.Student;
import com.muneeb.sms.exception.ResourceNotFoundException;
import com.muneeb.sms.repository.StudentRepository;
import com.muneeb.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		return studentRepository.findAll();

	}

	@Override
	public Student getStudentById(long id) {
		return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));

	}

	@Override
	public Student updateStudentById(Student student, long id) {
		Student existingStudent = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("student", "id", id));

		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());

		studentRepository.save(existingStudent);
		return existingStudent;
	}

	@Override
	public void deleteStudentById(long id) {
		studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("student", "id", id));

		studentRepository.deleteById(id);

	}

}
