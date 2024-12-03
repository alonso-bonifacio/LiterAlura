package org.alura.literalura.Controller;

import org.alura.literalura.Model.Dto.AutoresDto;
import org.alura.literalura.Model.Dto.LibroByTituloDto;
import org.alura.literalura.Services.ILiterAluraService;
import org.alura.literalura.Shared.Constants.Option;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Stream;

@Component
public class Converter implements IConverter {

    private final ILiterAluraService _literAluraService;

    public Converter(ILiterAluraService literAluraService) {
        _literAluraService = literAluraService;
    }

    public String ResolverOperation(int numberOperation, Object param) {
        return switch (numberOperation) {
            case Option.LIBRO_POR_TITULO -> OperationLibroPorTitulo((String) param);
            case Option.LIBROS_REGISTRADOS -> OperationListarLibrosRegistrados();
            case Option.AUTORES_REGISTRADOS -> OperationListarAutoresRegistrados();
            case Option.AUTORES_VIVOS_EN_ANIO -> OperationAutoresVivosEnAnio(Integer.parseInt((String) param));
            case Option.LIBROS_POR_IDIOMA -> OperationLibrosPorIdioma((String) param);
            default -> "";
        };
    }

    private String OperationLibrosPorIdioma(String param) {
        var response = _literAluraService.getLibrosRegistrados();
        var filtro = response.stream().filter(libro -> libro.idioma().equals(param)).toList();

        if (filtro.isEmpty()) {
            return "No hay libros en el idioma seleccionado.";
        }

        return generarEstructuraLibro(filtro.stream());
    }

    private String OperationAutoresVivosEnAnio(int param) {
        var response = _literAluraService.getAutoresRegistrados();
        var filtro = response.stream().filter(autor -> autor.anioNacimiento() <= param && autor.anioFallecimiento() > param).toList();

        if (filtro.isEmpty()) {
            return "No hay autores vivos en el año " + param;
        }

        return generarEstructuraAutor(filtro.stream());
    }

    private String OperationListarAutoresRegistrados() {
        var response = _literAluraService.getAutoresRegistrados();
        if (response.isEmpty()) {
            return "No hay autores registrados, busca un libro para agregar un autor";
        }
        return generarEstructuraAutor(response.stream());
    }

    private String OperationListarLibrosRegistrados() {
        var response = _literAluraService.getLibrosRegistrados();
        if (response.isEmpty()) {
            return "No hay libros registrados, busca un libro para agregarlo";
        }
        return generarEstructuraLibro(response.stream());
    }

    private String OperationLibroPorTitulo(String titulo) {
        var response = _literAluraService.getLibroByTitulo(titulo);

        if (response.isEmpty()) {
            return "Libro no encontrado";
        }

        var libro = response.get();
        return "----- LIBRO -----\n" +
                "Titulo: " + libro.titulo() + "\n" +
                "Autor: " + libro.autor() + "\n" +
                "Idioma: " + libro.idioma() + "\n" +
                "Numero de descargas: " + libro.numeroDescargas() + "\n" +
                "------------------";
    }

    private static String generarEstructuraLibro(Stream<LibroByTituloDto> filtro) {
        var libros = new StringBuilder();
        filtro.forEach(libro -> libros.append("----- LIBRO -----\n")
                .append("Titulo: ").append(libro.titulo()).append("\n")
                .append("Autor: ").append(libro.autor()).append("\n")
                .append("Idioma: ").append(libro.idioma()).append("\n")
                .append("Numero de descargas: ").append(libro.numeroDescargas()).append("\n")
                .append("------------------\n\n"));
        return libros.toString();
    }

    private static String generarEstructuraAutor(Stream<AutoresDto> filtro) {
        var autores = new StringBuilder();
        filtro.forEach(autor -> autores.append("Autor: ").append(autor.nombre()).append("\n")
                .append("Fecha de nacimiento: ").append(autor.anioNacimiento()).append("\n")
                .append("Fecha de fallecimiento: ").append(autor.anioFallecimiento()).append("\n")
                .append("Libros: ").append(Arrays.toString(autor.libros())).append("\n")
                .append("------------------\n\n"));
        return autores.toString();
    }
}
