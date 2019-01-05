package pl.parser.nbp;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import pl.parser.nbp.helpers.XmlFilesPathsCollector;
import pl.parser.nbp.xmlParser.DOMParser;

class CalculateAllValuesTest {

  XmlFilesPathsCollector xmlFilesPathsCollector = new XmlFilesPathsCollector();
  DOMParser domParser = new DOMParser();

  @Test
  void shouldCalculateMeanAndStandardDeviation() {
    //given
    LocalDate startDate = LocalDate.parse("2013-01-28");
    LocalDate endDate = LocalDate.parse("2013-01-31");
    String currency = "EUR";
    CalculateAllValues calculateAllValues = new CalculateAllValues(xmlFilesPathsCollector, domParser);
    calculateAllValues.calculateMeanAndStandardDeviation(startDate, endDate, currency);
  }
}