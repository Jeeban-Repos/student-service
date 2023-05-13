package com.imag.student.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.imag.student.entity.Student;
import com.imag.student.models.Gender;
import com.imag.student.models.StudentDTO;
import com.imag.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepo;

	@Override
	public ResponseEntity<StudentDTO> saveStudent(StudentDTO studentDTO) {
		Student student = new Student();
		convertStudentDTOtoEnitity(studentDTO, student);

		if (null != student) {
			if (student.getMarks1() < 35 && student.getMarks2() < 35 && student.getMarks3() < 35) {
				calculateToalAndAverageOfMarks(student);
				student.setResult("FAIL");
			} else {
				// calculate total & average
				calculateToalAndAverageOfMarks(student);
				student.setResult("PASS");
			}
		}
		convertStudentToStudentDTO(studentDTO, studentRepo.save(student));
		return ResponseEntity.of(Optional.of(studentDTO));
	}

	private void calculateToalAndAverageOfMarks(Student student) {
		int totalMark = student.getMarks1() + student.getMarks2() + student.getMarks3();
		double averageMark = totalMark / 3;

		student.setTotal(totalMark);
		student.setAverage(averageMark);
	}

	private static void convertStudentDTOtoEnitity(StudentDTO studentDTO, Student student) {

		student.setStudentfirstname(studentDTO.getStudent_first_name());
		student.setStudentlastname(studentDTO.getStudent_last_name());
		
		if (validateData(studentDTO)) {
			student.setDateofbirth(studentDTO.getDate_of_birth());
			student.setSection(studentDTO.getSection());
		}else {
			// throw exception
		}

		student.setMarks1(Integer.parseInt(studentDTO.getMarks1()));
		student.setMarks2(Integer.parseInt(studentDTO.getMarks2()));
		student.setMarks3(Integer.parseInt(studentDTO.getMarks3()));
		
		
		

		if (studentDTO.getGender().equals(Gender.M.toString()) || studentDTO.getGender().equals(Gender.F.toString()))
			student.setGender(studentDTO.getGender());
		else {
			// throw exception
		}
	}

	private static boolean validateData(StudentDTO studentDTO) {

		if(null!=studentDTO.getDate_of_birth() && !studentDTO.getDate_of_birth().trim().isEmpty()) {
			LocalDate dob = LocalDate.parse(studentDTO.getDate_of_birth());
			LocalDate currentDate = LocalDate.now();

			Period period = Period.between(dob, currentDate);
			if (period.getYears() >= 15 && period.getYears() <= 20)
				return true;
			
		}
		
		if(null!=studentDTO.getSection() && !studentDTO.getSection().trim().isEmpty()) {
			
		}
		
		
		return false;
	}

	private static void convertStudentToStudentDTO(StudentDTO studentDTO, Student student) {

		studentDTO.setStudent_first_name(studentDTO.getStudent_first_name());
		studentDTO.setStudent_last_name(studentDTO.getStudent_last_name());
		studentDTO.setDate_of_birth(studentDTO.getDate_of_birth());
		studentDTO.setMarks1(studentDTO.getMarks1());
		studentDTO.setMarks2(studentDTO.getMarks2());
		studentDTO.setMarks3(studentDTO.getMarks3());
		studentDTO.setSection(studentDTO.getSection());
		studentDTO.setGender(studentDTO.getGender());
		studentDTO.setTotal(studentDTO.getTotal());
		studentDTO.setAverage(studentDTO.getAverage());
		studentDTO.setResult(studentDTO.getResult());
	}
}
