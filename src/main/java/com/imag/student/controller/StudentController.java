package com.imag.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imag.student.models.StudentDTO;
import com.imag.student.service.StudentService;

@RestController
@RequestMapping(path = "/student")
public class StudentController {
	
	@Autowired
	public StudentService studentService;

	@PostMapping(value = "/save")
	public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO studentDto) {
		return studentService.saveStudent(studentDto);
	}

}
