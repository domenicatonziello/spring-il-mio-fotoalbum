package org.java.fotoalbum.demo.auth.repo;


import java.util.Optional;

import org.java.fotoalbum.demo.auth.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
	public Optional<User> findByUsername(String username);

}
