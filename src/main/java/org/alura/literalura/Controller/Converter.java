package org.alura.literalura.Controller;

import org.alura.literalura.Services.ILiterAluraService;
import org.alura.literalura.Shared.Constants.Option;
import org.springframework.stereotype.Component;

@Component
public class Converter implements IConverter {

    private final ILiterAluraService _literAluraService;

    public Converter(ILiterAluraService literAluraService) {
        _literAluraService = literAluraService;
    }

    public String ResolverOperation(int numberOperation, String[] params) {
        return switch (numberOperation) {
            case Option.LIBRO_POR_TITULO -> OperationLibroPorTitulo(params[0]);
            case Option.LIBROS_REGISTRADOS -> OperationListarLibrosRegistrados();
            default -> "";
        };
    }

    private String OperationListarLibrosRegistrados() {
        var response = _literAluraService.getLibrosRegistrados();
        var libros = new StringBuilder();
        response.forEach(libro -> libros.append("----- LIBRO -----\n")
                .append("Titulo: ").append(libro.titulo()).append("\n")
                .append("Autor: ").append(libro.autor()).append("\n")
                .append("Idioma: ").append(libro.idioma()).append("\n")
                .append("Numero de descargas: ").append(libro.numeroDescargas()).append("\n")
                .append("------------------\n\n"));
        return libros.toString();
    }

    private String OperationLibroPorTitulo(String titulo) {
        var response = _literAluraService.getLibroByTitulo(titulo);
        return "----- LIBRO -----\n" +
                "Titulo: " + response.titulo() + "\n" +
                "Autor: " + response.autor() + "\n" +
                "Idioma: " + response.idioma() + "\n" +
                "Numero de descargas: " + response.numeroDescargas() + "\n" +
                "------------------";
    }
}
