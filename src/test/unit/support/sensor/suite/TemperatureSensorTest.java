package test.unit.support.sensor.suite;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import test.unit.support.sensor.SensorTest;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
@RunWith(Parameterized.class)
public class TemperatureSensorTest extends SensorTest {
    public TemperatureSensorTest(String p1, String p2, LinkedHashMap p3) {
        super(p1, p2, p3);
    }

    // creates the test data
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        LinkedHashMap jackTemp = new LinkedHashMap();
        jackTemp.put("10", 5);
        jackTemp.put("15", 3);
        jackTemp.put("20", 4);

        LinkedHashMap davidTemp = new LinkedHashMap();
        davidTemp.put("10", 5);
        davidTemp.put("25", 3);
        davidTemp.put("20", 4);

        Object[][] data = new Object[][] {
                { "Jack" , "Temperature" , jackTemp},
                { "David", "Temperature" , davidTemp},
        };
        return Arrays.asList(data);
    }

    @Test
    public void testTemperatureSensor() {
        testReadWeatherConditions();
    }
}
