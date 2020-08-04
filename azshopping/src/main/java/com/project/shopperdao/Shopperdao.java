package com.project.shopperdao;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

import javax.persistence.criteria.Path;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.Category;
import com.project.model.Product;
import com.project.model.Shopper;

@Repository
public class Shopperdao implements ShopperINt {
	@Autowired
	private SessionFactory sf;

	public List<Shopper> getlistofshopper() {
		Session s = sf.openSession();
		Query q = s.createQuery("from Shopper");
		List<Shopper> l = q.list();
		s.close();
		return l;

	}

	public boolean addshopper(Shopper s) {
		s.setShopperid(generateID());
		s.setShopperavailable(true);
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		session.close();
		shopperImage(s);
		return true;

	}

	public String generateID() {
		String g = "";
		Session s = sf.openSession();
		Query q = s.createQuery("from Shopper");
		List<Shopper> l = q.list();
		if (l.size() == 0) {
			g = "S001";
		} else {
			q = s.createQuery("select max(shopperid) from Shopper");
			String eg = (String) q.list().get(0);
			int id = Integer.parseInt(eg.substring(1));
			id++;
			if (id <= 9) {
				g = "S00" + id;
			} else if (id <= 99) {
				g = "S" + id;
			}
		}
		return g;

	}

	public boolean deletshopper(String sid) {
		Session session = sf.openSession();
		Shopper temp = session.get(Shopper.class, sid);
		session.beginTransaction();
		session.delete(temp);
		session.getTransaction().commit();
		session.close();
		return false;
	}

	public Shopper getshopperbyID(String sid) {

		Session session = sf.openSession();
		Shopper temp = session.get(Shopper.class, sid);

		session.close();

		return temp;

	}

	public boolean updateshopperdetails(Shopper s) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(s);
		session.getTransaction().commit();
		session.close();
		return false;
	}

	public void shopperImage(Shopper s) {
		try {
			if (s.getImagefile() != null) {
				java.nio.file.Path path = Paths
						.get("F:\\projectws\\azshopping\\src\\main\\webapp\\resources\\images\\product\\"
								+ s.getShopperid() + ".jpg");
				s.getImagefile().transferTo(new File(path.toString()));
			}

		} catch (Exception ex) {
			System.out.print("Failed");
		}
	}
	
	public boolean changeavailability(Shopper s) {
		boolean result = false;
		if (s.isShopperavailable()==true) {
			s.setShopperavailable(false);			
		} else if (s.isShopperavailable() == false) {
			s.setShopperavailable(true);
		}
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(s);
		result = true;
		session.getTransaction().commit();
		
		session.close();
		return result;
	}
	

}
