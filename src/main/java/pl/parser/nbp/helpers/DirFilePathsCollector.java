package pl.parser.nbp.helpers;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class DirFilePathsCollector {

  private static final String DIR_PATH = "http://www.nbp.pl/kursy/xml/dir";

  public List<String> getDirFilePaths(LocalDate startDate, LocalDate endDate) {
    int startDateYear = startDate.getYear();
    int endDateYear = endDate.getYear();
    List<String> dirPaths = new ArrayList<>();
    for (int year = startDateYear; year <= endDateYear; year++) {
      if (year == Year.now().getValue()) {
        dirPaths.add(DIR_PATH + ".txt");
      } else {
        dirPaths.add(DIR_PATH + year + ".txt");
      }
    }
    return dirPaths;
  }
}
