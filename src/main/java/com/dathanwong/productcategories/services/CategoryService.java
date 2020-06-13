package com.dathanwong.productcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dathanwong.productcategories.models.Category;
import com.dathanwong.productcategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	private final CategoryRepository repo;
	
	public CategoryService(CategoryRepository repo) {
		this.repo = repo;
	}
	
	public List<Category> findAll(){
		return repo.findAll();
	}
	
	public void create(Category c) {
		repo.save(c);
		return;
	}
	
	public Category findById(Long id) {
		Optional<Category> c = repo.findById(id);
		if(c.isPresent()) {
			return c.get();
		}else {
			return null;
		}
	}
	
	public void update(Category c) {
		repo.save(c);
	}
	
}
