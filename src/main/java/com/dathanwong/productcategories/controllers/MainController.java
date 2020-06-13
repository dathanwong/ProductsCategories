package com.dathanwong.productcategories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dathanwong.productcategories.models.Category;
import com.dathanwong.productcategories.models.Product;
import com.dathanwong.productcategories.services.CategoryService;
import com.dathanwong.productcategories.services.ProductService;

@Controller
public class MainController {
	
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public MainController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	@RequestMapping("/products/new")
	public String newProductPage(@ModelAttribute("product") Product product) {
		return "newProductPage.jsp";
	}
	
	@PostMapping("/products/new")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "newProductPage.jsp";
		}else {
			productService.create(product);
			return "redirect:/products/" + product.getId();
		}
	}
	
	@RequestMapping("/products/{id}")
	public String productPage(@PathVariable("id") Long id, Model model) {
		model.addAttribute("product", productService.findById(id));
		model.addAttribute("categories", categoryService.findAll());
		return "productPage.jsp";
	}
	
	@RequestMapping("/categories/new")
	public String newCategoryPage(@ModelAttribute("category") Category category) {
		return "newCategoryPage.jsp";
	}
	
	@PostMapping("/categories/new")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "newCategoryPage.jsp";
		}else {
			categoryService.create(category);
			return "redirect:/categories/" + category.getId();
		}
	}
	
	@PostMapping("/product/{id}/category/add")
	public String addCategory(@RequestParam("category") Long categoryId, @PathVariable("id") Long productId) {
		Product product = productService.findById(productId);
		product.addCategory(categoryService.findById(categoryId));
		productService.update(product);
		return "redirect:/products/" + product.getId();
	}
	
	@RequestMapping("/categories/{id}")
	public String showCategoryPage(@PathVariable("id") Long id, Model model) {
		model.addAttribute("category", categoryService.findById(id));
		model.addAttribute("products", productService.findAll());
		return "categoryPage.jsp";
	}
	
	@PostMapping("/categories/{id}/product/add")
	public String addProduct(@PathVariable("id") Long categoryId, @RequestParam("product") Long productId) {
		Category category = categoryService.findById(categoryId);
		category.addProduct(productService.findById(productId));
		categoryService.update(category);
		return "redirect:/categories/"+category.getId();
	}
}
