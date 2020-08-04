package com.project.cartDAO;

import java.util.List;

import com.project.model.Cart;
import com.project.model.Vw_Cust_Cart_Full_Details;

public interface CartDaoINT {

	public boolean addCart(Cart c);
	public boolean updatecart(Cart c);
	public Cart getCartById(String cid);
	public List<Vw_Cust_Cart_Full_Details> getCartItemsForCart(String cartid);

}
