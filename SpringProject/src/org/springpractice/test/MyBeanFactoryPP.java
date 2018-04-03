package org.springpractice.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPP implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanfactory) throws BeansException {
		// TODO Auto-generated method stub
		
		System.out.println("My bean factory post processor is called");
		
	}

}
