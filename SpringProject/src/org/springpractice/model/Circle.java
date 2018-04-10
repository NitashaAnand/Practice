package org.springpractice.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/*@Component*/
/*@Service*/
/*@Repository*/
@Controller
public class Circle implements Shape,ApplicationEventPublisherAware {
	
	private Point center;
	
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private MessageSource messageSource;
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Circle's setter called");
		throw(new RuntimeException());
		
	}
	
	public String setNameAndReturn(String name) {
		this.name = name;
		System.out.println("Circle's setter called");
		return name;
		
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}


	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}


	public Point getCenter() {
		return center;
	}


	/*@Required
	public void setCenter(Point center) {
		this.center = center;
	}*/
	
	/*@Autowired
	@Qualifier("circleRelated")*/
	/*@Resource(name="pointC")*/
	@Resource
	public void setCenter(Point center) {
		this.center = center;
	}
	



	@Override
	public void draw() {
		// TODO Auto-generated method stub
		/*System.out.println("Drawing Circle::");*/
		System.out.println(this.messageSource.getMessage("drawing.circle", null, "Default Drawing Message", null));
		/*System.out.println("Circle: Point is:" + "(" +center.getX() + "," + center.getY() + ")");*/
		System.out.println(this.messageSource.getMessage("drawing.point", new Object[] {center.getX(),center.getY()}, "Default Point Message", null));
		/*System.out.println(this.messageSource.getMessage("greeting", null, "Default Greeting", null));*/
		DrawEvent draweEvent=new DrawEvent(this);
		publisher.publishEvent(draweEvent);
		
	}
	
	@PostConstruct
	public void intializeCircle(){
		System.out.println("Init of Circle");
	}
	
	@PreDestroy
	public void destroyCircle(){
		System.out.println("Destroy of Circle");
	}


	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		// TODO Auto-generated method stub
		this.publisher=publisher;
		
	}

}
