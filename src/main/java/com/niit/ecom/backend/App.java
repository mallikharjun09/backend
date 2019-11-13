package com.niit.ecom.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.niit.ecom.backend.dao.ProductDAO;
import com.niit.ecom.backend.model.Product;

public class App 
{
	
	static ProductDAO productDAO;
    public static void main( String[] args )
    {
        //ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    	context.scan("com.niit.ecom.backend.config");
    	context.refresh();
        
    }
}
