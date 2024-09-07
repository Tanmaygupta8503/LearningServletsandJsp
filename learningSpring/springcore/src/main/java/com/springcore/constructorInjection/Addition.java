package com.springcore.constructorInjection;

public class Addition {
	private int a;
	private int b;
	@Override
	public String toString() {
		return "Addition [a=" + a + ", b=" + b + "]";
	}
	public Addition(int a, int b) {
		super();
		this.a = a;
		this.b = b;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}
	public Addition(double a, double b) {
		super();
		this.a = (int)a;
		this.b = (int)b;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}
	public int sum() {
		return a + b;
	}
}
