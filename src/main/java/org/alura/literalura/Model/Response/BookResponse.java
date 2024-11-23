package org.alura.literalura.Model.Response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookResponse {
    @JsonAlias("title")
    public String Título;
    @JsonAlias("authors")
    public PersonResponse[] Autores;
    @JsonAlias("languages")
    public String[] Idiomas;
    @JsonAlias("download_count")
    public int NumeroDeDescargas;

    public String getTítulo() {
        return Título;
    }

    public void setTítulo(String título) {
        Título = título;
    }

    public PersonResponse[] getAutores() {
        return Autores;
    }

    public void setAutores(PersonResponse[] autores) {
        Autores = autores;
    }

    public String[] getIdiomas() {
        return Idiomas;
    }

    public void setIdiomas(String[] idiomas) {
        Idiomas = idiomas;
    }

    public int getNumeroDeDescargas() {
        return NumeroDeDescargas;
    }

    public void setNumeroDeDescargas(int numeroDeDescargas) {
        NumeroDeDescargas = numeroDeDescargas;
    }
}
