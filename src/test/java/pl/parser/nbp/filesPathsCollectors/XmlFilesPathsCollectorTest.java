package pl.parser.nbp.filesPathsCollectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class XmlFilesPathsCollectorTest {

  @Test
  void shouldReturnListOfCorrectXmlFilesPaths() {
    //given
    LocalDate startDate = LocalDate.parse("2018-09-10");
    LocalDate endDate = LocalDate.parse("2018-10-12");

    //when
    List<String> paths = new XmlFilesPathsCollector().getXmlFilesPaths(startDate, endDate);

    //then
    assertThat(paths, hasSize(25));
  }

  @ParameterizedTest
  @MethodSource("params")
  void checkIfFileNameMatchCriteria(String fileName, LocalDate startDate, LocalDate endDate, boolean result) {
    //given

    //when
    boolean matchCriteria = new XmlFilesPathsCollector().checkIfFileNameMatchCriteria(fileName, startDate, endDate);

    //then
    assertThat(matchCriteria, is(result));
  }

  private static Stream<Arguments> params() {
    return Stream.of(
        Arguments.of("h003z190104", "2018-09-10", "2018-10-12", false),
        Arguments.of("c002z180103", "2018-01-01", "2018-07-10", true),
        Arguments.of("c003z190104", "2019-01-01", "2019-01-04", true),
        Arguments.of("c003z190104", "2019-09-10", "2018-10-12", false),
        Arguments.of("c003z190104", "2018-09-10", "2018-10-12", false),
        Arguments.of("a003z190104", "2018-09-10", "2018-10-12", false)
    );
  }
}