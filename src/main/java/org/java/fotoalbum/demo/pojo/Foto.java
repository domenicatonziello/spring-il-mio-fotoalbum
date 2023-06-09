package org.java.fotoalbum.demo.pojo;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Foto {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Questo campo è obbligatorio")
	@Size(min = 2, max = 50, message = "Il titolo deve avere 2-50 caratteri")
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@NotBlank(message = "Questo campo è obbligatorio")
	private String url;
	
	@NotNull(message = "Questo campo è obbligatorio")
	private boolean visible;
	
	@ManyToMany
	@JsonManagedReference
	private List<Category> categories;
	
	public Foto() {}
	public Foto(String title, String description, String url, boolean visible) {
		setTitle(title);
		setDescription(description);
		setUrl(url);
		setVisible(visible);
	}
	public Foto(String title, String description, String url, Boolean visible, Category... categories) {
		this(title, description, url, visible);
		setCategories(categories);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public void setCategories(Category[] categories) {
		setCategories(Arrays.asList(categories));
	}
	public void removeCategory(Category category) {
		getCategories().remove(category);		
	}
	
	@Override
	public String toString() {
		return "[" + getId() + "] " 
				+ "Titolo: " + getTitle() 
				+ "\nDescrizione: " + getDescription() 
				+ "\nUrl: " + getUrl()
				+ "\nVisibile: " + (isVisible() ? "Sì" : "No");
	}
	

}
