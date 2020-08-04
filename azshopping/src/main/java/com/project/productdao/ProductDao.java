package com.project.productdao;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.Category;
import com.project.model.Product;
import com.project.model.Shopper;
import com.project.shopperdao.ShopperINt;

@Repository
public class ProductDao implements ProductdaoiINT {
	@Autowired
	private SessionFactory sf;

	public List<Product> getlistofproduct() {
		Session session = sf.openSession();
		Query q = session.createQuery("from Product");
		List<Product> lp = q.list();
		session.close();
		return lp;
	}

	public boolean addproduct(Product p) {
		p.setProductid(generateID());
		p.setProductavailable(true);
		Session session = sf.openSession();
		// System.out.println(p.getProductid());
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		session.close();
		saveimnagefile(p);
		return false;
	}

	public boolean deleteproduct(String sid) {
		Session session = sf.openSession();
		Product temp = session.get(Product.class, sid);
		session.beginTransaction();
		session.delete(temp);
		session.getTransaction().commit();
		session.close();
		return false;
	}

	public Product getproductbyID(String pid) {

		Session session = sf.openSession();
		Product temp = session.get(Product.class, pid);
		session.close();
		return temp;

	}

	public boolean updateProductdetails(Product s) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(s);
		session.getTransaction().commit();
		session.close();
		return false;
	}

	public String generateID() {
		String g = "";
		Session s = sf.openSession();
		Query q = s.createQuery("from Product");
		List<Product> l = q.list();
		if (l.size() == 0) {
			g = "P001";
		} else {
			q = s.createQuery("select max(productid) from Product");
			String eg = (String) q.list().get(0);
			int id = Integer.parseInt(eg.substring(1));
			id++;
			if (id <= 9) {
				g = "P00" + id;
			} else if (id <= 99) {
				g = "P" + id;
			}
		}
		s.close();
		return g;

	}

	public void saveimnagefile(Product p) {
		try {
			if (p.getImagefile() != null) {
				Path path = Paths.get("F:\\projectws\\azshopping\\src\\main\\webapp\\resources\\images\\product\\"
						+ p.getProductid() + ".jpg");
				p.getImagefile().transferTo(new File(path.toString()));
			}

		} catch (Exception ex) {
			System.out.print("Failed");
		}

	}

	public boolean changeavailability(Product p) {
		boolean result = false;
		String g = p.getProductid();
		Session session = sf.openSession();
		session.beginTransaction();

		if (p.isProductavailable() == true) {
			p.setProductavailable(false);
			session.update(p);

			Query q = session.createQuery(
					"update CartItems set enabled=false  where xpsid in(select xpsid from Xmapproductshopper where productid=? )");
			q.setString(0, g);
			q.executeUpdate();
			result = true;
			session.getTransaction().commit();

			session.close();
		} else if (p.isProductavailable() == false) {
			p.setProductavailable(true);
			session.update(p);

			Query q = session.createQuery(
					"update CartItems set enabled=true where xpsid in(select xpsid from Xmapproductshopper where productid=? )");
			q.setString(0, g);
			q.executeUpdate();
			result = true;
			session.getTransaction().commit();

			session.close();
		}

		/*
		 * Product product = getproductbyID(g);
		 */

		return result;
	}

	@Override
	public List<Product> searchforproduct(String pname) {
		Session session = sf.openSession();
		Query q = session.createQuery("Select from Product where productname=?");
		q.setString(0, pname);
		List<Product> p = q.list();
		session.close();
		return p;
	}

	public List<Product> getlistofPRosuctsbyOrderID(String orderid) {
		Session session = sf.openSession();
		Query q = session.createQuery("select from Orders where orderid=?");
		q.setString(0, orderid);
		session.beginTransaction();
		List<Product> lp = q.list();
		session.getTransaction().commit();
		session.close();
		return lp;
	}

}
