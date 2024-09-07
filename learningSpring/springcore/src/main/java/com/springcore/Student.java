package com.springcore;

public class Student {
	private int studentId;
	private String studentAddress;
	private String studentName;
	public Student() {
		super();
	}
	public Student(int studentId, String studentAddress, String studentName) {
		super();
		this.studentId = studentId;
		this.studentAddress = studentAddress;
		this.studentName = studentName;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentAddress=" + studentAddress + ", studentName=" + studentName
				+ "]";
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		System.out.println("setting student id");
		this.studentId = studentId;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		System.out.println("setting student address");
		this.studentAddress = studentAddress;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		System.out.println("setting student name");
		this.studentName = studentName;
	}
	

}
