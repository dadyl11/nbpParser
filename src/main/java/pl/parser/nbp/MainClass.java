package pl.parser.nbp;

import java.time.LocalDate;
import pl.parser.nbp.filesPathsCollectors.XmlFilesPathsCollector;
import pl.parser.nbp.helpers.InputValidator;
import pl.parser.nbp.helpers.PrintValues;
import pl.parser.nbp.xmlParser.DOMParser;

public class MainClass {

  public static void main(String[] args) {

    String currency = args[0];
    LocalDate startDate = LocalDate.parse(args[1]);
    LocalDate endDate = LocalDate.parse(args[2]);

    DOMParser domParser = new DOMParser();
    XmlFilesPathsCollector xmlFilesPathsCollector = new XmlFilesPathsCollector();
    BuySellRatesCalculator buySellRatesCalculator = new BuySellRatesCalculator(xmlFilesPathsCollector, domParser);
    InputValidator inputValidator = new InputValidator();
    PrintValues printValues = new PrintValues();

    inputValidator.validateCurrency(currency);
    inputValidator.validateDates(startDate, endDate);
    printValues.printFormatedInputs(buySellRatesCalculator.calculateMeanAndStandardDeviation(startDate, endDate, currency));
  }

}


