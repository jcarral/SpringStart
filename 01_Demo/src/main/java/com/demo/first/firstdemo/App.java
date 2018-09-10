package com.demo.first.firstdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
public static void main(String[] args) {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("com/demo/xml/beans.xml");
	Library lib = (Library) ctx.getBean("library");
	
	Library lib2 = (Library) ctx.getBean("library");
	lib2.setName("Secundaria");
	
	System.out.println(lib);
	System.out.println(lib2);
}
}
