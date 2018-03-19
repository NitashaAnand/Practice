package org.springpractice.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingAppl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Triangle triangle=new Triangle();
		
		
		/*BeanFactory factory=new XmlBeanFactory(new FileSystemResource("spring.xml"));
		Triangle triangle=(Triangle) factory.getBean("triangle");
		triangle.draw();*/
		
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		//Triangle triangle=(Triangle) context.getBean("triangle");
		//Triangle triangle=(Triangle) context.getBean("triangle-alias");
		Triangle triangle=(Triangle) context.getBean("triangle-name");
		triangle.draw();
		
	}

}
