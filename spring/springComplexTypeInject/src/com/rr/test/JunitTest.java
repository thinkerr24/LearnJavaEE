package com.rr.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rr.bean.CollectionBean;
import com.rr.bean.User;

public class JunitTest {
	
	@Test
	public void fun1() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		 User user = (User)ac.getBean("user");
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
	
	// 复杂类型注入(数组，列表，集合...)
	@Test
	public void fun5() { 
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		CollectionBean cb = (CollectionBean)ac.getBean("cb");
		System.out.println(cb);
	}
	
}
	
