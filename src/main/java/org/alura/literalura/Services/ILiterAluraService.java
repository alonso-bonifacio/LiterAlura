package org.alura.literalura.Services;

import org.alura.literalura.Model.Dto.LibroByTituloDto;

import java.util.List;

public interface ILiterAluraService {
    LibroByTituloDto getLibroByTitulo(String titulo);

    List<LibroByTituloDto> getLibrosRegistrados();
}
