package test.main.allSensors;

import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Exception;
import helper.MonitorPrx;
import helper.SensorData;
import helper.User;
import junit.framework.TestCase;
import main.AllSensors;
import main.ContextManager;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runners.Parameterized;
import support.Preference;
import support.Sensor;

import javax.xml.crypto.Data;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * AllSensors Tester.
 *
 * @author <Authors name>
 * @since <pre>Sep 4, 2019</pre>
 * @version 1.0
 */
public class AllSensorsTest {
    private String username;
    private boolean signal;
    private Sensor locationSensor;
    private Sensor temperatureSensor;
    private Sensor aqiSensor;
    private Communicator communicator;
    private MonitorPrx monitor;

//    @Before
//    public void before() throws Exception {
//    }
//
//    @After
//    public void after() throws Exception {
//    }


    public AllSensorsTest() {

    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                { "Jack", new int[]{20, 30}},
                { "David", new int[]{16}}
        };
        return Arrays.asList(data);
    }

    @Test
    public void testRun() throws Exception {
//TODO: Test goes here... 
    }

    /**
     *
     * Method: stop()
     *
     */
    @Test
    public void testStop() throws Exception {
//TODO: Test goes here...
        AllSensors allSensors = new AllSensors("Jack");
        boolean test = false;
        assertEquals("Location name should match", test);
    }


    /**
     *
     * Method: setupMonitor()
     *
     */
    @Test
    public void testSetupMonitor() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = AllSensors.getClass().getMethod("setupMonitor"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     *
     * Method: getSensorData()
     *
     */
    @Test
    public void testGetSensorData() throws Exception {

        try {
        Method method = (AllSensors.class).getDeclaredMethod("getSensorData",String.class);
        method.setAccessible(true);
        }
        catch(NoSuchMethodException e) {
        }

//        List<String> results = (List<String>) method.invoke(null, service);
//        TestCase.assertEquals("Should be equal", expectedResults, results);
/* 
try { 
   Method method = AllSensors.getClass().getMethod("getSensorData"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

}
//    private SensorData getSensorData() {
//        String location = this.locationSensor.getCurrentValue();
//        int temperature = Integer.parseInt(this.temperatureSensor.getCurrentValue());
//        int uvr = Integer.parseInt(this.aqiSensor.getCurrentValue());
//        SensorData data = new SensorData(this.username, location, temperature, uvr);
//        return data;
//    }