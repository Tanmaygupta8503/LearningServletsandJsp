package com.springcore.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Student {
	private String action;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [action=" + action + "]";
	}
	@PostConstruct
	public void startAction() {
		System.out.println("Student start " + action);
	}
	@PreDestroy
	public void stopAction() {
		System.out.println("Student stop " + action);
	}
}
