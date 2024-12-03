package org.alura.literalura.Services;

import org.alura.literalura.Model.Dto.AutoresDto;
import org.alura.literalura.Model.Dto.LibroByTituloDto;

import java.util.List;
import java.util.Optional;

public interface ILiterAluraService {
    Optional<LibroByTituloDto> getLibroByTitulo(String titulo);

    List<LibroByTituloDto> getLibrosRegistrados();

    List<AutoresDto> getAutoresRegistrados();
}
