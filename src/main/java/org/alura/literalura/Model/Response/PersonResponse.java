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

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getAnioDeNacimento() {
        return AnioDeNacimento;
    }

    public void setAnioDeNacimento(int anioDeNacimento) {
        AnioDeNacimento = anioDeNacimento;
    }

    public int getAnioDeFallecimiento() {
        return AnioDeFallecimiento;
    }

    public void setAnioDeFallecimiento(int anioDeFallecimiento) {
        AnioDeFallecimiento = anioDeFallecimiento;
    }
}
