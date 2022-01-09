package com.muneeb.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muneeb.sms.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
}
