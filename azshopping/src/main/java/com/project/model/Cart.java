package com.project.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart implements Serializable {

	@Id
	private String cartid;
	private double grandtotoal;

	@OneToOne(mappedBy = "cart")
	private Customer customer;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	List<CartItems> cartitems;

	public String getCartid() {
		return cartid;
	}

	public void setCartid(String cartid) {
		this.cartid = cartid;
	}

	public double getGrandtotoal() {
		return grandtotoal;
	}

	public void setGrandtotoal(double grandtotoal) {
		this.grandtotoal = grandtotoal;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<CartItems> getCartitems() {
		return cartitems;
	}

	public void setCartitems(List<CartItems> cartitems) {
		this.cartitems = cartitems;
	}

}
