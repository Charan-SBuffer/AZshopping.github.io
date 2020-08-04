package com.project.orderDAO;

import java.sql.Date;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.mail.MessagingException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.controller.Emailservice;
import com.project.model.Cart;
import com.project.model.CartItems;
import com.project.model.OrderDetails;
import com.project.model.Orders;
import com.project.model.Product;
import com.project.model.ShippingAddress;
import com.project.model.Vw_Cust_Cart_Full_Details;
import com.project.model.Xmapproductshopper;
import com.project.productdao.ProductdaoiINT;

@Repository
public class OrderDaoImpl implements OrderINT {
	@Autowired
	SessionFactory sf;
	@Autowired
	private Emailservice emailservice;
	@Autowired
	private ProductdaoiINT pdao;

	public void confirmCustomerOrder(Cart cart) {
int i=0;
		Orders ord = new Orders();
		String orderid = generateOrderId();
		ord.setOrderid(orderid);
		ord.setCustomerid(cart.getCustomer().getCustomerid());
		ord.setNoitems(cart.getCartitems().size());
		ord.setOrdertotal(cart.getGrandtotoal());

		Calendar calendar = Calendar.getInstance();
		java.util.Date currentDate = calendar.getTime();
		Date date = new Date(currentDate.getTime());
		System.out.println(date);

		ord.setOrderdate(date);
		ShippingAddress sad = cart.getCustomer().getShippingAddress();

		String shipAddress = sad.getHouseno() + ", " + sad.getStreet() + ", " + sad.getArea() + ", " + sad.getCity()
				+ ", " + sad.getState() + ", " + sad.getCountry() + "," + sad.getPincode();

		ord.setShipmentAddress(shipAddress);

		Session ses = sf.openSession();
		ses.beginTransaction();
		ses.update(cart.getCustomer());
		ses.save(ord);
		ses.getTransaction().commit();
		ses.close();

		ses = sf.openSession();
		String qry = "from Vw_Cust_Cart_Full_Details where cartid='" + cart.getCartid() + "'";
		Query q = ses.createQuery(qry);
		List<Vw_Cust_Cart_Full_Details> items = q.list();
		for (Vw_Cust_Cart_Full_Details item : items) {
			OrderDetails orddet = new OrderDetails();
			orddet.setOrders(ord);
			orddet.setOrderDetid(generateOrderDetId());
			orddet.setProductid(item.getProductid());
			orddet.setProductname(item.getProductname());
			orddet.setSupplierid(item.getShopperid());
			orddet.setSuppliername(item.getShoppername());
			orddet.setQuantity(item.getQuantity());
			orddet.setProductprice(item.getXpsprice());
			orddet.setIsratinggiven(false);
			orddet.setRating(0);
			orddet.setIsreviewgiven(false);
			orddet.setReviewtitle(null);
			orddet.setReviewbody(null);

			Xmapproductshopper xmap = ses.get(Xmapproductshopper.class, item.getXpsid());
			xmap.setXpsstock(xmap.getXpsstock() - item.getQuantity());

			Product product = ses.get(Product.class, xmap.getProductid());

			product.setNo_of_itemssold(product.getNo_of_itemssold() + item.getQuantity());

			ses.beginTransaction();
			ses.save(orddet);
			ses.update(xmap);
			ses.update(product);
			ses.getTransaction().commit();
		}

		List<CartItems> citems = cart.getCartitems();
		for (CartItems ci : citems) {
			ses.beginTransaction();
			ses.delete(ci);
			ses.getTransaction().commit();
		}

		ses.close();
		ses = sf.openSession();
		cart.setGrandtotoal(0);
		ses.beginTransaction();
		ses.update(cart);
		ses.getTransaction().commit();
	List<Product> lp=	pdao.getlistofPRosuctsbyOrderID(orderid);
	Iterator ir=(Iterator)lp.get(i);
while(ir.hasNext()) {
Product p=(Product) ir.next();
}
		String subject = "Order Confirmed :: AZshopping.com";
		String body = "Dear " + cart.getCustomer().getCustomername() + ",\nWelcome to AZshopping.com";
		body = body + "\n This is ur order ID  " + orderid;
		
		body = body + " \nThanks for shopping with us";
		body = body + "\n\n\nRegards,\nTestSite Team\nDT - NIIT-Basheerbagh";
		try {
			emailservice.send(cart.getCustomer().getCustomeremailid(), subject, body);
		} catch (MessagingException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Orders> getCustomerOrders(String custid) {
		Session ses = sf.openSession();
		String q = "from Orders where customerid='" + custid + "'";
		Query qry = (Query) ses.createQuery(q);
		List<Orders> data = qry.list();
		ses.close();
		return data;
	}

	@Override
	public Orders getOrderByOrderid(String orderid) {
		Session ses = sf.openSession();
		Orders ord = ses.get(Orders.class, orderid);
		ses.close();
		return ord;
	}

	@Override
	public List<OrderDetails> getOrderDetails(String orderid) {
		List<OrderDetails> data = null;
		Session ses = sf.openSession();
		String q = "from OrderDetails where orderid='" + orderid + "'";
		Query qry = ses.createQuery(q);
		data = qry.list();

		ses.close();
		System.out.println(data);
		return data;
	}

	@Override
	public OrderDetails getOrderDetailsById(String ordetid) {
		OrderDetails data = null;
		Session ses = sf.openSession();
		data = ses.get(OrderDetails.class, ordetid);
		ses.close();
		return data;
	}

	@Override
	public void addProductReview(String ordetid, String reviewtitle, String reviewbody) {
		Session ses = sf.openSession();
		OrderDetails ordetdata = ses.get(OrderDetails.class, ordetid);
		ordetdata.setIsreviewgiven(true);
		ordetdata.setReviewtitle(reviewtitle);
		ordetdata.setReviewbody(reviewbody);
		ses.beginTransaction();
		ses.update(ordetdata);
		ses.getTransaction().commit();
		ses.close();
	}

	private String generateOrderId() {
		String newOrderId = "";

		Session ses = sf.openSession();
		Query qq = ses.createQuery("from Orders");

		if (qq.list().size() == 0) {
			newOrderId = "ORD00001";
			ses.close();
		} else {
			Query q = ses.createQuery("select max(orderid) from Orders");
			String prevId = q.list().get(0).toString();
			// String prevId = data.get(0).toString();
			System.out.print("\nExisting : " + prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : " + id);
			id = id + 1;
			if (id <= 9)
				newOrderId = "ORD0000" + id;
			else if (id <= 99)
				newOrderId = "ORD000" + id;
			else if (id <= 999)
				newOrderId = "ORD00" + id;
			else if (id <= 9999)
				newOrderId = "ORD0" + id;
			else
				newOrderId = "ORD" + id;
			System.out.print("\nGenerated : " + newOrderId);
			ses.close();
		}
		return newOrderId;
	}

	private String generateOrderDetId() {
		String newOrderDetId = "";

		Session ses = sf.openSession();
		Query qq = ses.createQuery("from OrderDetails");

		if (qq.list().size() == 0) {
			newOrderDetId = "ORDDET00001";
			ses.close();
		} else {
			Query q = ses.createQuery("select max(orderDetid) from OrderDetails");
			String prevId = q.list().get(0).toString();
			// String prevId = data.get(0).toString();
			System.out.print("\nExisting : " + prevId);
			int id = Integer.parseInt(prevId.substring(6));
			System.out.print("\nExisting id : " + id);
			id = id + 1;
			if (id <= 9)
				newOrderDetId = "ORDDET0000" + id;
			else if (id <= 99)
				newOrderDetId = "ORDDET000" + id;
			else if (id <= 999)
				newOrderDetId = "ORDDET00" + id;
			else if (id <= 9999)
				newOrderDetId = "ORDDET0" + id;
			else
				newOrderDetId = "ORDDET" + id;
			System.out.print("\nGenerated : " + newOrderDetId);
			ses.close();
		}

		return newOrderDetId;
	}
}
