package test.support.sensor.suite;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import test.support.sensor.SensorTest;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
@RunWith(Parameterized.class)
public class LocationSensorTest extends SensorTest {
    public LocationSensorTest(String p1, String p2, LinkedHashMap p3) {
        super(p1, p2, p3);
    }

    // creates the test data
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        LinkedHashMap davidLocation = new LinkedHashMap();
        davidLocation.put("A", 1);
        davidLocation.put("C", 15);
        davidLocation.put("D", 14);

        LinkedHashMap jackLocation = new LinkedHashMap();
        jackLocation.put("A", 1);
        jackLocation.put("C", 15);
        jackLocation.put("D", 14);


        Object[][] data = new Object[][] {
                { "Jack" , "Location" , jackLocation},
                { "David", "Location" , davidLocation},
        };
        return Arrays.asList(data);
    }

    @Test
    public void testLocationSensor() {
        testReadWeatherConditions();
    }
}
