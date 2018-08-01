package com.rr.bean;

public class User {
	private String name;
	private Integer age;
	private Car car;
	
	public User() {
		
	}
	public User(String name, Car car) {
		System.out.println("User constructor with 2 parameter method called!");
		this.name = name;
		this.car = car;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
	
    
}
