package com.rr.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/** �൱��xml��<bean name="user"> 
 *  Ϊ�����ֶ���Ĳ�Σ�������ʹ��
 *  @Service("user") // service��
 *  @Repository("user") // dao��
 *  @Contorller("user") web��
 */
@Component("user")
// ָ����������÷�Χ��Ĭ��Ϊsingleton
@Scope(scopeName="singleton")
public class User {
	@Value("Tom")  // ͨ�������Field��ֵ���ƻ��˶���ķ�װ��
	private String name;
	@Value(value="18")
	private Integer age;
	//@Autowired // ���Զ�װ�� ����ж������һ�µĶ����޷�ѡ�����ע����һ������
	//@Qualifier("car2") // ��ʹ��@Qualifierע����Ϣٸ���spring�����Զ�װ����һ�����ƵĶ���
	
	@Resource(name="car2") // �۶����ڢ٢ڣ��ֶ�ע�룬ָ���ض����ƵĶ���
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
	
	@Value("Jerry") //ͨ��������������ֵ���Ƽ�ʹ��
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
	
	@PostConstruct //���󴴽�֮����ã��൱��init-method
	public void init( ) {
		System.out.println("��ʼ����������");
	}
	
	@PreDestroy  //��������֮ǰ���ã��൱��destroy-method
	public void destroy() {
		System.out.println("���ٷ�������");
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
	
    
}
