package gfy.configuration;


import java.util.Properties;
import java.util.function.Supplier;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import gfy.dao.Categorydaoimpl;
import gfy.model.Cart;
import gfy.model.Category;
import gfy.model.Product;
import gfy.model.Userdetail;

public class dbcofig 
	{

		
		@Bean(name="dataSource")  //is used to represent any class or method as logical unit of reusable code in an application
		public DataSource getH2DataSource()
		{
			DriverManagerDataSource dataSource=new DriverManagerDataSource();
			
			dataSource.setDriverClassName("org.h2.Driver");
			dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
			dataSource.setUsername("sa");
			dataSource.setPassword("sa");
			
			System.out.println("DataSource object Created");
			return dataSource;
		}
		
		

		@Bean(name="sessionFactory")
		public SessionFactory getSessionFactory()
		{
			Properties properties=new Properties();
			properties.put("hibernate.hbm2ddl.auto", "update");
			properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
			
			
			DataSource dataSource=this.getH2DataSource();
			LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(dataSource);
			factory.addProperties(properties);
			
			factory.addAnnotatedClass(Category.class);
			factory.addAnnotatedClass(Product.class);
			factory.addAnnotatedClass(Supplier.class);
			factory.addAnnotatedClass(Userdetail.class);
			factory.addAnnotatedClass(Cart.class);
			
			System.out.println("Session Factory Object created");
			SessionFactory sessionFactory=factory.buildSessionFactory();
			return sessionFactory;
		}
		
		
		
		@Bean(name="txManager")
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
		{
			System.out.println("Transaction Manager Object Created");
			return new HibernateTransactionManager(sessionFactory);
		}
		
		@Bean(name="categoryDAO")
		public Categorydaoimpl getCategoryDAO()
		{
			return new Categorydaoimpl();
		}
	}

