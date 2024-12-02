package org.alura.literalura.Model.Response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookResponse {
    @JsonAlias("title")
    public String Titulo;
    @JsonAlias("authors")
    public List<PersonResponse> Autores;
    @JsonAlias("languages")
    public List<String> Idiomas;
    @JsonAlias("download_count")
    public int NumeroDeDescargas;
}
