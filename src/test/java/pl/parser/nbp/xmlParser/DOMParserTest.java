package pl.parser.nbp.xmlParser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DOMParserTest {

  @Test
  void shouldParseXMLFile() {
    //given
    String path = "http://www.nbp.pl/kursy/xml/c025z100205.xml";
    String currency = "EUR";

    //when
    String[] test = new DOMParser().getBuyAndSellRatesFromXmlFile(path, currency);
  }
}