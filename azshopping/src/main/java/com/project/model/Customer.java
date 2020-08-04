package com.project.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.Valid;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Customer implements Serializable {

	@Id
	private String customerid;
	@Length(min=5,message="NAME MUST BE MINIMUM OF 5 LETTERS")
	private String customername;
	
	private String customeremailid;
	@Length(min=7,max=10,message="NO SHOULD BE MIN 7 & MAX OF 10")
	private String customermobileno;
	
	@Transient
	private MultipartFile imagefile;

	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid")
	private UserDetails userDetails;

	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "billingaddressid")
	private BillingAddress billingAddress;

	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shippingaddressid")
	private ShippingAddress shippingAddress;

	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cartid")
	private Cart cart;

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCustomeremailid() {
		return customeremailid;
	}

	public void setCustomeremailid(String customeremailid) {
		this.customeremailid = customeremailid;
	}

	public String getCustomermobileno() {
		return customermobileno;
	}

	public void setCustomermobileno(String customermobileno) {
		this.customermobileno = customermobileno;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public MultipartFile getImagefile() {
		return imagefile;
	}

	public void setImagefile(MultipartFile imagefile) {
		this.imagefile = imagefile;
	}

}
