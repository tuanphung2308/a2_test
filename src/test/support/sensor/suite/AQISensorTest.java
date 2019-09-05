package test.support.sensor.suite;

import org.junit.Test;
import org.junit.runners.Parameterized;
import test.support.sensor.SensorTest;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;

public class AQISensorTest extends SensorTest {
    public AQISensorTest(String p1, String p2, LinkedHashMap p3) {
        super(p1, p2, p3);
    }

    // creates the test data
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        LinkedHashMap davidAQI = new LinkedHashMap();

        davidAQI.put("200", 15);
        davidAQI.put("90", 11);

        LinkedHashMap jackAQI = new LinkedHashMap();
        jackAQI.put("200", 15);
        jackAQI.put("90", 11);

        Object[][] data = new Object[][] {
                { "Jack" , "AQI" , jackAQI},
                { "David", "AQI" , davidAQI},
        };
        return Arrays.asList(data);
    }

    @Test
    public void testAQI() {
        testReadWeatherConditions();
    }
}
