package pl.parser.nbp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainClass {

  public static void main(String[] args) {

    String currency = args[0];
    String startDate = args[1];
    String endDate = args[2];

    System.out.println(currency + startDate + endDate);
    LocalDate startDate2 = LocalDate.parse(startDate);
    LocalDate endDate2 = LocalDate.parse(endDate);


  }

  final String PATH = "http://www.nbp.pl/kursy/xml/dir";

  public List<String> getXmlFilePathsFromDirTextFile(LocalDate startDate, LocalDate endDate, String currency) {
    List<String> fileNames = new ArrayList<>();
    String dir = PATH + startDate.getYear() + ".txt";
    return fileNames;
  }
}


