package org.alura.literalura.Model.Dto;

import org.alura.literalura.Model.Entity.Libro;

public record LibroByTituloDto(String titulo, String autor, String idioma, int numeroDescargas) {
    public LibroByTituloDto(Libro libro) {
        this(libro.getTitulo(), libro.getAutor().getNombre(), libro.getIdioma(), libro.getNumeroDescargas());
    }
}

