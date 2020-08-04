package com.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderDetails {
	@Id
	private String orderDetid;

	private String productid;
	private String productname;
	private String supplierid;
	private String suppliername;
	private int quantity;
	private double productprice;
	private boolean isratinggiven;
	private boolean isreviewgiven;
	private int rating;
	private String reviewtitle;
	private String reviewbody;
	@ManyToOne
	@JoinColumn(name="orderid")
	private Orders orders;
	public String getOrderDetid() {
		return orderDetid;
	}

	public void setOrderDetid(String orderDetid) {
		this.orderDetid = orderDetid;
	}



	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
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

	public String getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}

	public String getSuppliername() {
		return suppliername;
	}

	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getProductprice() {
		return productprice;
	}

	public void setProductprice(double productprice) {
		this.productprice = productprice;
	}

	public boolean isIsratinggiven() {
		return isratinggiven;
	}

	public void setIsratinggiven(boolean isratinggiven) {
		this.isratinggiven = isratinggiven;
	}

	public boolean isIsreviewgiven() {
		return isreviewgiven;
	}

	public void setIsreviewgiven(boolean isreviewgiven) {
		this.isreviewgiven = isreviewgiven;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReviewtitle() {
		return reviewtitle;
	}

	public void setReviewtitle(String reviewtitle) {
		this.reviewtitle = reviewtitle;
	}

	public String getReviewbody() {
		return reviewbody;
	}

	public void setReviewbody(String reviewbody) {
		this.reviewbody = reviewbody;
	}

}
/*
 * orderDetid char(12) primary key, orderid char(10) references Orders(orderid),
 * productid char(10), productname varchar(100), supplierid char(10),
 * suppliername varchar(100), quantity int, productprice double, isratinggiven
 * boolean, rating int, isreviewgiven boolean, review varchar(100)
 */
