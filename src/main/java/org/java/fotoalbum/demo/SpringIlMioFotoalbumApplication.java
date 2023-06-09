package org.java.fotoalbum.demo;

import org.java.fotoalbum.demo.auth.pojo.Role;
import org.java.fotoalbum.demo.auth.pojo.User;
import org.java.fotoalbum.demo.auth.serv.RoleService;
import org.java.fotoalbum.demo.auth.serv.UserService;
import org.java.fotoalbum.demo.pojo.Foto;
import org.java.fotoalbum.demo.serv.FotoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner{
	
	@Autowired
	public FotoService fotoServ;
	
	@Autowired
	public RoleService roleServ;
	
	@Autowired
	public UserService userServ;

	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		FOTO --------------------------------------------------------------------------------------------------------
		
		Foto foto1 = new Foto("Prima foto", "Foto illuminata", "https://picsum.photos/100/100", false);
		Foto foto2 = new Foto("Seconda foto", "Foto bianco e nero", "https://picsum.photos/100/100?grayscale", false);
		Foto foto3 = new Foto("Terza foto", "Immagine sfocata", "https://picsum.photos/100/100/?blur", false);
		
		fotoServ.save(foto1);
		fotoServ.save(foto2);
		fotoServ.save(foto3);
		
//		UTENTI -------------------------------------------------------------------------------------------------------
		Role roleAdmin = new Role("ADMIN");
		roleServ.save(roleAdmin);
		final String pass = new BCryptPasswordEncoder().encode("pass");
		User utente = new User("admin", pass, roleAdmin);
		userServ.save(utente);
		
	}

}
