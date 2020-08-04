package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.Shopper;
import com.project.shopperdao.ShopperINt;

@Controller
public class Shopperdetailscontroller {
	@Autowired
	ShopperINt si;
	
	@RequestMapping("/reqshopper")
	public String shopperpage(Model m) {
		List<Shopper> lc = si.getlistofshopper();
		m.addAttribute("lc", lc);
m.addAttribute("shopperobj", new Shopper());
		return "shopper";
	}

	@RequestMapping("/reqaddshopper")
	public String addshopper(@ModelAttribute("shopperobj")Shopper s) {
		
		si.addshopper(s);
		return "redirect:/reqshopper";
	}

	@RequestMapping("/reqdeletshopperdetails")
	public String dletshopper(@RequestParam("sid") String sid) {
		si.deletshopper(sid);

		return "redirect:/reqshopper";
	}
	@RequestMapping("/reqeditshopperdetails")
	public String editshopperdetails(@RequestParam("sid") String sid, Model m) {

		Shopper s = si.getshopperbyID(sid);
		m.addAttribute("shopper", s);

		return "editshopperdetails";
	}

	@RequestMapping("/requpdateshopperdetails")
	public String upshopperdetails(@RequestParam("sid") String sid, @RequestParam("sn") String sn,
			@RequestParam("sd") String sd,@RequestParam("sa") boolean sa) {
		Shopper s = new Shopper();
		s.setShopperid(sid);
		s.setShoppername(sn);
		s.setShopperdesc(sd);
		s.setShopperavailable(sa);
		si.updateshopperdetails(s);
		return "redirect:/reqshopper";

	}
	@RequestMapping("/reqchangeshopperexistemse")
	public String changeexistense(@RequestParam("sid")String sid) {
		Shopper s=si.getshopperbyID(sid);
		si.changeavailability(s);
		return "redirect:/reqopenadminpage?avilabity";
		
	}
}

