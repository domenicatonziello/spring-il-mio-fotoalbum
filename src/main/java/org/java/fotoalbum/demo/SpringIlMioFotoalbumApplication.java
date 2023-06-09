package org.java.fotoalbum.demo;

import org.java.fotoalbum.demo.pojo.Foto;
import org.java.fotoalbum.demo.serv.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner{
	
	@Autowired
	public FotoService fotoServ;

	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Foto foto1 = new Foto("Prima foto", "Foto illuminata", "https://picsum.photos/200/300", false);
		Foto foto2 = new Foto("Seconda foto", "Foto bianco e nero", "https://picsum.photos/200/300", false);
		Foto foto3 = new Foto("Terza foto", "Nessuna descrizione", "https://picsum.photos/200/300", false);
		
		fotoServ.save(foto1);
		fotoServ.save(foto2);
		fotoServ.save(foto3);
		
	}

}
