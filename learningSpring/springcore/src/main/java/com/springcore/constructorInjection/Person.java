package com.springcore.constructorInjection;

import java.util.List;

public class Person {
	private int personId;
	private String personName;
	private Certificate certi;
	private List<String> neighbour;
	public Person(int personId, String personName , Certificate certi , List<String> neighbour) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.certi = certi;
		this.neighbour=neighbour;
	}
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", certi=" + certi + ", neighbour="
				+ neighbour + "]";
	}
}
