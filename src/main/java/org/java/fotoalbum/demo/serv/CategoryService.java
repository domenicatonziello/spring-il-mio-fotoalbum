package org.java.fotoalbum.demo.serv;

import java.util.List;
import java.util.Optional;

import org.java.fotoalbum.demo.pojo.Category;
import org.java.fotoalbum.demo.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	public List<Category> findAll() {

		return categoryRepo.findAll();
	}

	public Category save(Category category) {

		return categoryRepo.save(category);
	}

	public Optional<Category> findById(int id) {

		return categoryRepo.findById(id);
	}

	public void deleteById(int id) {

		categoryRepo.deleteById(id);
	}

}
