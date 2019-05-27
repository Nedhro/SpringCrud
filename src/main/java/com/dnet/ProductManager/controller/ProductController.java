package com.dnet.ProductManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dnet.ProductManager.entity.Product;
import com.dnet.ProductManager.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Product> listProducts=service.listAll();
		model.addAttribute("listProducts",listProducts);
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewProductForm(Model model) {
		Product product=new Product();
		model.addAttribute("product",product);
		
		return "newProduct";
		
	}
	
	@RequestMapping(value="/save", method =RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		service.save(product);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductForm(@PathVariable(name="id") Long id) {
		ModelAndView mav=new ModelAndView("editProduct");
		
		Product product =service.get(id);
		mav.addObject("product",product);
		
		return mav;
		
	}
	
	

}
