package com.project.categourydoa;

import java.util.List;

import com.project.model.Category;

public interface CategouryDAOINT {

	public List<Category> getfulltabledetails();

	public boolean addcategory(Category c);

	public boolean deletcategory(String c);

	public Category getcategorybyID(String c);

	public boolean updatecategory(Category c);
	public boolean changeavailability(Category c);

}
