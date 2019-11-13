package com.niit.ecom.backend.config;

import java.util.Properties;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.ecom.backend.dao.ProductDAO;
import com.niit.ecom.backend.dao.ProductDAOImpl;
import com.niit.ecom.backend.model.Product;

@Configuration
@EnableTransactionManagement
public class SpringConfig {
	@Bean(name = "dataSource")
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName("oracle.jdbc.OracleDriver");
		System.out.println("Driver Found");
		source.setUrl("jdbc:oracle:thin:@localhost:11521:XE");
		source.setUsername("cddt");
		source.setPassword("cddt");
		System.out.println("Database Connected");
		return source;
	}
	
	@Bean(name = "hibernateProperties")
	public Properties getHibernateProperties() {
		Properties property = new Properties();
		property.setProperty("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		property.setProperty("hibernate.hbm2ddl.atuo", "update");
		property.setProperty("hibernate.show_sql","true");
		return property;
	}
	
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory() {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(getDataSource());
		builder.setProperties(getHibernateProperties());
		builder.addAnnotatedClass(Product.class);
		SessionFactory sessionFactory = builder.buildSessionFactory();
		System.out.println("Session Factory Created  ");
		return sessionFactory;
	}
	
	
	@Bean(name = "productDAO")
	public ProductDAO getProductDAO() {
		return new ProductDAOImpl();
	}
	
	
	
}
