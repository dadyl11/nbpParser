package pl.parser.nbp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import pl.parser.nbp.helpers.XmlFilesPathsCollector;
import pl.parser.nbp.xmlParser.DOMParser;

public class MainClass {

  public static void main(String[] args) {

    String currency = "EUR";
    LocalDate startDate = LocalDate.parse("2013-01-28");
    LocalDate endDate = LocalDate.parse("2013-01-31");
//    String currency = args[0];
//    LocalDate startDate = LocalDate.parse(args[1]);
//    LocalDate endDate = LocalDate.parse(args[2]);

    DOMParser domParser = new DOMParser();
    XmlFilesPathsCollector xmlFilesPathsCollector = new XmlFilesPathsCollector();
    CalculateAllValues calculateAllValues = new CalculateAllValues(xmlFilesPathsCollector, domParser);

    calculateAllValues.calculateMeanAndStandardDeviation(startDate, endDate, currency);
  }

}


