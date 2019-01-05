package pl.parser.nbp.helpers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class XmlFilesPathsCollectorTest {

  @Test
  void shouldReturnListOfCorrectXmlFilesPaths() {
    //given
    LocalDate startDate = LocalDate.parse("2018-09-10");
    LocalDate endDate = LocalDate.parse("2018-10-12");

    //when
    List<String> paths = new XmlFilesPathsCollector().getXmlFilesPaths(startDate, endDate);
    System.out.println(paths);

    //then
    assertThat(paths, hasSize(25));
  }

  @Test
  void checkIfFileNameMatchCriteria() {
    //given
    String fileName = "h43434";
  }
}