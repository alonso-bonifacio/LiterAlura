package org.alura.literalura.View;

public class Main {

    private IViewConverter _viewConverter;

    public Main(IViewConverter viewConverter) {
        _viewConverter = viewConverter;
    }

    public void Exec() {
        while (true) {
            _viewConverter.printMenu();

            int numberOption;
            do {
                numberOption = _viewConverter.getValueOption();
            } while (numberOption == -1);

            if (numberOption == 0) {
                break;
            }

            var valueConvert = _viewConverter.getParams(numberOption);
            _viewConverter.processConvert(numberOption, valueConvert);
        }
        _viewConverter.printExit();
    }


}
