package pl.parser.nbp.testParameters;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class InputsForCalculateBuySell implements ArgumentsProvider {

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
    return Stream.of(
        Arguments.of("EUR", "2013-01-28", "2013-01-31", new double[]{4.150525, 0.012477053939131788}),
        Arguments.of("EUR", "2018-01-01", "2018-02-01", new double[]{4.1216681818181815, 0.011816409832191675}),
        Arguments.of("USD", "2013-01-28", "2013-01-31", new double[]{3.0760750000000003, 0.010506991719802588}),
        Arguments.of("USD", "2013-01-28", "2013-01-31", new double[]{3.0760750000000003, 0.010506991719802588}),
        Arguments.of("CHF", "2013-01-28", "2013-01-31", new double[]{3.3347249999999997, 0.01467061263206128}),
        Arguments.of("CHF", "2013-01-28", "2013-01-31", new double[]{3.3347249999999997, 0.01467061263206128}),
        Arguments.of("GBP", "2013-01-28", "2013-01-31", new double[]{4.8495, 0.008008120878208812}),
        Arguments.of("GBP", "2013-01-28", "2013-01-31", new double[]{4.8495, 0.008008120878208812})
    );
  }
}
