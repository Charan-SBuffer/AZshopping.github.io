package com.project.customerDao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.BillingAddress;
import com.project.model.Cart;
import com.project.model.Category;
import com.project.model.Customer;
import com.project.model.ShippingAddress;
import com.project.model.UserDetails;

@Repository
public class CustomerDAO implements CustomerDAOINT {

	@Autowired
	SessionFactory sf;

	@Override
	public boolean addCustomer1(Customer c) {
		c.setCustomerid(generatecustomerID());
		c.getUserDetails().setUserid(generateUserId());
		c.getBillingAddress().setBillingaddressid(generatebillingaddressID());
		c.getShippingAddress().setShippingaddressid(generateshippingaddressID());
		c.getCart().setCartid(generatecartID());

		Session session = sf.openSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
		session.close();
		addimageCustomer(c);
		return true;
	}
	@Override
	public Customer getNewCustomer() {
		Customer cust = new Customer();
		cust.setUserDetails(new UserDetails());
		cust.setBillingAddress(new BillingAddress());
		cust.setShippingAddress(new ShippingAddress());
		cust.setCart(new Cart());
		return cust;
	}
	public List<Customer> getlistofcustomer() {
		Session session = sf.openSession();
		Query q = session.createQuery("from Customer");
		List<Customer> ls = q.list();
		session.close();
		return ls;
	}

	public boolean addcustomer(Customer c) {
		c.setCustomerid(generatecustomerID());
		c.getUserDetails().setUserid(generateUserId());
		c.getBillingAddress().setBillingaddressid(generatebillingaddressID());
		c.getShippingAddress().setShippingaddressid(generateshippingaddressID());
		c.getCart().setCartid(generatecartID());

		Session session = sf.openSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
		session.close();
		addimageCustomer(c);
		return false;
	}

	public String generatecustomerID() {
		String g = "";
		Session s = sf.openSession();
		Query q = s.createQuery("from Customer");
		List<Customer> l = q.list();
		if (l.size() == 0) {
			g = "CS001";
		} else {
			q = s.createQuery("select max(customerid) from Customer");
			String eg = (String) q.list().get(0);
			int id = Integer.parseInt(eg.substring(2));
			id++;
			if (id <= 9) {
				g = "CS00" + id;
			} else if (id <= 99) {
				g = "CS" + id;
			}
		}
		s.close();
		return g;

	}

	private String generatebillingaddressID() {

		String g = "";
		Session s = sf.openSession();
		Query q = s.createQuery("from BillingAddress");
		List<BillingAddress> l = q.list();
		if (l.size() == 0) {
			g = "BA001";
		} else {
			q = s.createQuery("select max(billingaddressid) from BillingAddress");
			String eg = (String) q.list().get(0);
			int id = Integer.parseInt(eg.substring(2));
			id++;
			if (id <= 9) {
				g = "BA00" + id;
			} else if (id <= 99) {
				g = "BA" + id;
			}
		}
		s.close();
		return g;
	}

	private String generateshippingaddressID() {
		String g = "";
		Session s = sf.openSession();
		Query q = s.createQuery("from ShippingAddress");
		List<ShippingAddress> l = q.list();
		if (l.size() == 0) {
			g = "SA001";
		} else {
			q = s.createQuery("select max(shippingaddressid) from ShippingAddress");
			String eg = (String) q.list().get(0);
			int id = Integer.parseInt(eg.substring(2));
			id++;
			if (id <= 9) {
				g = "SA00" + id;
			} else if (id <= 99) {
				g = "SA" + id;
			}
		}
		s.clear();
		return g;
	}

	private String generatecartID() {
		String g = "";
		Session s = sf.openSession();
		Query q = s.createQuery("from Cart");
		List<Cart> l = q.list();
		if (l.size() == 0) {
			g = "CA001";
		} else {
			q = s.createQuery("select max(cartid) from Cart");
			String eg = (String) q.list().get(0);
			int id = Integer.parseInt(eg.substring(2));
			id++;
			if (id <= 9) {
				g = "CA00" + id;
			} else if (id <= 99) {
				g = "CA" + id;
			}
		}
		s.close();
		return g;
	}

	private String generateUserId() {

		String g = "";
		Session s = sf.openSession();
		Query q = s.createQuery("from UserDetails");
		List<UserDetails> l = q.list();
		if (l.size() == 0) {
			g = "UD001";
		} else {
			q = s.createQuery("select max(userid) from UserDetails");
			String eg = (String) q.list().get(0);
			int id = Integer.parseInt(eg.substring(2));
			id++;
			if (id <= 9) {
				g = "UD00" + id;
			} else if (id <= 99) {
				g = "UD" + id;
			}
		}
		s.close();
		return g;
	}

	public boolean logincheck(String uid, String upd) {
		Session session = sf.openSession();
		Query q = session.createQuery("from UserDetails where userid=? and password=? and enabled=true");
		q.setString(0, uid);
		q.setString(1, upd);

		List<UserDetails> listud = q.list();
		if (listud.size() > 0) {
			session.close();
			return true;
		} else {
			session.close();
			return false;
		}
	}

	public Customer getcustomerbyuserID(String uid) {
		Session session = sf.openSession();
		UserDetails ud = session.get(UserDetails.class, uid);
		Customer cs = ud.getCustomer();
		session.close();
		return cs;
	}

	private void addimageCustomer(Customer c) {
		try {
			Path path = Paths.get("F:\\projectws\\azshopping\\src\\main\\webapp\\resources\\images\\customer\\"
					+ c.getCustomerid() + ".jpg");
			c.getImagefile().transferTo(new File(path.toString()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public void update(Customer currentcustomer) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(currentcustomer);
		session.getTransaction().commit();
		session.close();
	}

	public Customer getbyCustomerID(String Customerid) {
		Session session = sf.openSession();
		Customer customer = session.get(Customer.class, Customerid);
		session.close();
		return customer;
	}

}
