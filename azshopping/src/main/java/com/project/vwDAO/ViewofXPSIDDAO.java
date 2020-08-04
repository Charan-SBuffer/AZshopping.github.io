package com.project.vwDAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.VW_PRODUCTDATA_USER;

@Repository
public class ViewofXPSIDDAO implements ViewofXPSID {

	@Autowired
	SessionFactory sf;

	public List<VW_PRODUCTDATA_USER> getlistofVIEW() {
		Session session = sf.openSession();
		Query q = session.createQuery(
				"from VW_PRODUCTDATA_USER where categoryavailable=true and productavailable=true and xpsavailable=true and shopperavailable=true");
		List<VW_PRODUCTDATA_USER> lv = q.list();
		session.close();

		return lv;
	}

}
