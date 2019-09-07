package test.unit.main.preference;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.unit.main.preference.suite.PrefRepoAPOSuggestTest;
import test.unit.main.preference.suite.PrefRepoInitTest;
import test.unit.main.preference.suite.PrefRepoTempSuggestTest;
import test.unit.main.preference.suite.PrefRepoWeatherSuggestTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PrefRepoAPOSuggestTest.class,
        PrefRepoInitTest.class,
        PrefRepoTempSuggestTest.class,
        PrefRepoWeatherSuggestTest.class
})
public class PrefRepoSuite {

}
