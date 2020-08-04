package com.project.orderDAO;

import java.util.List;

import com.project.model.Cart;
import com.project.model.OrderDetails;
import com.project.model.Orders;

public interface OrderINT {
public void confirmCustomerOrder(Cart c);
public abstract List<Orders> getCustomerOrders(String custid);
public abstract List<OrderDetails> getOrderDetails(String orderid);
public abstract Orders getOrderByOrderid(String orderid);

public abstract OrderDetails getOrderDetailsById(String ordetid);
public abstract void addProductReview(String ordetid,String reviewtitle,String reviewbody);
}
