package org.alura.literalura.Model.Response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonResponse {
    @JsonAlias("name")
    public String Nombre;
    @JsonAlias("birth_year")
    public int AnioDeNacimento;
    @JsonAlias("death_year")
    public int AnioDeFallecimiento;
}
