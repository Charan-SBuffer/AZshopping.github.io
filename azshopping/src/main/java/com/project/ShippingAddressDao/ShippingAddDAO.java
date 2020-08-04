package com.project.ShippingAddressDao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.Category;
import com.project.model.ShippingAddress;

@Repository
public class ShippingAddDAO implements ShippingAddINT {
	@Autowired
	SessionFactory sf;

	public List<ShippingAddress> getlistshippingaddDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addShippingDetails(ShippingAddress sa) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(sa);
		session.getTransaction().commit();
		sf.close();
		return false;
	}

	public String generateShippingaddID() {
		String g = "";
		Session s = sf.openSession();
		Query q = s.createQuery("from ShippingAddress");
		List<ShippingAddress> l = q.list();
		if (l.size() == 0) {
			g = "SA001";
		} else {
			q = s.createQuery("select max(shippingaddress) from ShippingAddress");
			String eg = (String) q.list().get(0);
			int id = Integer.parseInt(eg.substring(1));
			id++;
			if (id <= 9) {
				g = "SA00" + id;
			} else if (id <= 99) {
				g = "SA" + id;
			}
		}
		s.close();
		return g;

	}

	public boolean updateshippingadd(ShippingAddress sa) {
Session session=sf.openSession();
session.beginTransaction();
session.update(sa);
session.getTransaction().commit();
session.close();
return false;
	}

}
