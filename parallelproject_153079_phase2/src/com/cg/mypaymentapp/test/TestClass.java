package com.cg.mypaymentapp.test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.exception.InsufficientBalanceException;
import com.cg.mypaymentapp.exception.InvalidInputException;
import com.cg.mypaymentapp.service.WalletService;
import com.cg.mypaymentapp.service.WalletServiceImpl;

public class TestClass {

	static WalletService service;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception 
	{
		Map<String,Customer> data= new HashMap<String, Customer>();
		 Customer cust1=new Customer("Amit", "9900112212",new Wallet(new BigDecimal(9000)));
		 Customer cust2=new Customer("Ajay", "9963242422",new Wallet(new BigDecimal(6000)));
		 Customer cust3=new Customer("Yogini", "9922950519",new Wallet(new BigDecimal(7000)));
				
		 data.put("9900112212", cust1);
		 data.put("9963242422", cust2);	
		 data.put("9922950519", cust3);	
			service= new WalletServiceImpl(data);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected=InvalidInputException.class)
	public void testCreateAccount() 
	{
		service.createAccount(null, "9942221102", new BigDecimal(1500));
	}
		
	
	@Test(expected=InvalidInputException.class)
	public void testCreateAccount2() 
	{
		service.createAccount("john", "999", new BigDecimal(1500));
	}
	
	
	@Test(expected=InvalidInputException.class)
	public void testCreateAccount3() 
	{
		service.createAccount("john", "", new BigDecimal(1500));
	}
	
	
	
	@Test
	public void testCreateAccount5() 
	{
		Customer actual=service.createAccount("Kanimozhi", "9698495659", new BigDecimal(5000));
		Customer expected=new Customer("Kanimozhi", "9698495659", new Wallet(new BigDecimal(5000)));
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void testCreateAccount6() 
	{
		Customer actual=service.createAccount("Aarthi", "8754922472", new BigDecimal(0));
		Customer expected=new Customer("Aarthi", "8754922472", new Wallet(new BigDecimal(0)));
		
		assertEquals(expected, actual);
	}
	
		
	@Test(expected=InvalidInputException.class)
	public void testShowBalance7() 
	{
		service.showBalance("");		
	}
	
	
	@Test(expected=InvalidInputException.class)
	public void testShowBalance4() 
	{
		service.showBalance("12345");		
	}
	
	
	@Test(expected=InvalidInputException.class)
	public void testShowBalance5() 
	{
		service.showBalance("9900112218");		
	}
	
	
	@Test(expected=InvalidInputException.class)
	public void testShowBalance6() 
	{
		service.showBalance("99001122122");		
	}
	
	@Test(expected=InvalidInputException.class)
	public void testFundTransfer8() 
	{
		service.fundTransfer("9922950519", "9922950519", new BigDecimal(5000));		
	}

	
	@Test(expected=InvalidInputException.class)
	public void testFundTransfer10() 
	{
		service.fundTransfer("9900112212", "", new BigDecimal(0));		
	}
	
	
	@Test(expected=InvalidInputException.class)
	public void testFundTransfer11() 
	{
		service.fundTransfer("", "9922950519", new BigDecimal(500));		
	}
	
	
	@Test(expected=InvalidInputException.class)
	public void testFundTransfer14() 
	{
		service.fundTransfer("", "9922950519", new BigDecimal(-100));		
	}
	
	
	@Test(expected=InvalidInputException.class)
	public void testFundTransfer15() 
	{
		service.fundTransfer("", "", new BigDecimal(500));		
	}
		
	
	@Test(expected=InvalidInputException.class)
	public void testFundTransfer16() 
	{
		service.fundTransfer("9922950519", "9963242422", new BigDecimal(0));		
	}

	
	@Test(expected=InvalidInputException.class)
	public void testDepositAmount17() 
	{
		service.depositAmount(null, new BigDecimal(500));
	}
	
	
	@Test(expected=InvalidInputException.class)
	public void testDepositAmount18() 
	{
		service.depositAmount("", new BigDecimal(500));
	}
		
	
	@Test(expected=InvalidInputException.class)
	public void testDepositAmount19() 
	{
		service.depositAmount("9942221102", new BigDecimal(0));
	}
	
	@Test(expected=InvalidInputException.class)
	public void testWithdrawAmount21() 
	{
		service.withdrawAmount("9900112212", new BigDecimal(0));
	}
	
}
