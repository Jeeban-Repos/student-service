package com.imag.student.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.imag.student.entity.Student;
import com.imag.student.exception.StudentValidationException;
import com.imag.student.models.Gender;
import com.imag.student.models.Section;
import com.imag.student.models.StudentDTO;
import com.imag.student.repository.StudentRepository;

import jakarta.validation.Valid;

@Service
public class StudentServiceImpl implements StudentService {

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
		validateData(studentDTO);

		student.setStudentfirstname(studentDTO.getStudent_first_name());
		student.setStudentlastname(studentDTO.getStudent_last_name());
		student.setDateofbirth(studentDTO.getDate_of_birth());
		student.setSection(studentDTO.getSection());
		student.setMarks1(
				Integer.parseInt(studentDTO.getMarks1() == null || studentDTO.getMarks1().trim().isEmpty() ? "0"
						: studentDTO.getMarks1()));
		student.setMarks2(
				Integer.parseInt(studentDTO.getMarks2() == null || studentDTO.getMarks2().trim().isEmpty() ? "0"
						: studentDTO.getMarks2()));
		student.setMarks3(
				Integer.parseInt(studentDTO.getMarks3() == null || studentDTO.getMarks3().trim().isEmpty() ? "0"
						: studentDTO.getMarks3()));
		student.setGender(studentDTO.getGender());
	}

	private static boolean validateData(StudentDTO studentDTO) {

		boolean isValid = false;

		if (null != studentDTO.getStudent_first_name() && studentDTO.getStudent_first_name().length() > 3
				&& studentDTO.getStudent_last_name().length() > 3) {
			isValid = true;
		} else {
			throw new StudentValidationException("Student First Name and Last Name Must have atleast 3 characters");
		}

		if (null != studentDTO.getDate_of_birth() && !studentDTO.getDate_of_birth().trim().isEmpty()) {
			LocalDate dob = LocalDate.parse(studentDTO.getDate_of_birth());
			LocalDate currentDate = LocalDate.now();

			Period period = Period.between(dob, currentDate);
			if (period.getYears() >= 15 && period.getYears() <= 20) {
				isValid = true;
			} else {
				throw new StudentValidationException("Age Should be between 15 and 20");
			}
		}

		if (null != studentDTO.getSection() && !studentDTO.getSection().trim().isEmpty()) {
			if (studentDTO.getSection().equals(Section.A.toString())
					|| studentDTO.getSection().equals(Section.B.toString())
					|| studentDTO.getSection().equals(Section.C.toString())) {
				isValid = true;
			} else {
				throw new StudentValidationException("Invalid Section");
			}
		}

		if (null != studentDTO.getGender() && (studentDTO.getGender().equals(Gender.M.toString())
				|| studentDTO.getGender().equals(Gender.F.toString()))) {
			isValid = true;
		} else {
			throw new StudentValidationException("In valid Gender");
		}

		return isValid;
	}

	private static void convertStudentToStudentDTO(StudentDTO studentDTO, Student student) {

		studentDTO.setStudent_id(student.getStudentId());
		studentDTO.setStudent_first_name(student.getStudentfirstname());
		studentDTO.setStudent_last_name(student.getStudentlastname());
		studentDTO.setDate_of_birth(student.getDateofbirth());
		studentDTO.setMarks1(Integer.toString(student.getMarks1()));
		studentDTO.setMarks2(Integer.toString(student.getMarks2()));
		studentDTO.setMarks3(Integer.toString(student.getMarks3()));
		studentDTO.setSection(student.getSection());
		studentDTO.setGender(student.getGender());
		studentDTO.setTotal(student.getTotal());
		studentDTO.setAverage(student.getAverage());
		studentDTO.setResult(student.getResult());
	}

	@Override
	public ResponseEntity<StudentDTO> updateStudent(StudentDTO studentDTO) {

		validateData(studentDTO);

		Student student = null;
		Optional<Student> studentOpt = studentRepo.findById(studentDTO.getStudent_id());

		if (studentOpt.isPresent()) {
			student = studentOpt.get();
			
			if (null != studentDTO.getMarks1() && !studentDTO.getMarks1().trim().isEmpty()
					&& null != studentDTO.getMarks2() && !studentDTO.getMarks2().trim().isEmpty()
					&& null != studentDTO.getMarks3() && !studentDTO.getMarks3().trim().isEmpty()) {
				
				student.setMarks1(Integer.parseInt(studentDTO.getMarks1()));
				student.setMarks2(Integer.parseInt(studentDTO.getMarks2()));
				student.setMarks3(Integer.parseInt(studentDTO.getMarks3()));

				calculateToalAndAverageOfMarks(student);
			}else {
				throw new StudentValidationException("Marks are mandatory && can not be empty");
			}
		}
		convertStudentToStudentDTO(studentDTO, studentRepo.save(student));
		return ResponseEntity.of(Optional.of(studentDTO));
	}
}
