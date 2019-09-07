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
        SensorData sensorData = (SensorData) method.invoke(allSensor);
//        assertEquals();
        System.out.println(sensorData);

    }


}
