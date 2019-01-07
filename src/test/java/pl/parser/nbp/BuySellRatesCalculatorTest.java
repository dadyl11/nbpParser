package pl.parser.nbp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.time.LocalDate;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import pl.parser.nbp.filesPathsCollectors.XmlFilesPathsCollector;
import pl.parser.nbp.testParameters.InputsForCalculateBuySell;
import pl.parser.nbp.xmlParser.DOMParser;

class BuySellRatesCalculatorTest {

  private XmlFilesPathsCollector xmlFilesPathsCollector = new XmlFilesPathsCollector();
  private DOMParser domParser = new DOMParser();

  @ParameterizedTest
  @ArgumentsSource(InputsForCalculateBuySell.class)
  void shouldCalculateMeanAndStandardDeviation(String currency, String startDate, String endDate, double[] expectedResults) {
    //given
    BuySellRatesCalculator buySellRatesCalculator = new BuySellRatesCalculator(xmlFilesPathsCollector, domParser);

    //when
    double[] actualMeanAndStandardDeviation = buySellRatesCalculator
        .calculateMeanAndStandardDeviation(LocalDate.parse(startDate), LocalDate.parse(endDate), currency);

    //then
    assertThat(actualMeanAndStandardDeviation, is(expectedResults));
  }
}