package pl.parser.nbp;

import com.google.common.math.StatsAccumulator;
import java.time.LocalDate;
import java.util.List;
import pl.parser.nbp.filesPathsCollectors.XmlFilesPathsCollector;
import pl.parser.nbp.xmlParser.DOMParser;

public class BuySellRatesCalculator {

  private XmlFilesPathsCollector xmlFilesPathsCollector;
  private DOMParser domParser;

  public BuySellRatesCalculator(XmlFilesPathsCollector xmlFilesPathsCollector, DOMParser domParser) {
    this.xmlFilesPathsCollector = xmlFilesPathsCollector;
    this.domParser = domParser;
  }

  public double[] calculateMeanAndStandardDeviation(LocalDate startDate, LocalDate endDate, String currency) {
    List<String> xmlFilesPaths = xmlFilesPathsCollector.getXmlFilesPaths(startDate, endDate);
    StatsAccumulator statsAccumulatorBuyRate = new StatsAccumulator();
    StatsAccumulator statsAccumulatorSellRate = new StatsAccumulator();

    for (String xmlPath : xmlFilesPaths) {
      statsAccumulatorBuyRate.add(Double.parseDouble(domParser.getBuyAndSellRatesFromXmlFile(xmlPath, currency)[0].replace(",", ".")));
      statsAccumulatorSellRate.add(Double.parseDouble(domParser.getBuyAndSellRatesFromXmlFile(xmlPath, currency)[1].replace(",", ".")));
    }
    double[] meanAndStandardDeviation = new double[2];
    meanAndStandardDeviation[0] = statsAccumulatorBuyRate.mean();
    meanAndStandardDeviation[1] = statsAccumulatorSellRate.populationStandardDeviation();
    return meanAndStandardDeviation;
  }
}
