package pl.parser.nbp.filesPathsCollectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;
import java.util.List;
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
    LocalDate startDate = LocalDate.parse("2018-09-10");
    LocalDate endDate = LocalDate.parse("2018-10-12");
    String fileName = "h43434";

    //when
    boolean matchCriteria = new XmlFilesPathsCollector().checkIfFileNameMatchCriteria(fileName, startDate, endDate);

    //then
    assertFalse(matchCriteria);
    //todo parameters test
  }
}