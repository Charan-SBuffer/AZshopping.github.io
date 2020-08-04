package com.project.categourydoa;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.Category;
import com.project.model.Xmapproductshopper;

@Repository
public class CategouryDao implements CategouryDAOINT {
	@Autowired
	private SessionFactory sf;

	public List<Category> getfulltabledetails() {
		Session session = sf.openSession();
		Query q = session.createQuery("from Category");
		List<Category> c = q.list();
		session.close();
		return c;
	}

	public boolean addcategory(Category c) {
		c.setCategoryid(generateID());
		c.setCategoryavailable(true);
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
		session.close();
		return true;

	}

	public String generateID() {
		String g = "";
		Session s = sf.openSession();
		Query q = s.createQuery("from Category");
		List<Category> l = q.list();
		if (l.size() == 0) {
			g = "C001";
		} else {
			q = s.createQuery("select max(categoryid) from Category");
			String eg = (String) q.list().get(0);
			int id = Integer.parseInt(eg.substring(1));
			id++;
			if (id <= 9) {
				g = "C00" + id;
			} else if (id <= 99) {
				g = "C" + id;
			}
		}
		s.close();
		return g;

	}

	public boolean deletcategory(String c) {
		Session session = sf.openSession();
		Category temp = session.get(Category.class, c);
		session.beginTransaction();
		session.delete(temp);
		session.getTransaction().commit();
		session.close();
		return false;
	}

	public Category getcategorybyID(String cid) {

		Session session = sf.openSession();
		Category temp = session.get(Category.class, cid);

		session.close();

		return temp;

	}

	public boolean updatecategory(Category c) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(c);
		session.getTransaction().commit();
		session.close();
		return false;
	}
	public boolean changeavailability(Category c) {
		boolean result = false;
		if (c.isCategoryavailable()==true) {
			c.setCategoryavailable(false);			
		} else if (c.isCategoryavailable() == false) {
			c.setCategoryavailable(true);
		}
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(c);
		result = true;
		session.getTransaction().commit();
		
		session.close();
		return result;
	}


}
