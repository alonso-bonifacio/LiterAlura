package org.alura.literalura;

import org.alura.literalura.View.IViewConverter;
import org.alura.literalura.View.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

    private final IViewConverter _viewConverter;

    public LiterAluraApplication(IViewConverter _viewConverter) {
        this._viewConverter = _viewConverter;
    }

    public static void main(String[] args) {
        SpringApplication.run(LiterAluraApplication.class, args);
    }

    @Override
    public void run(String... args) {
        var project = new Main(_viewConverter);
        project.Exec();
    }
}
