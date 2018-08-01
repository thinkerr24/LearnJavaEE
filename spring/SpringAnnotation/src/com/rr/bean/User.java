package com.rr.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/** 相当于xml中<bean name="user"> 
 *  为了区分对象的层次，还可以使用
 *  @Service("user") // service层
 *  @Repository("user") // dao层
 *  @Contorller("user") web层
 */
@Component("user")
// 指定对象的作用范围，默认为singleton
@Scope(scopeName="singleton")
public class User {
	@Value("Tom")  // 通过反射的Field赋值，破坏了对象的封装性
	private String name;
	@Value(value="18")
	private Integer age;
	//@Autowired // ①自动装配 如果有多个类型一致的对象，无法选择具体注入哪一个对象
	//@Qualifier("car2") // ②使用@Qualifier注解配合①告诉spring容器自动装配哪一个名称的对象
	
	@Resource(name="car2") // ③独立于①②，手动注入，指定特定名称的对象
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
	
	@Value("Jerry") //通过调用设置器赋值，推荐使用
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
	
	@PostConstruct //对象创建之后调用，相当于init-method
	public void init( ) {
		System.out.println("初始化方法调用");
	}
	
	@PreDestroy  //对象销毁之前调用，相当于destroy-method
	public void destroy() {
		System.out.println("销毁方法调用");
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
	
    
}
