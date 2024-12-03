package org.alura.literalura.Repository;

import org.alura.literalura.Model.Entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ILibroRepository extends JpaRepository<Libro, Long> {

    Optional<Libro> getFirstByTituloContainsIgnoreCase(String titulo);
}
