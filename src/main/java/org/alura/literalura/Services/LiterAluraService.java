package org.alura.literalura.Services;

import org.alura.literalura.Api.IApiGutendex;
import org.alura.literalura.Model.Dto.AutoresDto;
import org.alura.literalura.Model.Dto.LibroByTituloDto;
import org.alura.literalura.Model.Entity.Autor;
import org.alura.literalura.Model.Entity.Libro;
import org.alura.literalura.Repository.IAutorRepository;
import org.alura.literalura.Repository.ILibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LiterAluraService implements ILiterAluraService {

    private final IAutorRepository _autorRepository;
    private final ILibroRepository _libroRepository;
    private final IApiGutendex _apiGutendex;

    public LiterAluraService(IAutorRepository autorRepository, ILibroRepository libroRepository, IApiGutendex apiGutendex) {
        _autorRepository = autorRepository;
        _libroRepository = libroRepository;
        _apiGutendex = apiGutendex;
    }

    @Override
    public Optional<LibroByTituloDto> getLibroByTitulo(String titulo) {

        var libro = _libroRepository.getFirstByTituloContainsIgnoreCase(titulo);
        if (libro.isPresent()) {
            return Optional.of(new LibroByTituloDto(libro.get()));
        }

        var response = _apiGutendex.convert(titulo).resultado;
        if (response.isEmpty()) {
            return Optional.empty();
        }
        var res = response.get(0);
        var autor = new Autor();
        autor.setNombre(res.Autores.get(0).Nombre);
        autor.setAnioNacimiento(res.Autores.get(0).AnioDeNacimento);
        autor.setAnioFallecimiento(res.Autores.get(0).AnioDeFallecimiento);
        _autorRepository.save(autor);

        var libroNuevo = new Libro();
        libroNuevo.setTitulo(res.Titulo);
        libroNuevo.setAutor(autor);
        libroNuevo.setIdioma(res.Idiomas.get(0));
        libroNuevo.setNumeroDescargas(res.NumeroDeDescargas);
        _libroRepository.save(libroNuevo);
        return Optional.of(new LibroByTituloDto(libroNuevo));
    }

    @Override
    public List<LibroByTituloDto> getLibrosRegistrados() {
        var libros = _libroRepository.findAll();
        return libros.stream().map(LibroByTituloDto::new).toList();
    }

    @Override
    public List<AutoresDto> getAutoresRegistrados() {
        var autores = _autorRepository.findAll();
        return autores.stream().map(AutoresDto::new).toList();
    }
}
