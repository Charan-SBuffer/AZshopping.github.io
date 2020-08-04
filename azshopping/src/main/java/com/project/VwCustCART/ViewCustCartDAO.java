package com.project.VwCustCART;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.Vw_Cust_Cart_Full_Details;

@Repository
public class ViewCustCartDAO implements ViewCustCartINT {
	@Autowired
	SessionFactory sf;

	public List<Vw_Cust_Cart_Full_Details> getListofCustCart(String cid) {
		Session session = sf.openSession();
		Query q = session.createQuery("from Vw_Cust_Cart_Full_Details where customerid='" + cid + "' ");
		List<Vw_Cust_Cart_Full_Details> lv = q.list();
		session.close();
		return lv;
	}

}
