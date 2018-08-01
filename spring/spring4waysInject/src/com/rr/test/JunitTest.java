package com.rr.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rr.bean.User;

public class JunitTest {
	
	@Test
	public void fun1() {
		// 1.创建容器对象, 类路径xml
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2.向容器要User对象
		 User user = (User)ac.getBean("user");
		
		// 3.打印User对象
		System.out.println(user);
	}
	
	// 构造器注入
	@Test
	public void fun2() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = (User)ac.getBean("user2");
		System.out.println(user);
	}
	
	// p名称空间注入
	@Test
	public void fun3() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = (User)ac.getBean("user3");
		System.out.println(user);
	}
	
	// SPEL注入
	@Test
	public void fun4() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = (User)ac.getBean("user4");
		System.out.println(user);
	}
	
}
	
