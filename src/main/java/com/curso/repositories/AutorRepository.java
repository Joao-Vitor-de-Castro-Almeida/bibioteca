package com.curso.repositories;

import com.curso.domains.Autor;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

@Entity
public interface AutorRepository extends JpaRepository<Autor, Integer> {

}
