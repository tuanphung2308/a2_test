package test.support.sensor.suite;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import sun.awt.image.ImageWatched;
import support.Sensor;

@RunWith(Parameterized.class)
public class SensorTest {
    private String sensorUsername;
    private String sensorType;
    private LinkedHashMap linkedHashMap;

    public SensorTest(String p1, String p2, LinkedHashMap p3) {
        sensorUsername = p1;
        sensorType = p2;
        linkedHashMap = p3;
    }

    // creates the test data
    @Parameters
    public static Collection<Object[]> data() {
        LinkedHashMap jackTemp = new LinkedHashMap();
        jackTemp.put("10", 5);
        jackTemp.put("15", 3);
        jackTemp.put("20", 4);

        LinkedHashMap davidTemp = new LinkedHashMap();
        davidTemp.put("10", 5);
        davidTemp.put("25", 3);
        davidTemp.put("20", 4);

        LinkedHashMap davidAQI = new LinkedHashMap();

        davidAQI.put("200", 15);
        davidAQI.put("90", 11);

        LinkedHashMap jackAQI = new LinkedHashMap();
        jackAQI.put("200", 15);
        jackAQI.put("90", 11);

        LinkedHashMap davidLocation = new LinkedHashMap();
        davidLocation.put("A", 1);
        davidLocation.put("C", 15);
        davidLocation.put("D", 14);

        LinkedHashMap jackLocation = new LinkedHashMap();
        jackLocation.put("A", 1);
        jackLocation.put("C", 15);
        jackLocation.put("D", 14);

        Object[][] data = new Object[][] {
                { "Jack" , "Temperature" , jackTemp},
                { "Jack" , "AQI" , jackAQI},
                { "Jack" , "Location" , jackLocation},
                { "David", "Temperature" , davidTemp},
                { "David", "AQI" , davidAQI},
                { "David", "Location" , davidLocation},
        };
        return Arrays.asList(data);
    }
    @Test
    public void testGetUsername() {
        Sensor sensor = new Sensor(sensorUsername, sensorType);
        assertEquals("Equals", sensorUsername, sensor.getUsername());
    }

    @Test
    public void testGetType() {
        Sensor sensor = new Sensor(sensorUsername, sensorType);
        assertEquals("Equals", sensorType, sensor.getType());
    }

    @Test
    public void testReadWeatherConditions() throws Exception {
        Sensor sensor = new Sensor(sensorUsername, sensorType);

        try {
            Method method = sensor.getClass().getDeclaredMethod("readData");
            method.setAccessible(true);
            LinkedHashMap res = (LinkedHashMap) method.invoke(sensor);
            assertEquals("Equal", res, linkedHashMap);
//            System.out.println(res);
        } catch(NoSuchMethodException e) {
        } catch(IllegalAccessException e) {
        } catch(InvocationTargetException e) {
            System.out.println("Invoke except");
        }
    }

}