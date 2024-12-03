package org.alura.literalura.View;

public interface IViewConverter {
    void printMenu();

    int getValueOption();

    void processConvert(int numberOption, Object param);

    void printExit();

    Object getParams(int numberOption);
}
