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

}


