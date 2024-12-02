package org.alura.literalura.Services;

import org.alura.literalura.Model.Dto.LibroByTituloDto;

import java.util.List;

public interface ILiterAluraService {
    public LibroByTituloDto getLibroByTitulo(String titulo);

    public List<LibroByTituloDto> getLibrosRegistrados();
}
