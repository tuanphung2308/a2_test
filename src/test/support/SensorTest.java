package test.support;

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
import support.Sensor;

@RunWith(Parameterized.class)
public class SensorTest {
    private String sensorUsername;
    private String sensorType;
    private LinkedHashMap linkedHashMap;

    public SensorTest(String p1, String p2, LinkedHashMap p3) {
        sensorUsername = p1;
        sensorType = p2;
        p3 = linkedHashMap;
    }
    // creates the test data
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                { "Jack" , "Temperature" , },
                { "David", "AQI" , },
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
            Object res = method.invoke(sensor);
            System.out.println(res);
        } catch(NoSuchMethodException e) {
        } catch(IllegalAccessException e) {
        } catch(InvocationTargetException e) {
            System.out.println("Invoke except");
        }
    }

}