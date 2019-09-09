package test.unit.main;

import main.WeatherAlarms;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;


/**
 * WeatherAlarms Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Sep 4, 2019</pre>
 */
public class WeatherAlarmsTest {
    @Test
    public void testReadWeatherConditions() throws Exception {
        WeatherAlarms weatherAlarms = new WeatherAlarms();
        Method method = (WeatherAlarms.class).getDeclaredMethod("readWeatherConditions");
        method.setAccessible(true);
        List<Integer> expect = Arrays.asList(0, 1, 2, 3);
        List<Integer> actual = (List<Integer>) method.invoke(weatherAlarms);
        assertEquals("Weather condition read correctly", expect, actual);
    }

} 
