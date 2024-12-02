package org.alura.literalura.View;

public interface IViewConverter {
    void printMenu();

    int getValueOption();

    void processConvert(int numberOption, String[] params);

    void printExit();

    String[] getParams(int numberOption);
}
