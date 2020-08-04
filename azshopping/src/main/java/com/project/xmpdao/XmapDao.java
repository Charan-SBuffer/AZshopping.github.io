package com.project.xmpdao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.Category;
import com.project.model.Product;
import com.project.model.Shopper;
import com.project.model.UserDetails;
import com.project.model.Xmapproductshopper;
import com.project.shopperdao.ShopperINt;

@Repository
public class XmapDao implements XmapdaiINT {
	@Autowired
	SessionFactory sf;

	public List<Xmapproductshopper> getlistofxmap() {
		Session session = sf.openSession();
		Query q = session.createQuery("from Xmapproductshopper");
		List<Xmapproductshopper> ls = q.list();
		session.close();
		return ls;

	}

	public boolean addxmap(Xmapproductshopper xps) {
		xps.setXpsid(generateID());
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(xps);
		session.getTransaction().commit();
		session.close();
		return false;
	}

	public boolean deletshopper(String sid) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateshopperdetails(Shopper s) {
		// TODO Auto-generated method stub
		return false;
	}

	public Xmapproductshopper getXmapbyID(String sid) {
		Session session = sf.openSession();
		Xmapproductshopper xm = session.get(Xmapproductshopper.class, sid);

		session.close();

		return xm;
	}

	public String generateID() {
		String g = "";
		Session s = sf.openSession();
		Query q = s.createQuery("from Xmapproductshopper");
		List<Xmapproductshopper> l = q.list();
		if (l.size() == 0) {
			g = "XPS001";
		} else {
			q = s.createQuery("select max(xpsid) from Xmapproductshopper");
			String eg = (String) q.list().get(0);
			int id = Integer.parseInt(eg.substring(3));
			id++;
			if (id <= 9) {
				g = "XPS00" + id;
			} else if (id <= 99) {
				g = "XPS" + id;
			}
		}
		s.close();
		return g;

	}

	public List<Product> getotherproducts(String sid) {
		Session session = sf.openSession();
		Query q = session.createQuery(
				"from Product where productid not in(select productid from Xmapproductshopper where shopperid=?)");
		q.setString(0, sid);
		List<Product> products = q.list();
		session.close();
		return products;

	}
	public boolean updateXmap(Xmapproductshopper xps) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(xps);
		session.getTransaction().commit();
		session.close();
		return false;
	}
	public boolean changeavailability(Xmapproductshopper ud) {
		boolean result = false;
		if (ud.isXpsavailable()==true) {
			ud.setXpsavailable(false);			
		} else if (ud.isXpsavailable() == false) {
			ud.setXpsavailable(true);
		}
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(ud);
		result = true;
		session.getTransaction().commit();
		
		session.close();
		return result;
	}

}
