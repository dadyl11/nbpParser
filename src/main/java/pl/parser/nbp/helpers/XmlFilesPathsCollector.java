package pl.parser.nbp.helpers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XmlFilesPathsCollector {

  private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
  private static final String GENERAL_PATH = "http://www.nbp.pl/kursy/xml/";

  private DirFilePathsCollector dirFilePathsCollector = new DirFilePathsCollector();

  public List<String> getXmlFilesPaths(LocalDate startDate, LocalDate endDate) {
    List<String> fileNames = new ArrayList<>();
    List<String> dirFilesPaths = dirFilePathsCollector.getDirFilePaths(startDate, endDate);
    for (String path : dirFilesPaths) {
      try {
        URL url = new URL(path);
        Scanner scanner = new Scanner(url.openStream());
        while (scanner.hasNextLine()) {
          String nextLine = scanner.nextLine();
          if (checkIfFileNameMatchCriteria(nextLine, startDate, endDate)) {
            fileNames.add(GENERAL_PATH + nextLine + ".xml");
          }
        }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    return fileNames;
  }

  private boolean checkIfFileNameMatchCriteria(String fileName, LocalDate startDate, LocalDate endDate) {
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
