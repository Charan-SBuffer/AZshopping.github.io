package com.project.productdao;

import java.util.List;

import org.hibernate.Session;

import com.project.model.Product;

public interface ProductdaoiINT {
	public List<Product> getlistofproduct();
	public boolean addproduct(Product p);
	public boolean deleteproduct(String sid);
	 public Product getproductbyID(String pid);
		public boolean updateProductdetails(Product s);
		public boolean changeavailability(Product p);
		public List<Product> searchforproduct(String pname);
public List<Product> getlistofPRosuctsbyOrderID(String orderid);
}
