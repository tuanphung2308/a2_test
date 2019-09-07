package test.integration.context_sensor;

import helper.SensorData;
import helper.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.AllSensors;
import main.ContextManager;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class CheckApoReachedSteps {
    private User user = null;
    private AllSensors allSensor = null;
    private SensorData sensorData = null;
    @Given("The username : {string} with medical condition {int}")
    public void the_username_with_medical_condition(String string, Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        this.allSensor = new AllSensors(string);
        user = new User();
        user.medicalConditionType = int1;
    }

    @When("When user is outdoor for {int}")
    public void when_user_is_outdoor_for(Integer int1) throws Exception{
        // Write code here that turns the phrase above into concrete actions
        Method method = (AllSensors.class).getDeclaredMethod("getSensorData");
        method.setAccessible(true);
        sensorData = (SensorData) method.invoke(allSensor);
        user.clock = int1;
    }

    @Then("The current api is {int} reach threshold should be reached {int}")
    public void the_current_api_is_reach_threshold_should_be_reached(Integer int1, Integer int2) throws Exception{
        // Write code here that turns the phrase above into concrete actions
        Method calculateThreshold = (ContextManager.class).getDeclaredMethod("calculateapoThreshhold", User.class);
        calculateThreshold.setAccessible(true);
        user.sensorData.aqi = int1;
        user.apoThreshhold = (int) calculateThreshold.invoke(null, user);
        boolean expect = true;
        if (int2 == 0) {
            expect = false;
        } else {
            expect = true;
        }
        Method method = (ContextManager.class).getDeclaredMethod("checkapoReached", User.class);
        method.setAccessible(true);
        assertEquals(expect, method.invoke(null, user));
    }
}
