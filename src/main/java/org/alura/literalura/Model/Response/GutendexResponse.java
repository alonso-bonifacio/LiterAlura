package org.alura.literalura.Model.Response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GutendexResponse {
    @JsonAlias("results")
    public BookResponse[] resultado;

    public BookResponse[] getResultado() {
        return resultado;
    }

    public void setResultado(BookResponse[] resultado) {
        this.resultado = resultado;
    }
}

