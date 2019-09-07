package test.integration;

import helper.SensorData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.AllSensors;
import main.PreferenceRepository;
import support.Preference;

import java.lang.reflect.Method;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AllSensorSteps {
    private AllSensors allSensor = null;
    private SensorData sensorData = null;
    @Given("the user is {string}")
    public void the_user_is(String username) {
        // Write code here that turns the phrase above into concrete actions
        this.allSensor = new AllSensors(username);
    }

    @When("all sensor is initialized")
    public void all_sensor_is_initialized() throws Exception{
        // Write code here that turns the phrase above into concrete actions
        Method method = (AllSensors.class).getDeclaredMethod("getSensorData");
        method.setAccessible(true);
        sensorData = (SensorData) method.invoke(allSensor);
    }

    @Then("the value should be obtained correctly like location is {string} and temperature is {int} and aqi is {int}")
    public void the_value_should_be_obtained_correctly_like_location_is_and_temperature_is_and_aqi_is_aqi(String string, Integer int1, Integer int2) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(string, sensorData.location);
        assertEquals(int1, (Integer) sensorData.temperature);
        assertEquals(int2, (Integer) sensorData.aqi);
    }


}
