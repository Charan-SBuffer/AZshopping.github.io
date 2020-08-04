package com.project.BillingaddDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.BillingAddress;

@Repository
public class BillingAddDAO implements BillingAddINT {

	@Autowired
	SessionFactory sf;

	public boolean updatebillingAdd(BillingAddress ba) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(ba);
		session.getTransaction().commit();
		session.close();

		return false;
	}

}
