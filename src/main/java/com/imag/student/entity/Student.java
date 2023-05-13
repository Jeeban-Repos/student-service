package com.imag.student.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String studentId;
	@Column
	@NotBlank(message = "First Name is mandatory")
	private String studentfirstname;
	@Column
	@NotBlank(message = "Last Name is mandatory")
	private String studentlastname;
	@Column
	@NotBlank(message = "Date of Birth mandatory")
	private String dateofbirth;
	@Column
	private String section;
	@Column
	private String gender;
	@Column
	private int marks1;
	@Column
	private int marks2;
	@Column
	private int marks3;
	@Column
	private int total;
	@Column
	private double average;
	@Column
	private String result;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentfirstname() {
		return studentfirstname;
	}

	public void setStudentfirstname(String studentfirstname) {
		this.studentfirstname = studentfirstname;
	}

	public String getStudentlastname() {
		return studentlastname;
	}

	public void setStudentlastname(String studentlastname) {
		this.studentlastname = studentlastname;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getMarks1() {
		return marks1;
	}

	public void setMarks1(int marks1) {
		this.marks1 = marks1;
	}

	public int getMarks2() {
		return marks2;
	}

	public void setMarks2(int marks2) {
		this.marks2 = marks2;
	}

	public int getMarks3() {
		return marks3;
	}

	public void setMarks3(int marks3) {
		this.marks3 = marks3;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentfirstname=" + studentfirstname + ", studentlastname="
				+ studentlastname + ", dateofbirth=" + dateofbirth + ", section=" + section + ", gender=" + gender
				+ ", marks1=" + marks1 + ", marks2=" + marks2 + ", marks3=" + marks3 + ", total=" + total + ", average="
				+ average + ", result=" + result + "]";
	}

}
