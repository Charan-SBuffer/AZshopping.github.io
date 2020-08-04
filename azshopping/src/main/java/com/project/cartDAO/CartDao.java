package com.project.cartDAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.Cart;
import com.project.model.Category;
import com.project.model.Vw_Cust_Cart_Full_Details;

@Repository
public class CartDao implements CartDaoINT {

	@Autowired
	SessionFactory sf;

	public boolean addCart(Cart c) {

		c.setCartid(generateID());
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
		session.close();
		return false;
	}

	public String generateID() {

		String g = "";
		Session s = sf.openSession();
		Query q = s.createQuery("from Cart");
		List<Cart> l = q.list();
		if (l.size() == 0) {
			g = "CRT001";
		} else {
			q = s.createQuery("select max(cartid) from Cart");
			String eg = (String) q.list().get(0);
			int id = Integer.parseInt(eg.substring(3));
			id++;
			if (id <= 9) {
				g = "CRT00" + id;
			} else if (id <= 99) {
				g = "CRT" + id;
			}
		}
		s.close();

		return g;
	}

	public boolean updatecart(Cart c) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(c);
		session.getTransaction().commit();
		session.close();
		return false;
	}

	@Override
	public Cart getCartById(String cid) {
		Session session = sf.openSession();
		session.beginTransaction();
		Cart c = session.get(Cart.class, cid);
		session.getTransaction().commit();
		session.close();

		return c;
	}
	public List<Vw_Cust_Cart_Full_Details> getCartItemsForCart(String cartid) {
		List<Vw_Cust_Cart_Full_Details> data= null;
		Session ses = sf.openSession();
		String q = "from Vw_Cust_Cart_Full_Details where cartid = ? order by cartitemid"; 
		Query qry = ses.createQuery(q);
		qry.setString(0, cartid);
		data = qry.list();
		ses.close(); 
		System.out.println(data);
		return data;
		}

}
