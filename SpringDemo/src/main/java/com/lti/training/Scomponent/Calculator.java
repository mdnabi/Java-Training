package com.lti.training.Scomponent;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("Calci")  //replaces<bean> tag in the xml file-------- write the id name in the bracket.
@Scope("prototype")
public class Calculator implements SpringInterface {
	public int SayAdd(int x,int y)
	{
		return x+y;
	}

	public int SaySub(int x, int y) {
		return x-y;
	} 
	
	public Calculator() {
		System.out.println("Object ko bulao");
	}
	
}
