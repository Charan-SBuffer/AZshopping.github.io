package com.project.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vw_Cust_Cart_Full_Details implements Serializable {

	@Id
	private String xpsid;
	private String customerid, cartid, cartitemid, productid, productname, shoppername,shopperid;
	private int quantity, xpsprice;
	private boolean enabled;

	public String getXpsid() {
		return xpsid;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setXpsid(String xpsid) {
		this.xpsid = xpsid;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getCartid() {
		return cartid;
	}

	public void setCartid(String cartid) {
		this.cartid = cartid;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getShoppername() {
		return shoppername;
	}

	public void setShoppername(String shoppername) {
		this.shoppername = shoppername;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getXpsprice() {
		return xpsprice;
	}

	public void setXpsprice(int xpsprice) {
		this.xpsprice = xpsprice;
	}

	public String getCartitemid() {
		return cartitemid;
	}

	public void setCartitemid(String cartitemid) {
		this.cartitemid = cartitemid;
	}

	public String getShopperid() {
		return shopperid;
	}

	public void setShopperid(String shopperid) {
		this.shopperid = shopperid;
	}
	
	

}
