package com.rr.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rr.bean.User;

public class JunitTest {
	
	@Test
	public void fun1() {
		// 1.������������, ��·��xml
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2.������ҪUser����
		 User user = (User)ac.getBean("user");
		
		// 3.��ӡUser����
		System.out.println(user);
	}
	
	// ������ע��
	@Test
	public void fun2() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = (User)ac.getBean("user2");
		System.out.println(user);
	}
	
	// p���ƿռ�ע��
	@Test
	public void fun3() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = (User)ac.getBean("user3");
		System.out.println(user);
	}
	
	// SPELע��
	@Test
	public void fun4() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = (User)ac.getBean("user4");
		System.out.println(user);
	}
	
}
	
