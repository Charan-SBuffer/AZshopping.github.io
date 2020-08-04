package com.project.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VW_PRODUCTDATA_USER implements Serializable {

	@Id
	private String xpsid;
	private String categoryname, xpsprice, xpsstock, productdesc, productname, shoppername;
	private String categoryid, productid, shopperid;
	private boolean categoryavailable, productavailable, xpsavailable, shopperavailable;
	private int no_of_itemssold,rate5,rate4,rate3,rate2,rate1;
	private float productrating;
	private int no_of_rating;
	private int no_of_reviews;
	
	
	
	

	public int getNo_of_itemssold() {
		return no_of_itemssold;
	}

	public void setNo_of_itemssold(int no_of_itemssold) {
		this.no_of_itemssold = no_of_itemssold;
	}

	public int getRate5() {
		return rate5;
	}

	public void setRate5(int rate5) {
		this.rate5 = rate5;
	}

	public int getRate4() {
		return rate4;
	}

	public void setRate4(int rate4) {
		this.rate4 = rate4;
	}

	public int getRate3() {
		return rate3;
	}

	public void setRate3(int rate3) {
		this.rate3 = rate3;
	}

	public int getRate2() {
		return rate2;
	}

	public void setRate2(int rate2) {
		this.rate2 = rate2;
	}

	public int getRate1() {
		return rate1;
	}

	public void setRate1(int rate1) {
		this.rate1 = rate1;
	}

	public float getProductrating() {
		return productrating;
	}

	public void setProductrating(float productrating) {
		this.productrating = productrating;
	}

	public int getNo_of_rating() {
		return no_of_rating;
	}

	public void setNo_of_rating(int no_of_rating) {
		this.no_of_rating = no_of_rating;
	}

	public int getNo_of_reviews() {
		return no_of_reviews;
	}

	public void setNo_of_reviews(int no_of_reviews) {
		this.no_of_reviews = no_of_reviews;
	}

	public String getXpsid() {
		return xpsid;
	}

	public void setXpsid(String xpsid) {
		this.xpsid = xpsid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getXpsprice() {
		return xpsprice;
	}

	public void setXpsprice(String xpsprice) {
		this.xpsprice = xpsprice;
	}

	public String getXpsstock() {
		return xpsstock;
	}

	public void setXpsstock(String xpsstock) {
		this.xpsstock = xpsstock;
	}

	public String getProductdesc() {
		return productdesc;
	}

	public void setProductdesc(String productdesc) {
		this.productdesc = productdesc;
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

	public String getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getShopperid() {
		return shopperid;
	}

	public void setShopperid(String shopperid) {
		this.shopperid = shopperid;
	}

	public boolean isCategoryavailable() {
		return categoryavailable;
	}

	public void setCategoryavailable(boolean categoryavailable) {
		this.categoryavailable = categoryavailable;
	}

	public boolean isProductavailable() {
		return productavailable;
	}

	public void setProductavailable(boolean productavailable) {
		this.productavailable = productavailable;
	}

	public boolean isXpsavailable() {
		return xpsavailable;
	}

	public void setXpsavailable(boolean xpsavailable) {
		this.xpsavailable = xpsavailable;
	}

	public boolean isShopperavailable() {
		return shopperavailable;
	}

	public void setShopperavailable(boolean shopperavailable) {
		this.shopperavailable = shopperavailable;
	}

}
