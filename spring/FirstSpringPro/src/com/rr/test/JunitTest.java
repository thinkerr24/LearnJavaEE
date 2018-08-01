package com.rr.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shw.HelloWorld;

public class JunitTest {
	// 第一种方式，无参构造创建，会调用类的无参构造方法
	@Test 
	public void fun1() {
		// Loading applicationContext.xml
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Getting  instance of configuration
		HelloWorld helloWorld = (HelloWorld)ctx.getBean("helloWorld");
		
		// Invoke method
		helloWorld.show();
	}
	
	// 第二种方式，静态工厂方式
	@Test 
	public void fun2() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld helloWorld = (HelloWorld)ctx.getBean("hw2");
		helloWorld.show();
	}
	
	// 第三种方式，实例工厂方式
	@Test 
	public void fun3() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld helloWorld = (HelloWorld)ctx.getBean("hw3");
		helloWorld.show();
	}
}
