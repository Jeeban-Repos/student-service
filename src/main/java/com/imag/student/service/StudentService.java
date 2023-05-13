package com.imag.student.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import com.imag.student.models.StudentDTO;

import jakarta.validation.Valid;

public interface StudentService {

	ResponseEntity<StudentDTO> saveStudent(StudentDTO studentDTO);

	HttpEntity<StudentDTO> updateStudent(StudentDTO studentDTO);

}
