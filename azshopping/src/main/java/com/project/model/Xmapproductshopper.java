package com.project.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Xmapproductshopper implements Serializable {

	@Id
	private String xpsid;
	private String productid, shopperid;
	private int xpsprice, xpsstock;
	private boolean xpsavailable;

	public Xmapproductshopper() {
		this("NULL", "NULL", "NULL", 0, 0, false);
	}

	public Xmapproductshopper(String id, String pid, String sid, int xpri, int xpstc, boolean xpavail) {
		xpsid = id;
		productid = pid;
		shopperid = sid;
		xpsprice = xpri;
		xpsstock = xpstc;
		xpsavailable = xpavail;

	}

	public String getXpsid() {
		return xpsid;
	}

	public void setXpsid(String xpsid) {
		this.xpsid = xpsid;
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

	public int getXpsprice() {
		return xpsprice;
	}

	public void setXpsprice(int xpsprice) {
		this.xpsprice = xpsprice;
	}

	public int getXpsstock() {
		return xpsstock;
	}

	public void setXpsstock(int xpsstock) {
		this.xpsstock = xpsstock;
	}

	public boolean isXpsavailable() {
		return xpsavailable;
	}

	public void setXpsavailable(boolean xpsavailable) {
		this.xpsavailable = xpsavailable;
	}

}
