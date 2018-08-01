package com.shw;
public class HelloWorld {
	private String userName;
	
	public HelloWorld() {
		System.out.println("HelloWorld无参方法被调用!");
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void show() {
		System.out.println("Welcome " + userName + " to study Spring!");
	}
}