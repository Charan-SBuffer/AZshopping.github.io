package com.project.ShippingAddressDao;

import java.util.List;

import com.project.model.ShippingAddress;

public interface ShippingAddINT {

	public List<ShippingAddress> getlistshippingaddDetails();
	public boolean addShippingDetails(ShippingAddress sa);
	public boolean updateshippingadd(ShippingAddress sa);
}
