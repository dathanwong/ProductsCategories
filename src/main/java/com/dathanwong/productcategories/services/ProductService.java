package com.dathanwong.productcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dathanwong.productcategories.models.Product;
import com.dathanwong.productcategories.repositories.ProductRepository;

@Service
public class ProductService{

	private final ProductRepository repo;
	
	public ProductService(ProductRepository repo) {
		this.repo = repo;
	}
	
	public List<Product> findAll(){
		return repo.findAll();
	}
	
	public void create(Product p) {
		this.repo.save(p);
	}
	
	public Product findById(Long id) {
		Optional<Product> product = repo.findById(id);
		if(product.isPresent()) {
			return product.get();
		}else {
			return null;
		}
	}
	
	public void update(Product p) {
		this.repo.save(p);
		return;
	}
}
