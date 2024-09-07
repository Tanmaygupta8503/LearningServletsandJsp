package com.springcore.stereotype;

public class Teacher {
	private String name;
	private int subjectCode;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(int subjectCode) {
		this.subjectCode = subjectCode;
	}
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", subjectCode=" + subjectCode + "]";
	}
}
