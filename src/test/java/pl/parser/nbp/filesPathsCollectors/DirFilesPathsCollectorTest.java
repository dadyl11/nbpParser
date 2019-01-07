package pl.parser.nbp.filesPathsCollectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;

class DirFilesPathsCollectorTest {

  @Test
  void shouldReturnOneDirFilePath() {
    //given
    LocalDate startDate = LocalDate.parse("2019-01-01");
    LocalDate endDate = LocalDate.parse("2019-01-05");

    //when
    List<String> dirPaths = new DirFilesPathsCollector().getDirFilesPaths(startDate, endDate);

    //then
    assertThat(dirPaths, hasSize(1));
  }

  @Test
  void shouldCheckIfDirFilePathIsCorrect() {
    //given
    LocalDate startDate = LocalDate.parse("2019-01-01");
    LocalDate endDate = LocalDate.parse("2019-01-05");
    String DIR_PATH = "http://www.nbp.pl/kursy/xml/dir.txt";

    //when
    List<String> dirPaths = new DirFilesPathsCollector().getDirFilesPaths(startDate, endDate);

    //then
    assertThat(dirPaths, hasItem(DIR_PATH));
  }
}