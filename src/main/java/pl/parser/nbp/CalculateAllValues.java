package pl.parser.nbp;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import pl.parser.nbp.helpers.XmlFilesPathsCollector;
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

    DescriptiveStatistics descriptiveStatisticsByeRate = new DescriptiveStatistics();
    DescriptiveStatistics descriptiveStatisticsSellRate = new DescriptiveStatistics();

    for (double buyRate : buyRates){
      descriptiveStatisticsByeRate.addValue(buyRate);
    }
    for (double sellRate : sellRates){
      descriptiveStatisticsSellRate.addValue(sellRate);
    }
    double mean = descriptiveStatisticsByeRate.getMean();
    double standardDeviation = descriptiveStatisticsSellRate.getStandardDeviation();
    System.out.printf("%.4f %n", mean);
    System.out.printf("%.4f %n", standardDeviation);
  }
}
