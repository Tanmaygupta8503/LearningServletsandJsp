package com.springcore.spring_expression_language;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Demo {
	@Value("#{22+11 - 5 * 2}")
	private int x;
	@Value("#{8 > 6 ? 90 : 100}")
	private int y;
	@Value("#{T(java.lang.Math).sqrt(169)}")
	private double sqrt;
	@Value("#{new java.lang.String('Tanmay Gupta')}")
	private String name;
	@Value("#{8 > 3}")
	private boolean isActive;
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public double getSqrt() {
		return sqrt;
	}
	public void setSqrt(double sqrt) {
		this.sqrt = sqrt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "Demo [x=" + x + ", y=" + y + ", sqrt=" + sqrt + ", name=" + name + ", isActive=" + isActive + "]";
	}
	
}
