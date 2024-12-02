package org.alura.literalura.Repository;

import org.alura.literalura.Model.Entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IAutorRepository extends JpaRepository<Autor, Long> {
}
