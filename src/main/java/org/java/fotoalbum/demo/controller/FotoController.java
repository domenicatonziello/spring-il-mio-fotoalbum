package org.java.fotoalbum.demo.controller;

import java.util.List;

import org.java.fotoalbum.demo.pojo.Foto;
import org.java.fotoalbum.demo.serv.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class FotoController {
	
	@Autowired
	public FotoService fotoServ;
	
	@GetMapping("/")
	public String index(Model model) {
		
		List<Foto> foto = fotoServ.findAll();
		model.addAttribute("foto", foto);
		
		return "foto/foto-index";
	}

}
