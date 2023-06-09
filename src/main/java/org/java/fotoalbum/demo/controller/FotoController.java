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
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;


@Controller
public class FotoController {
	
	@Autowired
	public FotoService fotoServ;
	
	@Autowired
	private CategoryService categoryServ;
	
//	INDEX --------------------------------------------------------------------------------------
	@GetMapping("/")
	public String index(Model model) {
		
		List<Foto> foto = fotoServ.findAll();
		model.addAttribute("foto", foto);
		
		return "foto/foto-index";
	}
	
//	FILTRO --------------------------------------------------------------------------------------
	@PostMapping("/")
	public String filterPhoto(Model model, @RequestParam(required = false) String title) {

		List<Foto> fotoList = fotoServ.findByTitleContaining(title);
		model.addAttribute("foto", fotoList);
		model.addAttribute("title", title);

		return "foto/foto-index";
	}
//	SHOW --------------------------------------------------------------------------------------
	@GetMapping("/foto/{id}")
	public String show(@PathVariable("id") Integer id, Model model) {

		Optional<Foto> fotoOpt = fotoServ.findById(id);

		Foto foto = fotoOpt.get();
		List<Category> categories = foto.getCategories();

		model.addAttribute("foto", foto);
		model.addAttribute("categories", categories);

		return "foto/foto-show";
	}
	
//	CREATE --------------------------------------------------------------------------------------
	@GetMapping("/admin/foto/create")
	public String create(Model model) {
		List<Category> categories = categoryServ.findAll();

		model.addAttribute("photo", new Foto());
		model.addAttribute("categories", categories);

		return "foto/foto-create";
	}

	@PostMapping("/admin/foto/store")
	public String store(@Valid @ModelAttribute Foto foto, BindingResult bindingResult, Model model){

		if (bindingResult.hasErrors()) {

			model.addAttribute("foto", foto);
			model.addAttribute("errors", bindingResult);

			return "foto/foto-create";
		}

		fotoServ.save(foto);

		return "redirect:/";
	}

//	EDIT ----------------------------------------------------------------------------------------
	@GetMapping("/admin/foto/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		List<Category> categories = categoryServ.findAll();

		Optional<Foto> fotoOpt = fotoServ.findById(id);
		Foto foto = fotoOpt.get();

		model.addAttribute("foto", foto);
		model.addAttribute("categories", categories);

		return "foto/foto-edit";
	}

	@PostMapping("/admin/foto/update/{id}")
	public String update(@PathVariable("id") int id, @Valid @ModelAttribute Foto foto, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {

			model.addAttribute("foto", foto);
			model.addAttribute("errors", bindingResult);

			return "photo/edit";
		}

		fotoServ.save(foto);

		return "redirect:/";
	}
//	DELETE --------------------------------------------------------------------------------------
	@GetMapping("/admin/foto/delete/{id}")
	public String delete(@PathVariable("id") int id) {

//		Optional<Foto> fotoOpt = fotoServ.findById(id);
//		Foto foto= fotoOpt.get();

		fotoServ.deleteById(id);

		return "redirect:/";
	}



}
