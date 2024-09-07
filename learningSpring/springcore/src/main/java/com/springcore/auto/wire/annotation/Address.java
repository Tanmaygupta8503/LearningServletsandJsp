package com.springcore.auto.wire.annotation;

public class Address {
	private String street;
	private String city;
	public Address(String street ,String city) {
		super();
		System.out.println("setting by constructor");

		this.city = city;
		this.street = street;
	}
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + "]";
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		System.out.println("setting by setter");
		this.street = street;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
