package pl.parser.nbp.helpers;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class InputValidator {

  public void validateCurrency(String currency) {
    List<String> currencies = Arrays.asList("USD", "EUR", "CHF", "GBP");
    if (!currencies.contains(currency)) {
      throw new IllegalArgumentException("Currency code out of the scope. Choose one of the fallowing codes: EUR, USD, CHF, GBP.");
    }
  }

  public void validateDates(LocalDate startDate, LocalDate endDate) {
    if (startDate.isAfter(endDate)) {
      throw new IllegalArgumentException("Start Date must be equal or before End Date.");
    }
    if (endDate.isAfter(LocalDate.now())) {
      throw new IllegalArgumentException("End Date cannot be in the future.");
    }
  }
}
