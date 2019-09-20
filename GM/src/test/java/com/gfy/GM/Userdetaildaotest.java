package com.gfy.GM;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import gfy.dao.Userdetaildao;
import gfy.model.Userdetail;

public class Userdetaildaotest {

	static Userdetaildao userdetailDAO;
	
	@BeforeClass
	public static void testing() 
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.webpage");
		context.refresh();
		
		userdetailDAO=(Userdetaildao)context.getBean("userdetailDAO");
	}
	
	@Test
	public void addUserdetail()
	{
		Userdetail userdetail=new Userdetail();
		userdetail.setUsername("Ramesh");
		userdetail.setAddress("T-nagar");
		
		assertTrue("Problem in Adding Userdetail",userdetailDAO.addUserdetail(userdetail));

	}
	
	@Test
	public void addUserdetail1()
	{
		Userdetail userdetail=new Userdetail();
		userdetail.setUsername("Suresh");
		userdetail.setAddress("Annanagar");
		
		assertTrue("Problem in Adding Userdetail",userdetailDAO.addUserdetail(userdetail));
	
}
	@Ignore
	@Test
	public void addUserDetail2()
	{
		Userdetail userdetail=new Userdetail();
		userdetail.setUsername("Kumar");
		userdetail.setAddress("Palavaram");
		
		assertTrue("Problem in Adding Userdetail",userdetailDAO.addUserdetail(userdetail));
	}
	@Ignore
	@Test
	public void updateUserDetail()
	{
		Userdetail userdetail=userdetailDAO.getUserdetail("2");
		userdetail.setUsername("Hari");
		
		assertTrue("Problem in Updating Userdetail",userdetailDAO.updateUserdetail(userdetail));
	}
	
	}



