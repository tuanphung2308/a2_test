package test.integration;

import helper.SensorData;
import helper.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.AllSensors;
import main.ContextManager;

import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class CheckTempReachedSteps {
    private AllSensors allSensor = null;
    private SensorData sensorData = null;

    @Given("The username is {string}")
    public void the_username_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.allSensor = new AllSensors(string);
    }

    @When("all sensor is initialized done")
    public void all_sensor_is_initialized_done() throws Exception{
        // Write code here that turns the phrase above into concrete actions
        Method method = (AllSensors.class).getDeclaredMethod("getSensorData");
        method.setAccessible(true);
        sensorData = (SensorData) method.invoke(allSensor);
    }

    @Then("The current temperature is {int} reach threshold")
    public void the_current_temperature_is_reach_threshold(Integer int1) throws Exception{
        // Write code here that turns the phrase above into concrete actions
        Method method = (ContextManager.class).getDeclaredMethod("checkTempReached", User.class);
        method.setAccessible(true);
        assertTrue();
    }
}
