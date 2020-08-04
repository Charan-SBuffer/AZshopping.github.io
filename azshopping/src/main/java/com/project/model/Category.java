package com.project.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Category implements Serializable {

	
	@Id
	private String categoryid;
	private String categoryname;
	private boolean categoryavailable;
	
		public  Category() {
		this("C002","MENACCESSORIES",true);
	}
	public Category(String id,String name,boolean av) {
		categoryid=id;
		categoryname=name;
		categoryavailable=av;
	}
	public String getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public boolean isCategoryavailable() {
		return categoryavailable;
	}
	public void setCategoryavailable(boolean categoryavailable) {
		this.categoryavailable = categoryavailable;
	}

	
	
	
}
