package test.unit.support.sensor.suite;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import support.Sensor;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class UsernameAndTypeSensorTest {
    private String sensorUsername;
    private String sensorType;

    public UsernameAndTypeSensorTest(String p1, String p2) {
        sensorUsername = p1;
        sensorType = p2;
    }

    // creates the test data
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                { "Jack" , "Temperature"},
                { "Jack" , "AQI"},
                { "Jack" , "Location"},
                { "David", "Temperature"},
                { "David", "AQI"},
                { "David", "Location"},
        };
        return Arrays.asList(data);
    }

    @Test
    public void testGetType() {
        Sensor sensor = new Sensor(sensorUsername, sensorType);
        assertEquals("Equals", sensorType, sensor.getType());
    }

    @Test
    public void testGetUsername() {
        Sensor sensor = new Sensor(sensorUsername, sensorType);
        assertEquals("Equals", sensorUsername, sensor.getUsername());
    }
}
