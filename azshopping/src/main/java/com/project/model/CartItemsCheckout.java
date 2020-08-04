package com.project.model;

import java.io.Serializable;
import java.util.List;

public class CartItemsCheckout implements Serializable {

	
	private List<Vw_Cust_Cart_Full_Details> vwCartItems;

	public List<Vw_Cust_Cart_Full_Details> getVwCartItems() {
		return vwCartItems;
	}

	public void setVwCartItems(List<Vw_Cust_Cart_Full_Details> vwCartItems) {
		this.vwCartItems = vwCartItems;
	}	
}	

