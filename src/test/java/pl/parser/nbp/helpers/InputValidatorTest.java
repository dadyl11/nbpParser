package pl.parser.nbp.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

  private InputValidator inputValidator = new InputValidator();

  @Test
  void shouldNotThrowException() {
    //given
    String currency = "EUR";

    //when
    inputValidator.validateCurrency(currency);
  }

  @Test
  void shouldThrowIllegalArgumentExceptionCausedByWrongCurrency() {
    //given
    String currency = "CAD";

    //when
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      inputValidator.validateCurrency(currency);
    });

    //then
    assertEquals("Wrong currency code.", exception.getMessage());
  }

  @Test
  void shouldNotThrowIllegalArgumentException() {
    //given
    LocalDate startDate = LocalDate.parse("2018-09-10");
    LocalDate endDate = LocalDate.parse("2018-10-12");

    //when
    inputValidator.validateDates(startDate, endDate);
  }

  @Test
  void shouldThrowIllegalArgumentExceptionCausedByStartDateInFuture() {
    //given
    LocalDate startDate = LocalDate.parse("2019-09-10");
    LocalDate endDate = LocalDate.parse("2019-10-12");

    //when
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      inputValidator.validateDates(startDate, endDate);
    });

    //then
    assertEquals("End Date cannot be in the future.", exception.getMessage());
  }

  @Test
  void shouldThrowIllegalArgumentExceptionCausedByStartDateAfterEndDate() {
    //given
    LocalDate startDate = LocalDate.parse("2018-09-10");
    LocalDate endDate = LocalDate.parse("2018-08-12");

    //when
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      inputValidator.validateDates(startDate, endDate);
    });

    //then
    assertEquals("Start Date must be equal or before End Date.", exception.getMessage());
  }
}