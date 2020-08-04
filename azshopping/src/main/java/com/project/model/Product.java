package com.project.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product implements Serializable {

	@Id
	private String productid;
	private String productname;
	private String productdesc;
	private String categoryid;
	private boolean productavailable;
	private int no_of_itemssold;
	private float productrating;
	
	private int no_of_ratings;
	private int no_of_reviews;
	
	public int getNo_of_itemssold() {
		return no_of_itemssold;
	}
	public void setNo_of_itemssold(int no_of_itemssold) {
		this.no_of_itemssold = no_of_itemssold;
	}
	public float getProductrating() {
		return productrating;
	}
	public void setProductrating(float productrating) {
		this.productrating = productrating;
	}
	public int getNo_of_ratings() {
		return no_of_ratings;
	}
	public void setNo_of_ratings(int no_of_ratings) {
		this.no_of_ratings = no_of_ratings;
	}
	public int getNo_of_reviews() {
		return no_of_reviews;
	}
	public void setNo_of_reviews(int no_of_reviews) {
		this.no_of_reviews = no_of_reviews;
	}
	@Transient
	private MultipartFile imagefile;
	
	public Product() {
		this("NULL","NOTMENTIONED","NOTMENTIONED","NOTMATCHING",false);
	}
	public Product(String pid,String pn,String pd,String ci,boolean pa) {
		productid=pid;
		productname=pn;
		productdesc=pd;
		categoryid=ci;
		productavailable=pa;
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
	public String getProductdesc() {
		return productdesc;
	}
	public void setProductdesc(String productdesc) {
		this.productdesc = productdesc;
	}
	public String getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}
	public boolean isProductavailable() {
		return productavailable;
	}
	public void setProductavailable(boolean productavailable) {
		this.productavailable = productavailable;
	}
	public MultipartFile getImagefile() {
		return imagefile;
	}
	public void setImagefile(MultipartFile imagefile) {
		this.imagefile = imagefile;
	}

	
	
}
