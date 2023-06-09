package org.java.fotoalbum.demo.auth.repo;

import org.java.fotoalbum.demo.auth.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
