package com.project.shopperdao;

import java.util.List;

import com.project.model.Shopper;

public interface ShopperINt {

	public List<Shopper> getlistofshopper();
	public boolean addshopper(Shopper s);
	public boolean deletshopper(String sid);
	public boolean updateshopperdetails(Shopper s);
	public Shopper getshopperbyID(String sid);
	public boolean changeavailability(Shopper s);

}
