package com.project.customerDao;

import java.util.List;

import com.project.model.Customer;

public interface CustomerDAOINT {

	public List<Customer> getlistofcustomer();
	public boolean addcustomer(Customer c);
	public Customer getcustomerbyuserID(String uid);

	public boolean logincheck(String uid, String upd);
	public void update(Customer currentcustomer);
	public Customer getbyCustomerID(String Customer );
	public Customer getNewCustomer();
	public boolean addCustomer1(Customer c);
	
}