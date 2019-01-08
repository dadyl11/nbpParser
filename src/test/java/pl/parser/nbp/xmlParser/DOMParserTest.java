package pl.parser.nbp.xmlParser;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

class DOMParserTest {

  @Test
  void shouldReturnCorrectBuyRate() {
    //given
    String path = "http://www.nbp.pl/kursy/xml/c025z100205.xml";
    String currency = "EUR";
    String buyRate = "4,0128";

    //when
    String[] test = new DOMParser().getBuyAndSellRatesFromXmlFile(path, currency);

    //then
    assertThat(test[0], is(buyRate));
  }

  @Test
  void shouldReturnCorrectSellRate() {
    //given
    String path = "http://www.nbp.pl/kursy/xml/c025z100205.xml";
    String currency = "EUR";
    String buyRate = "4,0938";

    //when
    String[] test = new DOMParser().getBuyAndSellRatesFromXmlFile(path, currency);

    //then
    assertThat(test[1], is(buyRate));
  }
}