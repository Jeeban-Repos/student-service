package com.imag.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imag.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>{

	
}
