package com.rr.junit;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rr.bean.User;

public class JunitTest {
	@Test
	public void fun1() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/rr/bean/applicationContext.xml");
		User user = (User) ac.getBean("user");
		//User user1 = (User) ac.getBean("user");
		System.out.println(user);
	}
	
	@Test
	public void fun3() {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("com/rr/bean/applicationContext.xml");
		User user = (User) ac.getBean("user");
		System.out.println(user);
		ac.close();
	}
}
