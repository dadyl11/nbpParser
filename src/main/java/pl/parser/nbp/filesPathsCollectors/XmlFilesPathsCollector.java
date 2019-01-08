package pl.parser.nbp.filesPathsCollectors;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XmlFilesPathsCollector {

  private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
  private static final String GENERAL_PATH = "http://www.nbp.pl/kursy/xml/";
  private TextFilesPathsCollector textFilesPathsCollector = new TextFilesPathsCollector();

  Logger logger = LoggerFactory.getLogger(XmlFilesPathsCollector.class);

  public List<String> getXmlFilesPaths(LocalDate startDate, LocalDate endDate) {
    List<String> fileNames = new ArrayList<>();
    List<String> dirFilesPaths = textFilesPathsCollector.getDirFilesPaths(startDate, endDate);
    for (String path : dirFilesPaths) {
      try (Scanner scanner = new Scanner(new URL(path).openStream())) {
        while (scanner.hasNextLine()) {
          String nextLine = scanner.nextLine();
          if (checkIfFileNameMatchCriteria(nextLine, startDate, endDate)) {
            fileNames.add(GENERAL_PATH + nextLine + ".xml");
          }
        }
      } catch (IOException ex) {
        logger.error("Input/Output Exception was thrown.", ex);
        ex.printStackTrace();
      }
    }
    return fileNames;
  }

  public boolean checkIfFileNameMatchCriteria(String fileName, LocalDate startDate, LocalDate endDate) {
    if (!fileName.startsWith("c")) {
      return false;
    }
    LocalDate fileDate = LocalDate.parse(fileName.substring(5, 11), formatter);
    if ((fileDate.isAfter(startDate) || fileDate.equals(startDate)) && (fileDate.isBefore(endDate) || fileDate.equals(endDate))) {
      return true;
    }
    return false;
  }
}
