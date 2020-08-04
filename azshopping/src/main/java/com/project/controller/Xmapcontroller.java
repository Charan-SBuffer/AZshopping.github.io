package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.categourydoa.CategouryDAOINT;
import com.project.model.Category;
import com.project.model.Product;
import com.project.model.Shopper;
import com.project.model.UserDetails;
import com.project.model.Xmapproductshopper;
import com.project.productdao.ProductdaoiINT;
import com.project.shopperdao.ShopperINt;
import com.project.xmpdao.XmapdaiINT;

@Controller
public class Xmapcontroller {

	@Autowired
	XmapdaiINT xint;
	@Autowired
	ProductdaoiINT pint;
	@Autowired
	ShopperINt sint;

	@RequestMapping("/reqxmap")
	public String getxmap(Model m) {

		List<Xmapproductshopper> lxmap = xint.getlistofxmap();
		List<Shopper> ls = sint.getlistofshopper();
		m.addAttribute("lshp", ls);
		m.addAttribute("lxmap", lxmap);

		return "xmappage";
	}

	@RequestMapping("/reqgetXmap")
	public String addxmap(@RequestParam("sid") String xs, Model m) {
		// Xmapproductshopper xm=xint.getXmapbyID(xs);
		// String xs1=xm.getShopperid();
		// m.addAttribute("xmap",xm);
		List<Product> lx = xint.getotherproducts(xs);
		m.addAttribute("lxmap", lx);
		Xmapproductshopper xps = new Xmapproductshopper();
		xps.setShopperid(xs);
		m.addAttribute("xpsobj", xps);
		return "addxmap";
	}

	@RequestMapping("/reqaddxmap")
	public String addxmapindatabse(@ModelAttribute("xpsobj") Xmapproductshopper xps) {
		xint.addxmap(xps);
		return "redirect:/reqxmap";
	}
	@RequestMapping("/reqchangexmapexistens")
	public String updaterole(@RequestParam("xpsid")String xpsid) {
		
		Xmapproductshopper xps=xint.getXmapbyID(xpsid);
		xint.changeavailability(xps);
		
		return "redirect:/reqopenadminpage?avilabity";
		
	}


}
