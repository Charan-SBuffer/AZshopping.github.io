 package com.project.controller;

import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.h2.engine.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.CartItem.CartitemINT;
import com.project.VwCustCART.ViewCustCartINT;
import com.project.cartDAO.CartDaoINT;
import com.project.customerDao.CustomerDAOINT;
import com.project.model.BillingAddress;
import com.project.model.Cart;
import com.project.model.CartItems;
import com.project.model.Customer;
import com.project.model.Message;
import com.project.model.OrderDetails;
import com.project.model.Orders;
import com.project.model.Product;
import com.project.model.ShippingAddress;
import com.project.model.UserDetails;
import com.project.model.VW_PRODUCTDATA_USER;
import com.project.model.Vw_Cust_Cart_Full_Details;
import com.project.orderDAO.OrderINT;
import com.project.productdao.ProductdaoiINT;
import com.project.shopperdao.ShopperINt;
import com.project.userdetailsdao.Userdetailsdaoint;
import com.project.vwDAO.ViewofXPSID;

@Controller
public class Homepagecontroller {
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
	Userdetailsdaoint uint;
	@Autowired
	private Emailservice emailService;
	@Autowired
	private OrderINT oint;
	@Autowired
	private ProductdaoiINT pint;

	@RequestMapping("/reqabout")
	public String aboutud() {

		return "aboutus";
	}

	//@RequestMapping("/reqsignup")
	public String getlogin(Model m) {
		Customer customer = new Customer();

		ShippingAddress sa = new ShippingAddress();

		UserDetails ud = new UserDetails();
		customer.setShippingAddress(sa);
		customer.setUserDetails(ud);
		m.addAttribute("customer", customer);
		return "singuppage";
	}

	@RequestMapping("/reqaddcustomer")
	public String addcustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model m) {
		if (result.hasErrors()) {
			m.addAttribute("customer", customer);
			return "singuppage";
		}
		customer.getUserDetails().setEnabled(true);
		customer.getUserDetails().setRole("ROLE_STUDENT");
		customer.setBillingAddress(new BillingAddress());
		customer.getBillingAddress().setArea(customer.getShippingAddress().getArea());
		customer.getBillingAddress().setCity(customer.getShippingAddress().getCity());
		customer.getBillingAddress().setBillingaddressid(customer.getShippingAddress().getShippingaddressid());
		customer.getBillingAddress().setCountry(customer.getShippingAddress().getCountry());
		customer.getBillingAddress().setCustomer(customer.getShippingAddress().getCustomer());
		customer.getBillingAddress().setHouseno(customer.getShippingAddress().getHouseno());
		customer.getBillingAddress().setPincode(customer.getShippingAddress().getPincode());
		customer.getBillingAddress().setState(customer.getShippingAddress().getState());
		customer.getBillingAddress().setStreet(customer.getShippingAddress().getStreet());

		customer.setCart(new Cart());
		cint.addcustomer(customer);
		UserDetails ud = customer.getUserDetails();
		String usid = ud.getUserid();
		String subject = "Signup Success :: AZshopping.com";
		String body = "Dear " + customer.getCustomername() + ",\nWelcome to AZshopping.com";
		body = body + "\n\nYour account created successfully!! thank you\nYour user id : " + usid
				+ "\nUse this user id to login to our website";
		body = body + "\n\n\nRegards,\nTestSite Team\nDT - NIIT-KPHB";
		try {
			emailService.send(customer.getCustomeremailid(), subject, body);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/reqSpringLoginPage?usid=" + usid;
	}

	@RequestMapping("/reqSpringLoginPage")
	public String getloginpage(@RequestParam(value = "passwordreset", required = false) String p,
			@RequestParam(value = "usid", required = false) String g,
			@RequestParam(value = "loginfailed", required = false) String lf,

			@RequestParam(value = "passwordupdated", required = false) String pasword, Model m) {
		if (p != null) {
			m.addAttribute("mssg", new Message("INFO", "PASSWORD WILL BE SENT TO MAIL"));

		}
		if (g != null) {
			m.addAttribute("mssg", new Message("INFO", "Signup SUCESS :" + g));

		}
		if (lf != null) {
			m.addAttribute("mssg", new Message("ERR", "login failed 'RETRY'"));
		}
		if (pasword != null) {
			m.addAttribute("mssg", new Message("INFO", "Request Sucess"));
		} else {
			// UserDetails usd = new UserDetails();
			// m.addAttribute("userdetailsobj", usd);
		}
		return "loginpage";

	}

	@RequestMapping("/reqopensite")
	public String loginCHECK(@ModelAttribute("userdetailsobj") UserDetails ud, Model m, HttpSession hsession) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		String userrole = authentication.getAuthorities().toString();
		System.out.print("\nUser ID : " + username);
		System.out.print("\nRole : " + userrole);
		Customer currentcustomer = cint.getcustomerbyuserID(username);	
		hsession.setAttribute("customerobj", currentcustomer);
		if (currentcustomer.getUserDetails().getRole().contains("STUDENT")) {
			return "redirect:/reqopenstudentpage";
		} else if (currentcustomer.getUserDetails().getRole().contains("ADMIN")) {
			return "redirect:/reqopenadminpage";
		} else {
			return "redirect:/reqSpringLoginPage?loginfailedd";
		}
		/*
		 * if (cint.logincheck(ud.getUserid(), ud.getPassword()) != true) { return
		 * "redirect:/home?loginfailed"; } else if (cint.logincheck(ud.getUserid(),
		 * ud.getPassword()) == true) { Customer currentcustomer =
		 * cint.getcustomerbyuserID(ud.getUserid());
		 * hsession.setAttribute("customerobj", currentcustomer);
		 * 
		 * if (currentcustomer.getUserDetails().getRole().contains("STUDENT")) {
		 * 
		 * return "redirect:/reqopenstudentpage"; }
		 * 
		 * else if (currentcustomer.getUserDetails().getRole().contains("ADMIN")) {
		 * return "redirect:/reqopenadminpage"; } else { return
		 * "redirect:/reqopensite?loginfailed"; }
		 * 
		 * }
		 */
		// return "redirect:/reqopensite?loginfailed";

	}

	@RequestMapping("/reqopenstudentpage")
	public String opensite(@RequestParam(value = "Orderconfermed", required = false) String orderconformed,
			@RequestParam(value = "updatedbillingaddress", required = false) String updatedbillingadd,
			@RequestParam(value = "updatedshippingaddress", required = false) String updatedshippingaddress,
			@RequestParam(value = "itemadded", required = false) String itemadded, Model m, HttpSession sesion) {
		Customer currentcustomer = (Customer) sesion.getAttribute("customerobj");
		if (currentcustomer == null) {
			return "redirect:/home";
		} else {
			if (updatedshippingaddress != null || updatedbillingadd != null || orderconformed != null) {

				if (orderconformed != null) {
					String oredrid = currentcustomer.getCart().getCartid();

					String subject = "Order Confirmed :: AZshopping.com";
					String body = "Dear " + currentcustomer.getCustomername() + ",\nWelcome to AZshopping.com";
					body = body + "\n This is ur Cart ID  " + oredrid;
					body = body + " \nThanks for shopping with us";
					body = body + "\n\n\nRegards,\nTestSite Team\nDT - NIIT-Basheerbagh";
					try {
						emailService.send(currentcustomer.getCustomeremailid(), subject, body);
					} catch (MessagingException e) { // TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				m.addAttribute("msg", new Message("INFO", "UPDATE SUCESS"));
				return "studentpage";
			} else if (itemadded != null) {
				String msg = "Item added sucess";
				m.addAttribute("msg", msg);

				return "redirect:/reqopenstudentpage";
			}
		}
		List<CartItems> lci = currentcustomer.getCart().getCartitems();
		List<VW_PRODUCTDATA_USER> lv = xint.getlistofVIEW();
		m.addAttribute("customerobj", currentcustomer);
		m.addAttribute("listofcartitems", lci);
		m.addAttribute("listofview", lv);
		return "studentpage";
	}

	@RequestMapping("/reqopenadminpage")
	public String openadminpage(@RequestParam(value = "avilabity", required = false) String g, Model m,
			HttpSession session) {
		if (session.getAttribute("customerobj") == null) {
			return "redirect:/reqsignin";
		}
		if (g != null) {
			m.addAttribute("msg", new Message("INFO", "AVAILABILTY CHANGED"));
			return "adminpage";

		}
		return "adminpage";

	}

	@RequestMapping("/reqaddtocart")
	public String addtocartitems(@RequestParam("xpsid") String xpsid, HttpSession hsession) {
		CartItems ci = new CartItems();

		Customer currentcustomer = (Customer) hsession.getAttribute("customerobj");
		if (currentcustomer == null) {
			return "redirect:/home";

		}

		else {

			ci.setXpsid(xpsid);
			ci.setQuantity(1);
			ci.setItemwisetotal(0);
			ci.setCart(currentcustomer.getCart());
			cartint.addtoCART(ci);
			List<Vw_Cust_Cart_Full_Details> lv = vcint.getListofCustCart(currentcustomer.getCustomerid());
			int total = 0;

			for (int i = 0; i < lv.size(); i++) {
				total += lv.get(i).getQuantity() * lv.get(i).getXpsprice();
				// m.addAttribute("msg",total);
			}
			currentcustomer.getCart().setGrandtotoal(total);
			crtint.updatecart(currentcustomer.getCart());

			Customer temp = cint.getcustomerbyuserID(currentcustomer.getUserDetails().getUserid());
			hsession.setAttribute("customerobj", temp);
			return "redirect:/reqopenstudentpage?itemadded";
		}
	}

	@RequestMapping("/reqcartdetail")
	public String cartdetails(HttpSession session, Model m) {
		Customer customer = (Customer) session.getAttribute("customerobj");
		/*
		 * if (customer == null) { return "redirect:/home";
		 * 
		 * } else {
		 */
		List<Vw_Cust_Cart_Full_Details> lv = vcint.getListofCustCart(customer.getCustomerid());
		m.addAttribute("listoffulldetails", lv);
		m.addAttribute("msg", customer.getCart().getGrandtotoal());
		m.addAttribute("cartid", customer.getCart().getCartid());
		return "cartdetails";
	}

	@RequestMapping("/reqlogout")
	public String logout(HttpSession session) {
		session.setAttribute("customerobj", null);
		session.invalidate();
		return "redirect:/home";

	}

	@RequestMapping("/reqdeletfromcartitems")
	public String deletcartitem(@RequestParam("citemid") String cartitemid, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customerobj");
		/*
		 * if (customer == null) { return "redirect:/home";
		 * 
		 * } else {
		 * 
		 */ cartint.deletcartitem(cartitemid);

		List<Vw_Cust_Cart_Full_Details> lv = vcint.getListofCustCart(customer.getCustomerid());
		int total = 0;
		for (int i = 0; i < lv.size(); i++) {
			total += lv.get(i).getQuantity() * lv.get(i).getXpsprice();
			// m.addAttribute("msg",total);
		}
		customer.getCart().setGrandtotoal(total);
		crtint.updatecart(customer.getCart());
		return "redirect:reqcartdetail";
	}

	@RequestMapping("/reqdicreaseqnt")
	public String decreaseqnt(@RequestParam("citemid") String cid, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customerobj");
		/*
		 * if (customer == null) { return "redirect:/home";
		 * 
		 * } else {
		 */
		cartint.decreaseqnt(cid);
		List<Vw_Cust_Cart_Full_Details> lv = vcint.getListofCustCart(customer.getCustomerid());
		int total = 0;
		for (int i = 0; i < lv.size(); i++) {
			total += lv.get(i).getQuantity() * lv.get(i).getXpsprice();
		}
		customer.getCart().setGrandtotoal(total);
		crtint.updatecart(customer.getCart());

		return "redirect:/reqcartdetail";

	}

	@RequestMapping("/reqincreaseqnt")
	public String increaseqnt(@RequestParam("xpsid") String cid, HttpSession session) {
		Customer currentcustomer = (Customer) session.getAttribute("customerobj");
		/*
		 * if (currentcustomer == null) { return "redirect:/home"; } else {
		 */
		cartint.increaseqnt(cid);
		List<Vw_Cust_Cart_Full_Details> lv = vcint.getListofCustCart(currentcustomer.getCustomerid());
		int total = 0;
		for (int i = 0; i < lv.size(); i++) {
			total += lv.get(i).getQuantity() * lv.get(i).getXpsprice();
		}
		currentcustomer.getCart().setGrandtotoal(total);
		crtint.updatecart(currentcustomer.getCart());

		return "redirect:/reqcartdetail";

	}

	@RequestMapping("/reqchngpassword")
	public String changepsswrd(@RequestParam(value = ("passwordmismatch"), required = false) String passwordmismatch,
			Model m) {
		if (passwordmismatch != null) {
			m.addAttribute("msg", new Message("ERR", "PASSWORD MISMATCH"));
			return "editpassword";
		}
		return "editpassword";
	}

	@RequestMapping("/reqchngshipingadd")
	public String chngshippingadd(HttpSession session, Model m) {
		Customer currentcustomer = (Customer) session.getAttribute("customerobj");
		ShippingAddress sad = currentcustomer.getShippingAddress();
		m.addAttribute("shippinaddobj", sad);
		return "editshippingadd";
	}

	@RequestMapping("/reqchngbilingadd")
	public String chngbillingadd(HttpSession session, Model m) {
		Customer currentcustomer = (Customer) session.getAttribute("customerobj");
		BillingAddress ba = currentcustomer.getBillingAddress();
		m.addAttribute("billingaddobj", ba);
		return "editbillingadd";
	}

	@RequestMapping("/reqeditcustomer")
	public String chngcustomerinf(HttpSession session, Model m) {
		Customer currentcustomer = (Customer) session.getAttribute("customerobj");
		m.addAttribute("customer", currentcustomer);

		return "editcustomerinfo";
	}

	@RequestMapping("/reqmanageusers")
	public String getusersinfo(Model m, HttpSession session) {
		if (session.getAttribute("customerobj") == null) {
			return "redirect:/reqsignin";
		}
		List<UserDetails> ud = uint.getlistofuserdetails();
		m.addAttribute("listofUD", ud);
		return "userinfo";
	}

	@RequestMapping("/reqchngavilability")
	public String updaterole(@RequestParam("USERID") String usid, HttpSession session) {
		if (session.getAttribute("customerobj") == null) {
			return "redirect:/reqsignin";
		}
		UserDetails ud = uint.getbyUserID(usid);
		uint.changeavailability(ud);
		uint.updateUserDetails(ud);
		return "redirect:/reqopenadminpage?avilabity";

	}

	@RequestMapping("/reqforgottepassword")
	public String forgottepassword(@RequestParam(value = "USERNOTFOUND", required = false) String u, Model m) {
		if (u != null) {
			m.addAttribute("msg", new Message("ERR", "USER NOT FOUND"));
			return "passwardresetpage";

		}
		return "passwardresetpage";

	}

	@RequestMapping("/reqchangepassword")
	public String changepassword(@RequestParam("UI") String userid, Model m) {
		UserDetails ud = uint.getbyUserID(userid);
		if (ud == null) {
			return "redirect:/reqforgottepassword?USERNOTFOUND";
		} else {
			String password = ud.getPassword();
			Customer customer = cint.getcustomerbyuserID(userid);
			String subject = "FORGOTTEN PASSWORD :: AZshopping.com";
			String body = "Dear " + customer.getCustomername();
			body = body + "\n\nYour Request for forget password,As been reached\nYour Password  : " + password
					+ "\nUse this Password to login to our website";
			body = body + "\n\n\nRegards,\nTestSite Team\nDT - NIIT-KPHB";
			try {
				emailService.send(customer.getCustomeremailid(), subject, body);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "redirect:/reqsignin?passwordreset";
		}

	}

	@RequestMapping("/reqorderhistory")
	public String getlistoforders(HttpSession session, Model m) {
		Customer currentcustomer = (Customer) session.getAttribute("customerobj");
		/*
		 * if (currentcustomer == null) { return "redirect:/home"; }
		 */
		String custid = currentcustomer.getCustomerid();
		List<Orders> lo = oint.getCustomerOrders(custid);
		m.addAttribute("lo", lo);
		return "orderspage";

	}

	@RequestMapping("/reqorderdetails")
	public String getorderdetails(@RequestParam("orderid") String orderid, HttpSession session, Model m) {
		Customer currentcustomer = (Customer) session.getAttribute("customerobj");
		/*
		 * if (currentcustomer == null) { return "redirect:/home"; }
		 */
		List<OrderDetails> lod = oint.getOrderDetails(orderid);
		System.out.println(lod);
		m.addAttribute("lod", lod);
		return "orderdetailspage";
	}

	@RequestMapping("/reqsearch")
	public String searchproducts(@RequestParam("search") String product,Model m) {
		List<Product>p=pint.searchforproduct(product);
		  m.addAttribute("lp",p);
		return "searchpage";
	}

}
