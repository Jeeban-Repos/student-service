package com.imag.student.models;

public class StudentDTO {

//	private String student_id;
	private String student_first_name;
	private String student_last_name;
	private String date_of_birth;
	private String section;
	private String gender;
	private String marks1;
	private String marks2;
	private String marks3;
	private int total;
	private double average;
	private String result;

//	public String getStudent_id() {
//		return student_id;
//	}
//
//	public void setStudent_id(String student_id) {
//		this.student_id = student_id;
//	}

	public String getStudent_first_name() {
		return student_first_name;
	}

	public void setStudent_first_name(String student_first_name) {
		this.student_first_name = student_first_name;
	}

	public String getStudent_last_name() {
		return student_last_name;
	}

	public void setStudent_last_name(String student_last_name) {
		this.student_last_name = student_last_name;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
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

	public String getMarks1() {
		return marks1;
	}

	public void setMarks1(String marks1) {
		this.marks1 = marks1;
	}

	public String getMarks2() {
		return marks2;
	}

	public void setMarks2(String marks2) {
		this.marks2 = marks2;
	}

	public String getMarks3() {
		return marks3;
	}

	public void setMarks3(String marks3) {
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
		return "StudentDTO [student_first_name=" + student_first_name
				+ ", student_last_name=" + student_last_name + ", date_of_birth=" + date_of_birth + ", section="
				+ section + ", gender=" + gender + ", marks1=" + marks1 + ", marks2=" + marks2 + ", marks3=" + marks3
				+ ", total=" + total + ", average=" + average + ", result=" + result + "]";
	}
}
