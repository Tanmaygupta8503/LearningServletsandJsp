package com.springcore.auto.wire.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Employee {
	@Autowired
	@Qualifier("address2")
	private Address address;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	// @Autowired by constructor
//	@Autowired
	public Employee(Address address) {
		super();
		System.out.println("autowiring by constructor");
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}
	// @Autowired by setter
//	@Autowired
	public void setAddress(Address address) {
		System.out.println("autowiring by setter");
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [address=" + address + "]";
	}
	
}
