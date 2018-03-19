package org.springpractice.test;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements ApplicationContextAware,BeanNameAware {
	
	/*private String type;
	
	private int height;*/
	
	private Point pointA;
	
	//private ApplicationContext context=null;
	/*private Point pointB;
	private Point pointC;
	*/
	/*private List<Point> points;*/
	
	
	
	/*public ApplicationContext getContext() {
		return context;
	}*/


	public Point getPointA() {
		return pointA;
	}

	public Triangle(Point pointA) {
		super();
		this.pointA = pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	/*public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}*/

	/**
	 * @return the height
	 */
	/*public int getHeight() {
		return height;
	}

	public Triangle(String type){
		this.type=type;
	}
	
	public Triangle(int height){
		this.height=height;
	}
	
	
	public Triangle(String type,int height){
		this.type=type;
		this.height=height;
	}
	
	
	*//**
	 * @return the type
	 *//*
	public String getType() {
		return type;
	}*/


	/*public List<Point> getPoints() {
		return points;
	}



	public void setPoints(List<Point> points) {
		this.points = points;
	}*/



	/**
	 * @param type the type to set
	 */
	/*public void setType(String type) {
		this.type = type;
	}
*/

	public void draw() {
		
		//System.out.println(getType() + " Triangle drawn of height " + getHeight());
		System.out.println("Point A =(" + getPointA().getX() + "," + getPointA().getY() + ")");
	/*	System.out.println("Point B =(" + getPointB().getX() + "," + getPointB().getY() + ")");
		System.out.println("Point C =(" + getPointC().getX() + "," + getPointC().getY() + ")");*/
		
		/*for(Point point:points)
		{
			System.out.println("Point =(" + point.getX() + "," + point.getY() + ")");
		}*/
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("Context is:" +context);
		
	}


	@Override
	public void setBeanName(String beanName) {
		// TODO Auto-generated method stub
		System.out.println("Bean name is:" +beanName);
		
	}

}
