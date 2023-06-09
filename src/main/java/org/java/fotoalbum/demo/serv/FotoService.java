package org.java.fotoalbum.demo.serv;

import java.util.List;
import java.util.Optional;

import org.java.fotoalbum.demo.pojo.Foto;
import org.java.fotoalbum.demo.repo.FotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FotoService {
	
	@Autowired
	private FotoRepo fotoRepo;
	
	public List<Foto> findAll() {
		
		return fotoRepo.findAll();
	}
	public Foto save(Foto foto) {
		
		return fotoRepo.save(foto);
	}
	public Optional<Foto> findById(int id) {
		
		return fotoRepo.findById(id);
	}
	
	public List<Foto> findByTitleContaining(String title){

		return fotoRepo.findByTitleContaining(title);

	}
	
	public void deleteById(int id) {

		fotoRepo.deleteById(id);

	}

}
