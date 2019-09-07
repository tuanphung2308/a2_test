package test.unit.main.allSensors;

import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Exception;
import helper.MonitorPrx;
import helper.User;
import main.AllSensors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import support.Sensor;
import test.unit.support.sensor.suite.TemperatureSensorTest;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GetSensorDataTest {
    private String username;
    private Sensor locationSensor;
    private Sensor temperatureSensor;
    private Sensor aqiSensor;

    public GetSensorDataTest(String username, Sensor locationSensor, Sensor temperatureSensor, Sensor aqiSensor) {
        this.username = username;
        this.locationSensor = locationSensor;
        this.temperatureSensor = temperatureSensor;
        this.aqiSensor = aqiSensor;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Sensor sensor = new Sensor("Jack","Location");
        Sensor sensor1 = new Sensor("Jack","Temperature");
        Sensor sensor2 = new Sensor("Jack","AQI");

        Object[][] data = new Object[][]{
                {"Jack",sensor,sensor1,sensor2},
        };
        return Arrays.asList(data);
    }
    @Test
    public void testGetSensorData() throws Exception {
        User user = new User();
        user.sensorData.username = this.username;
        try {
            Method method = (AllSensors.class).getDeclaredMethod("getSensorData",String.class);
            method.setAccessible(true);
            assertEquals("Result should be equal",method.getReturnType());

        }
        catch(NoSuchMethodException e) {
        }

//        List<String> results = (List<String>) method.invoke(null, service);
//        TestCase.assertEquals("Should be equal", expectedResults, results);
    }
}
