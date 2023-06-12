package org.java.fotoalbum.demo.controller;

import java.util.List;
import java.util.Optional;

import org.java.fotoalbum.demo.pojo.Category;
import org.java.fotoalbum.demo.pojo.Foto;
import org.java.fotoalbum.demo.serv.CategoryService;
import org.java.fotoalbum.demo.serv.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryServ;

	@Autowired
	private FotoService fotoServ;
	
	@GetMapping
	public String index(Model model) {
		List<Category> categories = categoryServ.findAll();

		model.addAttribute("categories", categories);

		return "category/category-index";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("category", new Category());

		return "category/category-create";
	}

	@PostMapping("/store")
	public String store(@Valid @ModelAttribute Category category, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {

			model.addAttribute("category", category);
			model.addAttribute("errors", bindingResult);

			return "category/category-create";
		}

		categoryServ.save(category);

		return "redirect:/categories";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {

		Optional<Category> categoryOpt = categoryServ.findById(id);
		Category category = categoryOpt.get();

		for (Foto f : fotoServ.findAll()) {
			f.removeCategory(category);
			fotoServ.save(f);
		}

		categoryServ.deleteById(id);

		return "redirect:/categories";
	}
}
