package org.java.fotoalbum.demo.api.controller;

import java.util.List;

import org.java.fotoalbum.demo.pojo.Foto;
import org.java.fotoalbum.demo.serv.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ApiController {
	@Autowired
	private FotoService fotoService;

	@GetMapping("/foto")
	public ResponseEntity<List<Foto>> index() {

		List<Foto> foto = fotoService.findByVisibleTrue();

		if (foto.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(foto, HttpStatus.OK);
		}
	}

	@GetMapping("/foto/filter")
	public ResponseEntity<List<Foto>> apiFilterByTitle(@RequestParam(required = false) String title) {

		List<Foto> foto = fotoService.findByTitleContainingAndVisibleTrue(title);

		if (foto.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(foto, HttpStatus.OK);
		}
	}

}
