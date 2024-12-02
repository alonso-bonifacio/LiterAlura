package org.alura.literalura.View;

import org.alura.literalura.Controller.IConverter;
import org.alura.literalura.Shared.Constants.Menu;
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

    public void processConvert(int numberOption, String[] params) {
        if (numberOption != -1) {
            var result = _converter.ResolverOperation(numberOption, params);
            System.out.println(result);
            System.out.println();
        }
    }

    public String[] getParams(int numberOption) {
        String[] params = new String[1];
        System.out.println("Ingrese el nombre del libro");
        params[0] = sc.nextLine();
        return params;
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
