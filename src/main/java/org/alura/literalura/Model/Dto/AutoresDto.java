package org.alura.literalura.Model.Dto;

import org.alura.literalura.Model.Entity.Autor;
import org.alura.literalura.Model.Entity.Libro;

public record AutoresDto(String nombre, int anioNacimiento, int anioFallecimiento, String[] libros) {
    public AutoresDto(Autor autor) {
        this(autor.getNombre(),
                autor.getAnioNacimiento(),
                autor.getAnioFallecimiento(),
                autor.getLibros().stream().map(Libro::getTitulo).toArray(String[]::new));
    }
}
