package com.springcore.constructorInjection;

public class Certificate {
	private String name;

	@Override
	public String toString() {
		return "Certificate [name=" + name + "]";
	}

	public Certificate(String name) {
		super();
		System.out.println(name);
		this.name = name;
	}
	
}
