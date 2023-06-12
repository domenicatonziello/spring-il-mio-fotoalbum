package org.java.fotoalbum.demo.repo;

import org.java.fotoalbum.demo.pojo.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Integer>{

}
