package com.spring.core;

import java.util.Arrays;
import java.util.Locale;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.spring.model.Point;

public class CoreMain {

	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		Point point = (Point) context.getBean("myFoo");
		System.err.println("Point name = " + point.getName());

		String[] beanNames = context.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println("--> " + beanName);
		}

		context.registerShutdownHook();

	}

}
