package org.springpractice.service;

import org.springpractice.aspect.LoggingAspect;
import org.springpractice.model.Circle;

public class ShapeServiceProxy extends ShapeService {
	
	public Circle getCircle() {
		new LoggingAspect().loggingAdvice();
		return super.getCircle();
	}

}
