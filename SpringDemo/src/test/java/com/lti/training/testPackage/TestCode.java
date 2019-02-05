package com.lti.training.testPackage;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.training.Scomponent.Calculator;
import com.lti.training.Scomponent.HelloWorld;
import com.lti.training.Scomponent.SpringInterface;
import com.lti.training.Scomponent.TextEditor;


public class TestCode {
	public static void main(String[] args) {
		//Loading the IoC (Inversion of Control) container
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		
		//Accessing one of the bean
		HelloWorld hw = (HelloWorld) context.getBean("HelloYou");
		System.out.println(hw.sayHello("Shreya Atrawalkar. Have a nice day!"));
	
		for(int i=0;i<5;i++) {
			SpringInterface cal= (SpringInterface)context.getBean("Calci");  //class obj= (class)context.getbean("id")
		}
		
		TextEditor te = (TextEditor) context.getBean("te");
		te.loadTextDocument("abc.txt");
			
//		System.out.println(cal.SayAdd(4, 10));
//		System.out.println(cal.SaySub(15, 12));	
	}		
}
