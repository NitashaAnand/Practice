package org.jdbcpractice.main;

import org.jdbcpractice.dao.HibernateDaoImpl;
import org.jdbcpractice.dao.JdbcDaoImpl;
import org.jdbcpractice.dao.NamedParameterJdbcDaoImpl;
import org.jdbcpractice.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDemo {
	
	public static void main(String args[])
	{
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		/*JdbcDaoImpl dao=ctx.getBean("jdbcDaoImpl",JdbcDaoImpl.class);*/
		
		/*Circle circle=new JdbcDaoImpl().getCircle(1);
		System.out.println(circle.getName());*/
		
		/*Circle circle=dao.getCircle(1);
		System.out.println(circle.getName());
		System.out.println(dao.getCircleCount());
		System.out.println(dao.getCircleName(1));*/
		/*System.out.println(dao.getCircleForId(1).getName());
		System.out.println(dao.getAllCircles().size());
		dao.insertCircle(new Circle(2,"Second Circle"));
		System.out.println(dao.getAllCircles().size());
		dao.insertCircle(new Circle(3,"Third Circle"));*/
		//dao.createTriangleTable();
		/*dao.insertCircle_NamedParameter(new Circle(4,"Fourth Circle"));
		System.out.println(dao.getAllCircles().size());*/
		
		/*NamedParameterJdbcDaoImpl dao=ctx.getBean("namedParameterJdbcDaoImpl",NamedParameterJdbcDaoImpl.class);
		System.out.println(dao.getCircleCount());*/
		
		HibernateDaoImpl dao=ctx.getBean("hibernateDaoImpl",HibernateDaoImpl.class);
		System.out.println(dao.getCircleCount());
		
		
	}

}
