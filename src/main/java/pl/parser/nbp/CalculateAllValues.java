package pl.parser.nbp;

import com.google.common.math.StatsAccumulator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import pl.parser.nbp.filesPathsCollectors.XmlFilesPathsCollector;
import pl.parser.nbp.xmlParser.DOMParser;

public class CalculateAllValues {

  private XmlFilesPathsCollector xmlFilesPathsCollector;
  private DOMParser domParser;

  public CalculateAllValues(XmlFilesPathsCollector xmlFilesPathsCollector, DOMParser domParser) {
    this.xmlFilesPathsCollector = xmlFilesPathsCollector;
    this.domParser = domParser;
  }

  public void calculateMeanAndStandardDeviation(LocalDate startDate, LocalDate endDate, String currency) {
    List<String> xmlFilesPaths = xmlFilesPathsCollector.getXmlFilesPaths(startDate, endDate);
    List<Double> buyRates = new ArrayList<>();
    List<Double> sellRates = new ArrayList<>();

    for (String xmlPath : xmlFilesPaths) {
      buyRates.add(Double.parseDouble(domParser.getBuyAndSellRatesFromXmlFile(xmlPath, currency)[0].replace(",", ".")));
      sellRates.add(Double.parseDouble(domParser.getBuyAndSellRatesFromXmlFile(xmlPath, currency)[1].replace(",", ".")));
    }

    StatsAccumulator statsAccumulatorBuyRate = new StatsAccumulator();
    StatsAccumulator statsAccumulatorSellRate = new StatsAccumulator();

    for (double buyRate : buyRates) {
      statsAccumulatorBuyRate.add(buyRate);
    }
    for (double sellRate : sellRates) {
      statsAccumulatorSellRate.add(sellRate);
    }
    double mean = statsAccumulatorBuyRate.mean();
    double standardDeviation = statsAccumulatorSellRate.populationStandardDeviation();
    System.out.printf("%.4f %n", mean);
    System.out.printf("%.4f %n", standardDeviation);
  }
}
