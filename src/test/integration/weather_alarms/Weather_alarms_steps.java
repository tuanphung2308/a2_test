package test.integration.weather_alarms;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import main.WeatherAlarms;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Weather_alarms_steps {
    private WeatherAlarms weatherAlarms;
    private Field weatherCondition = null;
    private List<Integer> expect = Arrays.asList(0, 1, 2, 3);
    @Given("Weather alarm initialized")
    public void weather_alarm_initialized() throws Exception{
        // Write code here that turns the phrase above into concrete actions
        weatherAlarms = new WeatherAlarms();
        Method readWeatherConditions = (WeatherAlarms.class).getDeclaredMethod("readWeatherConditions");
        readWeatherConditions.setAccessible(true);

        weatherCondition = (WeatherAlarms.class).getDeclaredField("weatherConditions");
        weatherCondition.setAccessible(true);
        weatherCondition.set(weatherAlarms, (List<Integer>) readWeatherConditions.invoke(weatherAlarms));
        System.out.println(weatherCondition.get(weatherAlarms));
    }

    @Then("Weather alarm data read correctly")
    public void weather_alarm_data_read_correctly() throws Exception{
        // Write code here that turns the phrase above into concrete actions
        assertEquals(expect, weatherCondition.get(weatherAlarms));
    }
}
