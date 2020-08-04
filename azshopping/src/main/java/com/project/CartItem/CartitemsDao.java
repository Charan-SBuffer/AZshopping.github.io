

package com.project.CartItem;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.Cart;
import com.project.model.CartItems;

@Repository
public class CartitemsDao implements CartitemINT {
	@Autowired
	SessionFactory sf;

	public List<CartItems> getCartITEMS() {

		return null;
	}

	public boolean updatecart(CartItems c) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(c);
		session.getTransaction().commit();
		session.close();

		return false;
	}

	public boolean addtoCART(CartItems ci) {
		boolean itemfound = false;

		Cart c = ci.getCart();
		CartItems existingitem = null;
		for (CartItems ci1 : c.getCartitems()) {
			if (ci1.getXpsid().equals(ci.getXpsid())) {
				itemfound = true;
				existingitem = ci1;
				break;
			}

		}
		if (itemfound == true) {
			if (existingitem.getQuantity() < 5) {
				existingitem.setQuantity(existingitem.getQuantity() + 1);
				Session s = sf.openSession();
				s.beginTransaction();
				s.update(existingitem);
				s.getTransaction().commit();
				s.close();
				itemfound = true;
			}
		} else if (itemfound == false) {

			ci.setCartitemid(generateID());
			ci.setEnabled(true);
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(ci);
			session.getTransaction().commit();
			session.close();
			return true;
		}

		return itemfound;
	}

	public boolean deletcartitem(String c) {

		Session session = sf.openSession();
		CartItems ci = session.get(CartItems.class, c);
		session.beginTransaction();
		session.delete(ci);
		session.getTransaction().commit();
		session.close();

		return false;

	}

	public String generateID() {
		String g = "";
		Session s = sf.openSession();
		Query q = s.createQuery("from CartItems");
		List<CartItems> l = q.list();
		if (l.size() == 0) {
			g = "CI001";
		} else {
			q = s.createQuery("select max(cartitemid) from CartItems");
			String eg = (String) q.list().get(0);
			int id = Integer.parseInt(eg.substring(2));
			id++;
			if (id <= 9) {
				g = "CI00" + id;
			} else if (id <= 99) {
				g = "CI" + id;
			}
		}
		s.close();
		return g;

	}

	public boolean increaseqnt(String citemid) {
		boolean done;
		Session session = sf.openSession();
		CartItems ci = session.get(CartItems.class, citemid);
		if (ci.getQuantity() < 5) {
			ci.setQuantity(ci.getQuantity() + 1);
			session.beginTransaction();
			session.save(ci);
			session.update(ci);
			session.getTransaction().commit();
			session.close();
			done = true;
		} else {
			session.close();
			done = false;
		}

		return done;

	}

	public boolean decreaseqnt(String citemid) {
		boolean done;
		Session session = sf.openSession();
		CartItems ci = session.get(CartItems.class, citemid);
		if (ci.getQuantity() > 1) {
			ci.setQuantity(ci.getQuantity() - 1);
			session.beginTransaction();
			session.save(ci);
			session.update(ci);
			session.getTransaction().commit();
			session.close();
			done = true;

		} else {
			session.close();
			done = false;
		}
		return done;

	}
}
