package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.categourydoa.CategouryDAOINT;
import com.project.model.Category;
import com.project.model.Product;

import com.project.productdao.ProductdaoiINT;
import com.sun.net.httpserver.HttpServer;

@Controller
public class Productcontroller {
	@Autowired
	ProductdaoiINT inte;
	@Autowired
	CategouryDAOINT cint;

	@RequestMapping("/reqproduct")
	public String getproductpage(Model m, HttpSession session) {
		if (session.getAttribute("customerobj") == null) {
			return "redirect:/reqsignin";
		}
		List<Product> pl = inte.getlistofproduct();
		m.addAttribute("pl", pl);
		m.addAttribute("productobj", new Product());
		return "productpage";
	}

	@RequestMapping("/reqaddproduct")
	public String addproduct(@ModelAttribute("productobj") Product p, HttpSession session) {
		// p.setProductavailable(true);
		/*
		 * if (session.getAttribute("customerobj") == null) { return
		 * "redirect:/reqsignin"; }
		 */
		inte.addproduct(p);

		return "redirect:/reqproduct";
	}

	@RequestMapping("/reqdeletproduct")
	public String deletproduct(@RequestParam("pid") String pid, HttpSession session) {

		/*
		 * if (session.getAttribute("customerobj") == null) { return
		 * "redirect:/reqsignin"; }
		 */
		inte.deleteproduct(pid);
		return "redirect:/reqproduct";
	}

	@RequestMapping("/reqeditproduct")
	public String getproductbyID(@RequestParam("pid") String pid, Model m, HttpSession session) {
		/*
		 * if (session.getAttribute("customerobj") == null) { return
		 * "redirect:/reqsignin"; }
		 */
		Product p = inte.getproductbyID(pid);
		m.addAttribute("pv", p);
		List<Category> lc = cint.getfulltabledetails();
		m.addAttribute("lc", lc);
		return "editproduct";

	}

	@RequestMapping("/requpdateproduct")
	public String updateproductdetails(@ModelAttribute("productobj") Product p, HttpSession session) {
		/*
		 * if (session.getAttribute("customerobj") == null) { return
		 * "redirect:/reqsignin"; }
		 */
		inte.updateProductdetails(p);
		return "productpage";
	}

	@RequestMapping("/reqbackhome")
	public String backhome(HttpSession session) {
		/*
		 * if (session.getAttribute("customerobj") == null) { return
		 * "redirect:/reqsignin"; }
		 */
		return "homepage";

	}

	@RequestMapping("/reqchangeproductavailability")
	public String updaterole(@RequestParam("pid") String pid, HttpSession session) {
		/*
		 * if (session.getAttribute("customerobj") == null) { return
		 * "redirect:/reqsignin"; }
		 */
		Product p = inte.getproductbyID(pid);
		inte.changeavailability(p);

		return "redirect:/reqopenadminpage?avilabity";

	}

}
