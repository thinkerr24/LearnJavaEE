package com.rr.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shw.HelloWorld;

public class JunitTest {
	// ��һ�ַ�ʽ���޲ι��촴�������������޲ι��췽��
	@Test 
	public void fun1() {
		// Loading applicationContext.xml
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Getting  instance of configuration
		HelloWorld helloWorld = (HelloWorld)ctx.getBean("helloWorld");
		
		// Invoke method
		helloWorld.show();
	}
	
	// �ڶ��ַ�ʽ����̬������ʽ
	@Test 
	public void fun2() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld helloWorld = (HelloWorld)ctx.getBean("hw2");
		helloWorld.show();
	}
	
	// �����ַ�ʽ��ʵ��������ʽ
	@Test 
	public void fun3() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld helloWorld = (HelloWorld)ctx.getBean("hw3");
		helloWorld.show();
	}
}
