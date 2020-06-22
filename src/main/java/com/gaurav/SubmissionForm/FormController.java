package com.gaurav.SubmissionForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {
	@Autowired
	CustomerRepo repo;
	
	@RequestMapping("/")
	public String details() {
		return "company";
	}
	
	@RequestMapping("details")
	public String details(Customers customers) {
		repo.save(customers);
		return "company";
	}
	
	@RequestMapping("getdetails")
	public String getdetails(Customers customers) {
		return "viewcustomer";
	}
	
	@GetMapping("company")
	public String company() {
		return "company";
	}
	
//	@PostMapping("getdetails")
//	public String details(
//			@RequestParam("cid") String cid,
//			@RequestParam("cname") String cname,
//			@RequestParam("cemail") String cemail,
//			ModelMap mm
//			) {
//		mm.put("cid", cid);
//		mm.put("cname", cname);
//		mm.put("cemail", cemail);
//		return "viewcustomer";
//	}
	
	@PostMapping("getdetails")
	public ModelAndView getdetails(@RequestParam int cid){
		ModelAndView mv = new ModelAndView("retrieve");
		Customers customer = repo.findById(cid).orElse(new Customers(cid, "Invalid Customer Id", "Try Again with Valid Id"));
		mv.addObject(customer);
		return mv;
	}
	
//	@RequestMapping("customers")
//	@ResponseBody
//	public String getCustomers() {
//		return repo.findAll().toString();
//	}
//	
//	@RequestMapping("customers/{cid}")
//	@ResponseBody
//	public String getCustomersById(@PathVariable("cid") int cid) {
//		return repo.findById(cid).toString();
//	}
	
	@RequestMapping("customers")
	@ResponseBody
	public String getCustomers() {
		return repo.findAll().toString();
	}
	
	@RequestMapping("customers/{cid}")
	@ResponseBody
	public String getCustomersById(@PathVariable("cid") int cid) {
		return repo.findById(cid).toString();
	}
	
	@PostMapping("customers")
	public Customers getCustomersC(@RequestBody Customers customers) {
		repo.save(customers);
		return customers;
	}
	
	@DeleteMapping("customers/{cid}")
	public Customers getCustomersD(@PathVariable("cid") int cid) {
		Customers cust = repo.getOne(cid);
		repo.delete(cust);
		return cust;
	}
	
	@PutMapping(path="customers", consumes= {"application/text"})
	public Customers getCustomersD(@RequestBody Customers cust) {
		repo.save(cust);
		return cust;
	}
}