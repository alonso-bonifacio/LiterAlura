package org.alura.literalura.View;

public interface IViewConverter {
    public void printMenu();

    public int getValueOption();

    public void processConvert(int numberOption, String[] params);

    public void printExit();

    public String[] getParams(int numberOption);
}
