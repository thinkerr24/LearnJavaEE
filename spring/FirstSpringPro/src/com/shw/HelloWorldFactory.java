package com.shw;

public class HelloWorldFactory {
	public static HelloWorld createHelloWorld() {
		System.out.println("静态工厂方式创建!");
		return new HelloWorld();
	}
	
	public HelloWorld rcreateHelloWorld() {
		System.out.println("实例工厂方式创建对象");
		return new HelloWorld();
	}
}
