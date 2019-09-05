package test.main.preference;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.main.preference.suite.PrefRepoAPOSuggestTest;
import test.main.preference.suite.PrefRepoInitTest;
import test.main.preference.suite.PrefRepoTempSuggestTest;
import test.main.preference.suite.PrefRepoWeatherSuggestTest;
import test.support.sensor.suite.AQISensorTest;
import test.support.sensor.suite.LocationSensorTest;
import test.support.sensor.suite.TemperatureSensorTest;
import test.support.sensor.suite.UsernameAndTypeSensorTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PrefRepoAPOSuggestTest.class,
        PrefRepoInitTest.class,
        PrefRepoTempSuggestTest.class,
        PrefRepoWeatherSuggestTest.class
})
public class PrefRepoSuite {

}
