package org.springpractice.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingAppl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Triangle triangle=new Triangle();
		
		
		/*BeanFactory factory=new XmlBeanFactory(new FileSystemResource("spring.xml"));
		Triangle triangle=(Triangle) factory.getBean("triangle");
		triangle.draw();*/
		
		//ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		//Triangle triangle=(Triangle) context.getBean("triangle");
		//Triangle triangle=(Triangle) context.getBean("triangle-alias");
		//Triangle triangle=(Triangle) context.getBean("triangle-name");
		//Triangle triangle=(Triangle) context.getBean("triangle2");
		//Triangle triangle=(Triangle) context.getBean("triangle");
		//Triangle triangle=(Triangle) context.getBean("parenttriangle");
		Shape shape=(Shape) context.getBean("circle");
		//triangle.draw();
		shape.draw();
		/*System.out.println(context.getMessage("greeting", null, "Default Greeting", null));*/
		
	}

}
