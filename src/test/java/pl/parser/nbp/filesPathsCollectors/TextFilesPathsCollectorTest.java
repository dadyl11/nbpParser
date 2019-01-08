package pl.parser.nbp.filesPathsCollectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;

class TextFilesPathsCollectorTest {

  @Test
  void shouldReturnOneDirFilePath() {
    //given
    LocalDate startDate = LocalDate.parse("2019-01-01");
    LocalDate endDate = LocalDate.parse("2019-01-05");

    //when
    List<String> dirPaths = new TextFilesPathsCollector().getDirFilesPaths(startDate, endDate);

    //then
    assertThat(dirPaths, hasSize(1));
  }

  @Test
  void shouldCheckIfDirFilePathForCurrentYearIsCorrect() {
    //given
    LocalDate startDate = LocalDate.parse("2019-01-01");
    LocalDate endDate = LocalDate.parse("2019-01-05");
    String DIR_PATH = "http://www.nbp.pl/kursy/xml/dir.txt";

    //when
    List<String> dirPaths = new TextFilesPathsCollector().getDirFilesPaths(startDate, endDate);

    //then
    assertThat(dirPaths, hasItem(DIR_PATH));
  }

  @Test
  void shouldCheckIfDirFilePathForPreviousIsCorrect() {
    //given
    LocalDate startDate = LocalDate.parse("2018-01-01");
    LocalDate endDate = LocalDate.parse("2018-01-05");
    String DIR_PATH = "http://www.nbp.pl/kursy/xml/dir2018.txt";

    //when
    List<String> dirPaths = new TextFilesPathsCollector().getDirFilesPaths(startDate, endDate);

    //then
    assertThat(dirPaths, hasItem(DIR_PATH));
  }

  @Test
  void shouldReturnFiveDirFilePath() {
    //given
    LocalDate startDate = LocalDate.parse("2015-01-01");
    LocalDate endDate = LocalDate.parse("2019-01-05");

    //when
    List<String> dirPaths = new TextFilesPathsCollector().getDirFilesPaths(startDate, endDate);

    //then
    assertThat(dirPaths, hasSize(5));
  }
}