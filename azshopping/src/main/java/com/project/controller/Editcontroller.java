package com.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.BillingaddDAO.BillingAddINT;
import com.project.CartItem.CartitemINT;
import com.project.ShippingAddressDao.ShippingAddINT;
import com.project.VwCustCART.ViewCustCartINT;
import com.project.cartDAO.CartDaoINT;
import com.project.customerDao.CustomerDAOINT;
import com.project.model.BillingAddress;
import com.project.model.Customer;
import com.project.model.Message;
import com.project.model.ShippingAddress;
import com.project.shopperdao.ShopperINt;
import com.project.vwDAO.ViewofXPSID;

@Controller
public class Editcontroller {
	@Autowired
	CartDaoINT crtint;
	@Autowired
	CustomerDAOINT cint;
	@Autowired
	ShopperINt sint;
	@Autowired
	ViewofXPSID xint;
	@Autowired
	CartitemINT cartint;
	@Autowired
	ViewCustCartINT vcint;
	@Autowired
	ShippingAddINT saint;
	@Autowired
	BillingAddINT bint;

	@RequestMapping("/requpdatepassword")
	public String updatepassword(@RequestParam(value = "passwordfaield", required = false) String pswrdfald,
			@RequestParam("oldpswrd") String oldpswrd, @RequestParam("confnewpswrd") String confnewpswrd,
			@RequestParam("newpswrd") String newpswrd, HttpSession session, Model m) {

		Customer currentcustomer = (Customer) session.getAttribute("customerobj");
		if (currentcustomer == null) {
			return "redirect:/home";
		}
		String pswrd = currentcustomer.getUserDetails().getPassword();
		if (pswrdfald != null) {
			m.addAttribute("msg", new Message("ERR", "Something went wrong"));
			return "editpassword";
		}
		if (oldpswrd.equalsIgnoreCase(pswrd)) {
			if (newpswrd.equalsIgnoreCase(confnewpswrd)) {
				currentcustomer.getUserDetails().setPassword(confnewpswrd);
				cint.update(currentcustomer);
				return "redirect:/home?passwordupdated";
			} else if (!newpswrd.equalsIgnoreCase(confnewpswrd)) {
				return "redirect:/reqchngpassword?passwordmismatch";
			}
		} else {
			return "redirect:/reqsignin?passwordfaield";
		}
		return "editpassword";

	}

	@RequestMapping("requpdateshippingadd")
	public String updateshipingADD(@ModelAttribute("shippinaddobj") ShippingAddress sa, HttpSession session) {

		Customer currentcustomer = (Customer) session.getAttribute("customerobj");
		if (currentcustomer == null) {
			return "redirect:/home";
		} else {

			saint.updateshippingadd(sa);

			return "redirect:/reqopenstudentpage?updatedshippingaddress";
		}
	}

	@RequestMapping("requpdatebillingadd")
	public String updatebillingadd(@ModelAttribute("billingaddobj") BillingAddress ba, HttpSession session) {
		Customer currentcustomer = (Customer) session.getAttribute("customerobj");
		if (currentcustomer == null) {
			return "redirect:/home";
		} else {

			bint.updatebillingAdd(ba);

			return "redirect:/reqopenstudentpage?updatedbillingaddress";

		}

	}

	@RequestMapping("/requpdatecustomerinfo")
	public String updatecustomerINfo(@ModelAttribute("customer") Customer c, HttpSession session) {
		Customer currentcustomer = (Customer) session.getAttribute("customerobj");
		if (currentcustomer == null) {
			return "redirect:/home";
		} else {

			c.setBillingAddress(currentcustomer.getBillingAddress());
			c.setShippingAddress(currentcustomer.getShippingAddress());
			c.setUserDetails(currentcustomer.getUserDetails());
			c.setCart(currentcustomer.getCart());

			cint.update(c);
			
			  currentcustomer = cint.getbyCustomerID(c.getCustomerid());
			  session.setAttribute("customerobj", currentcustomer);
			 

			return "redirect:/reqopenstudentpage?updatedbillingaddress";
		}
	}
}
