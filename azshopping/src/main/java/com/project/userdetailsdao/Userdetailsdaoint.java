package com.project.userdetailsdao;

import java.util.List;

import com.project.model.UserDetails;

public interface Userdetailsdaoint {
	
	
 public List<UserDetails> getlistofuserdetails();
 public boolean adduserdetailes(UserDetails ud);
public boolean changeavailability(UserDetails ud);
public UserDetails getbyUserID(String ud);
public boolean updateUserDetails(UserDetails ud);
}
