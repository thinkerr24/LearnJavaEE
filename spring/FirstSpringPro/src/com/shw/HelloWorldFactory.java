package com.shw;

public class HelloWorldFactory {
	public static HelloWorld createHelloWorld() {
		System.out.println("��̬������ʽ����!");
		return new HelloWorld();
	}
	
	public HelloWorld rcreateHelloWorld() {
		System.out.println("ʵ��������ʽ��������");
		return new HelloWorld();
	}
}
