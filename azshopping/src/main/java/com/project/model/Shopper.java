package com.project.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Shopper implements Serializable {
	
	@Id
	private String shopperid;
	private String shoppername;
	private String shopperdesc;
	private boolean shopperavailable;
	
	@Transient
	private MultipartFile imagefile;
	
	public Shopper() {
		this("S002","DUDE","STUDENT",true);
	}
	public Shopper(String id,String name,String desc,boolean available) {
	shopperid=id;
	shoppername=name;
	shopperdesc=desc;
	shopperavailable=available;
	}
	public String getShopperid() {
		return shopperid;
	}
	public void setShopperid(String shopperid) {
		this.shopperid = shopperid;
	}
	public String getShoppername() {
		return shoppername;
	}
	public void setShoppername(String shoppername) {
		this.shoppername = shoppername;
	}
	public String getShopperdesc() {
		return shopperdesc;
	}
	public void setShopperdesc(String shopperdesc) {
		this.shopperdesc = shopperdesc;
	}
	public boolean isShopperavailable() {
		return shopperavailable;
	}
	public void setShopperavailable(boolean shopperavailable) {
		this.shopperavailable = shopperavailable;
	}
	public MultipartFile getImagefile() {
		return imagefile;
	}
	public void setImagefile(MultipartFile imagefile) {
		this.imagefile = imagefile;
	}
	
	
}
