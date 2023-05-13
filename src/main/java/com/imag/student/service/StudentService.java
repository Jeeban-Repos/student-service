package com.imag.student.service;

import org.springframework.http.ResponseEntity;

import com.imag.student.models.StudentDTO;

public interface StudentService {

	ResponseEntity<StudentDTO> saveStudent(StudentDTO studentDTO);

}
