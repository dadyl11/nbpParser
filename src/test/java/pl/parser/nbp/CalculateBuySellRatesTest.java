package pl.parser.nbp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import pl.parser.nbp.filesPathsCollectors.XmlFilesPathsCollector;
import pl.parser.nbp.xmlParser.DOMParser;

class CalculateBuySellRatesTest {

  XmlFilesPathsCollector xmlFilesPathsCollector = new XmlFilesPathsCollector();
  DOMParser domParser = new DOMParser();

  @Test
  void shouldCalculateMeanAndStandardDeviation() {
    //given
    LocalDate startDate = LocalDate.parse("2013-01-28");
    LocalDate endDate = LocalDate.parse("2013-01-31");
    String currency = "EUR";
    double[] expectedResults = {4.150525, 0.012477053939131788};
    CalculateBuySellRates calculateBuySellRates = new CalculateBuySellRates(xmlFilesPathsCollector, domParser);

    //when
    double[] actualMeanAndStandardDeviation = calculateBuySellRates.calculateMeanAndStandardDeviation(startDate, endDate, currency);

    //then
    System.out.println(actualMeanAndStandardDeviation[1]);
    assertThat(actualMeanAndStandardDeviation, is(expectedResults));
  }
}