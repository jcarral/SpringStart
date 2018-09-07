package com.demo.first.firstdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
public static void main(String[] args) {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("com/demo/xml/beans.xml");
	Library lib = (Library) ctx.getBean("library");
	
	System.out.println(lib);
}
}
