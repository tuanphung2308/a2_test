package test.support.sensor;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import support.Sensor;

@RunWith(Parameterized.class)
public class SensorTest {
    private String sensorUsername;
    private String sensorType;
    private LinkedHashMap linkedHashMap;

    private static Object[][] data = new Object[][] {};

    public SensorTest(String p1, String p2, LinkedHashMap p3) {
        sensorUsername = p1;
        sensorType = p2;
        linkedHashMap = p3;
    }

    // creates the test data
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(data);
    }

    public void testReadWeatherConditions() {
        Sensor sensor = new Sensor(sensorUsername, sensorType);

        try {
            Method method = sensor.getClass().getDeclaredMethod("readData");
            method.setAccessible(true);
            LinkedHashMap res = (LinkedHashMap) method.invoke(sensor);
            assertEquals("Equal", res, linkedHashMap);
        } catch(NoSuchMethodException e) {
        } catch(IllegalAccessException e) {
        } catch(InvocationTargetException e) {
            System.out.println("Invoke except");
        }
    }
}