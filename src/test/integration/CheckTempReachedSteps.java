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
    public void the_username_is(String string) throws Exception{
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

    @Then("The current temperature is {int} reach threshold should be {int}")
    public void the_current_temperature_is_reach_threshold_should_be(Integer int1, Integer int2) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        User user = new User();
        user.sensorData.temperature = int1;
        int[] threshold = {20, 30};
        user.tempThreshholds = threshold;
        Method method = (ContextManager.class).getDeclaredMethod("checkTempReached", User.class);
        method.setAccessible(true);
        boolean expect = true;
        if (int2 == 0) {
            expect = false;
        } else {
            expect = true;
        }
        assertEquals(expect, method.invoke(null, user));

    }
}
