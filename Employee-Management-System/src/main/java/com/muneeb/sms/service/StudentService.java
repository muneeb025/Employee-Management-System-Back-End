package com.muneeb.sms.service;

import java.util.List;

import com.muneeb.sms.entity.Student;

public interface StudentService {

	public Student saveStudent(Student student);
	public List<Student> getAllStudent();
	public Student getStudentById(long id);
	public Student updateStudentById(Student student, long id);
	public void deleteStudentById(long id);
	
}
