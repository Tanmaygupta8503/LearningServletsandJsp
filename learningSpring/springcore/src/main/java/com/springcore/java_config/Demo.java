package com.springcore.java_config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

//@Component
public class Demo {
	public Demo(Samosa samosa) {
		super();
		this.samosa = samosa;
	}
	private Samosa samosa;
	public Samosa getSamosa() {
		return samosa;
	}
	public void setSamosa(Samosa samosa) {
		this.samosa = samosa;
	}
	public void study() {
		this.samosa.display();
		System.out.println("Studying i am");
	}
}
