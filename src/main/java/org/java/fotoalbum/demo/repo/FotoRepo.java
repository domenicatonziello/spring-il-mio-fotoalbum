package org.java.fotoalbum.demo.repo;

import java.util.List;

import org.java.fotoalbum.demo.pojo.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoRepo extends JpaRepository<Foto, Integer> {
	public List<Foto> findByTitleContaining(String title);
}
