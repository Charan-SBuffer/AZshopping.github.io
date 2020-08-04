package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.categourydoa.CategouryDAOINT;
import com.project.model.Category;
import com.project.model.Message;
import com.project.model.Xmapproductshopper;

@Controller
public class Categourycontroller {
	@Autowired
	CategouryDAOINT ci;

	@RequestMapping(value = { "/", "home" })
	public String homepage(@RequestParam(value = "passwordupdated", required = false) String passwordupdated,@RequestParam(value="loginfailed",required=false)String loginfailed ,Model m) {
		if (passwordupdated!=null) {
			m.addAttribute("msg", new Message("INFO", "Password updated"));
			return "homepage";
		}
		else if(loginfailed!=null) {
			m.addAttribute("msg",new Message("ERR","Login Faield"));
			return "homepage";

		}
		else {
		return "homepage";
		}
	}

	@RequestMapping("/reqcategoury")
	public String categourypage(Model m,HttpSession session) {
		/*
		 * if(session.getAttribute("customerobj")==null) { return "redirect:/reqsignin";
		 * }
		 */
		List<Category> lc = ci.getfulltabledetails();
		m.addAttribute("lc", lc);

		return "categourys";
	}

	@RequestMapping("/reqaddcategoury")
	public String addcategoury(@RequestParam("cn") String cn,HttpSession session) {
		/*
		 * if(session.getAttribute("customerobj")==null) { return "redirect:/reqsignin";
		 * }
		 */
		Category c = new Category();
		c.setCategoryname(cn);
		ci.addcategory(c);

		return "redirect:/reqcategoury";

	}

	@RequestMapping("/reqdeletcategoury")
	public String deletcategoury(@RequestParam("cid") String cid,HttpSession session) {
		/*
		 * if(session.getAttribute("customerobj")==null) { return "redirect:/reqsignin";
		 * }
		 */
		ci.deletcategory(cid);

		return "redirect:/reqcategoury";

	}

	@RequestMapping("/reqeditcategory")
	public String editcategoury(@RequestParam("cid") String cid, Model m) {

		Category c = ci.getcategorybyID(cid);
		m.addAttribute("category", c);

		return "editcategory";
	}

	@RequestMapping("/requpdatecategoury")
	public String updatecategoury(@RequestParam("cid") String cid, @RequestParam("cn") String cn,
			@RequestParam("ca") boolean ca,HttpSession session) {
		/*
		 * if(session.getAttribute("customerobj")==null) { return "redirect:/reqsignin";
		 * }
		 */
		Category c = new Category();
		c.setCategoryid(cid);
		c.setCategoryname(cn);
		c.setCategoryavailable(ca);
		ci.updatecategory(c);
		return "redirect:/reqcategoury";

	}
	@RequestMapping("/reqchangecategoryavailable")
	public String updaterole(@RequestParam("cid")String cid,HttpSession session) {
		/*
		 * if(session.getAttribute("customerobj")==null) { return "redirect:/reqsignin";
		 * }
		 */
		Category c=ci.getcategorybyID(cid);
		ci.changeavailability(c);
		
		return "redirect:/reqopenadminpage?avilabity";
		
	}


}
