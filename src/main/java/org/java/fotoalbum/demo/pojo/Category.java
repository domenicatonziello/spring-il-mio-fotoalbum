package org.java.fotoalbum.demo.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "Il nome è obbligatorio")
	@Size(min = 3, max = 25, message = "Il nome deve avere 3-25 caratteri")
	private String name;

	@ManyToMany(mappedBy = "categories")
	@JsonBackReference
	private List<Foto> photos;

	public Category() {}

	public Category(String name) {
		setName(name);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Foto> getPhotos() {
		return photos;
	}
	public void setPhotos(List<Foto> photos) {
		this.photos = photos;
	}
	
	@Override
	public String toString() {
		return "Categoria: " + getName();
	}
	

}
