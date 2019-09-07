package test.unit.support.sensor;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.unit.support.sensor.suite.AQISensorTest;
import test.unit.support.sensor.suite.LocationSensorTest;
import test.unit.support.sensor.suite.TemperatureSensorTest;
import test.unit.support.sensor.suite.UsernameAndTypeSensorTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AQISensorTest.class,
        LocationSensorTest.class,
        TemperatureSensorTest.class,
        UsernameAndTypeSensorTest.class
})
public class SensorSuite {

}
