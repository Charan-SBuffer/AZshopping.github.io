package com.project.userdetailsdao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.UserDetails;

@Repository
public class UserdetailsDAO implements Userdetailsdaoint {

	@Autowired
	SessionFactory sf;

	public List<UserDetails> getlistofuserdetails() {
		Session session = sf.openSession();
		Query q = session.createQuery("from UserDetails");
		List<UserDetails> lud = q.list();
		session.close();
		return lud;
	}

	public boolean adduserdetailes(UserDetails ud) {
		ud.setUserid(generateuserID());
		ud.setEnabled(true);
		ud.setRole("ROLE_STUDENT");
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(ud);
		session.getTransaction().commit();
		session.close();
		return false;
	}

	private String generateuserID() {
		String g = "";
		Session s = sf.openSession();
		Query q = s.createQuery("from UserDetails");
		List<UserDetails> l = q.list();
		if (l.size() == 0) {
			g = "UD001";
		} else {
			q = s.createQuery("select max(userid) from UserDetails");
			String eg = (String) q.list().get(0);
			int id = Integer.parseInt(eg.substring(1));
			id++;
			if (id <= 9) {
				g = "UD00" + id;
			} else if (id <= 99) {
				g = "UD" + id;
			}
		}
		s.close();
		return g;

	}

	public boolean changeavailability(UserDetails ud) {
		boolean result = false;
		if (ud.isEnabled() == true) {
			ud.setEnabled(false);			
		} else if (ud.isEnabled() == false) {
			ud.setEnabled(true);
		}
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(ud);
		result = true;
		session.getTransaction().commit();
		
		session.close();
		return result;
	}

	public UserDetails getbyUserID(String id) {
		Session session = sf.openSession();
		session.beginTransaction();
		UserDetails ud = session.get(UserDetails.class, id);
		session.getTransaction().commit();
		session.close();
		return ud;
	}

	
	public boolean updateUserDetails(UserDetails ud) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(ud);
		session.getTransaction().commit();
		session.close();
		return false;
	}

}
