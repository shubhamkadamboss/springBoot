package com.example.demo.controller;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.CompanyInt;
import com.example.demo.model.Company;

@Controller
@SessionAttributes({ "cid", "name", "email" })
public class CompanyController {
	@Autowired
	CompanyInt impl;
	
	String pr;

	@GetMapping("companylogin")
	public String compLogin() 
	{
		return "companylogin";
	}

	@PostMapping("companyview")
	public ModelAndView custDetails(@RequestParam("cid") String cid, @RequestParam("name") String name,
			@RequestParam("email") String email, @ModelAttribute Company comp) 
	{
		ModelAndView mv = new ModelAndView();
		
		impl.save(comp);
		//Optional<Product> optionalProduct
		Optional<Company> optionalCompany;
		
		//Searching by company id
		optionalCompany = impl.findById(Integer.parseInt(cid));
		comp= optionalCompany.get();
		
		//getting data from database and print it
		System.out.println("The id is:"+comp.getCid());
		System.out.println("The name is :"+comp.getName());
		System.out.println("Email is:"+comp.getEmail());
		
		//sending data to next jsp page i.e CompanyView
		mv.addObject("cid", comp.getCid());
		mv.addObject("name", comp.getName());
		mv.addObject("email", comp.getEmail());
		
		List<String> list=new ArrayList<String>();
		list=(List)impl.findAll();
		mv.addObject("newdata", list);
		
		//itr.forEach((p)->{ pr=p.getCid()+" "+p.getName()+" "+p.getEmail(); System.out.println(pr);mv.addObject("data",pr); });
		
		mv.setViewName("CompanyView");
	
		return mv;
	}

	@GetMapping("companysessionview")
	public String compSession() {
		return "CompanySessionView";
	}
}
