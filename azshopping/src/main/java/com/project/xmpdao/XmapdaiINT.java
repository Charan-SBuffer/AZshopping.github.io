package com.project.xmpdao;

import java.util.List;

import com.project.model.Product;
import com.project.model.Xmapproductshopper;

public interface XmapdaiINT {

	public List<Xmapproductshopper> getlistofxmap();

	public boolean addxmap(Xmapproductshopper xps);

	public Xmapproductshopper getXmapbyID(String sid);

	public List<Product> getotherproducts(String sid);

	public boolean updateXmap(Xmapproductshopper xps);

	public boolean changeavailability(Xmapproductshopper ud);

}
