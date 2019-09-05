package test.support.sensor;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.support.sensor.suite.AQISensorTest;
import test.support.sensor.suite.LocationSensorTest;
import test.support.sensor.suite.TemperatureSensorTest;
import test.support.sensor.suite.UsernameAndTypeSensorTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AQISensorTest.class,
        LocationSensorTest.class,
        TemperatureSensorTest.class,
        UsernameAndTypeSensorTest.class
})
public class SensorSuite {

}
