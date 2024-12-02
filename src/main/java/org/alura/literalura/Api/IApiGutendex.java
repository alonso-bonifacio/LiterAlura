package org.alura.literalura.Api;

import org.alura.literalura.Model.Response.GutendexResponse;

public interface IApiGutendex {
    GutendexResponse convert(String search);
}
