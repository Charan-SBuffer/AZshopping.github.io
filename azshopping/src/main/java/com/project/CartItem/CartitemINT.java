package com.project.CartItem;

import java.util.List;

import com.project.model.CartItems;

public interface CartitemINT {

	public List<CartItems> getCartITEMS();

	public boolean addtoCART(CartItems c);

	public boolean deletcartitem(String c);
	public boolean updatecart(CartItems c);
	public boolean increaseqnt(String citemid);
	public boolean decreaseqnt(String citemid);


}
