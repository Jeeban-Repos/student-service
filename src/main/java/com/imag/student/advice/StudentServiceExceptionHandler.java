package com.imag.student.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.imag.student.exception.StudentException;
import com.imag.student.exception.StudentValidationException;

@RestControllerAdvice
public class StudentServiceExceptionHandler {

//	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public StudentException inValidParameterValueException(MethodArgumentNotValidException exception) {

		Map<String, String> errorMessageMap = new HashMap<>();

		exception.getBindingResult().getFieldErrors().forEach(excep -> {
			errorMessageMap.put(excep.getField(), excep.getDefaultMessage());
		});

//		return errorMessageMap;

		return new StudentException(errorMessageMap, HttpStatus.BAD_REQUEST.toString());

	}

	@ExceptionHandler(value = StudentValidationException.class)
	public StudentException studentValidationException(StudentValidationException studentValidationException) {
		return new StudentException(HttpStatus.BAD_REQUEST.toString(),
				studentValidationException.getExceptionMessage());

	}

	@ExceptionHandler(value = Exception.class)
	public StudentException otherException(Exception exception) {
		return new StudentException(HttpStatus.BAD_REQUEST.toString(), "Something went wrong");

	}

}
