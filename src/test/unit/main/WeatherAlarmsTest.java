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
* @since <pre>Sep 4, 2019</pre> 
* @version 1.0 
*/ 
public class WeatherAlarmsTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: main(String[] args) 
* 
*/ 
@Test
public void testMain() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getWeather(Current current) 
* 
*/ 
@Test
public void testGetWeather() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: terminate(Current current) 
* 
*/ 
@Test
public void testTerminate() throws Exception { 
//TODO: Test goes here... 
} 


/** 
* 
* Method: setupWeatherAlarmWorker(String[] args) 
* 
*/
@Test
public void testSetupWeatherAlarmWorker() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = WeatherAlarms.getClass().getMethod("setupWeatherAlarmWorker", String[].class); 
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
* Method: readWeatherConditions() 
* 
*/ 
@Test
public void testReadWeatherConditions() throws Exception {
    WeatherAlarms weatherAlarms = new WeatherAlarms();
////TODO: Test goes here...
    Method method = (WeatherAlarms.class).getDeclaredMethod("readWeatherConditions");
    method.setAccessible(true);
    List<Integer> expect = Arrays.asList(0, 1, 2, 3);
    List<Integer> actual = (List<Integer>) method.invoke(weatherAlarms);
    assertEquals(expect, actual);
//try {
//   Method method = WeatherAlarms.getClass().getMethod("readWeatherConditions");
//   method.setAccessible(true);
//   method.invoke(<Object>, <Parameters>);
//} catch(NoSuchMethodException e) {
//} catch(IllegalAccessException e) {
//} catch(InvocationTargetException e) {
//}
}

} 
