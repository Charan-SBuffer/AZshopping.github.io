package com.project.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CartItems implements Serializable {

	@Id
	private String cartitemid;
	private int quantity;
	private double itemwisetotal;
	private String xpsid;
	private boolean enabled;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@ManyToOne
	@JoinColumn(name = "cartid")
	private Cart cart;

	public String getCartitemid() {
		return cartitemid;
	}

	public void setCartitemid(String cartitemid) {
		this.cartitemid = cartitemid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getItemwisetotal() {
		return itemwisetotal;
	}

	public void setItemwisetotal(double itemwisetotal) {
		this.itemwisetotal = itemwisetotal;
	}

	public String getXpsid() {
		return xpsid;
	}

	public void setXpsid(String xpsid) {
		this.xpsid = xpsid;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

}
