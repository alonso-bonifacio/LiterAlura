package org.alura.literalura.View;

import org.alura.literalura.Controller.IConverter;
import org.alura.literalura.Shared.Constants.Menu;
import org.alura.literalura.Shared.Constants.Option;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ViewConverter implements IViewConverter {
    public static Scanner sc = new Scanner(System.in);
    private final IConverter _converter;

    public ViewConverter(IConverter converter) {
        _converter = converter;
    }

    public void printMenu() {
        printDivider();
        System.out.println(Menu.TITLE);
        System.out.println();
        System.out.println(Menu.OPTIONS);
        System.out.println();
        printDivider();
    }

    public int getValueOption() {
        System.out.println(Menu.INPUT_OPTION);
        var valueOption = sc.nextLine();
        if (!isValidOption(valueOption)) {
            System.out.println(Menu.OPTIONS);
            return -1;
        }
        return Integer.parseInt(valueOption);
    }

    public void processConvert(int numberOption, Object param) {
        if (numberOption != -1) {
            var result = _converter.ResolverOperation(numberOption, param);
            System.out.println(result);
            System.out.println();
        }
    }

    public Object getParams(int numberOption) {
        switch (numberOption) {
            case Option.LIBRO_POR_TITULO -> {
                System.out.println("Ingrese el nombre del libro que desea buscar:");
                return sc.nextLine();
            }
            case Option.AUTORES_VIVOS_EN_ANIO -> {
                System.out.println("Ingrese el año vivo de autor(es) que desea buscar:");
                return sc.nextLine();
            }
            case Option.LIBROS_POR_IDIOMA -> {
                System.out.println("Ingrese el idioma para buscar los libros:");
                System.out.println("es- español");
                System.out.println("en- inglés");
                System.out.println("fr- portugués");
                System.out.println("pt- portugués");
                return sc.nextLine();
            }
            default -> {
                return "";
            }
        }
    }

    public void printExit() {
        System.out.println(Menu.EXIT_MESSAGE);
    }

    private static void printDivider() {
        System.out.println("******************************************");
        System.out.println();
    }

    private static boolean isValidOption(String valueOption) {
        if (valueOption.isBlank()) {
            return false;
        }

        try {
            var numberOption = Integer.parseInt(valueOption);
            if (numberOption < 0 || numberOption > 6) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }


}
