package test.integration.context_sensor;

import helper.SensorData;
import helper.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.AllSensors;
import main.ContextManager;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class CalculateApoThresholdSteps {
    private User user = null;
    private AllSensors allSensor = null;
    private SensorData sensorData = null;
    @Given("username : {string} has medical condition {int}")
    public void username_has_medical_condition(String string, Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        this.allSensor = new AllSensors(string);
        user = new User();
        user.medicalConditionType = int1;
    }

    @When("The current api read is {int}")
    public void the_current_api_read_is(Integer int1) throws Exception{
        // Write code here that turns the phrase above into concrete actions
        Method method = (AllSensors.class).getDeclaredMethod("getSensorData");
        method.setAccessible(true);
        sensorData = (SensorData) method.invoke(allSensor);
        user.sensorData.aqi = int1;
    }

    @Then("The APO threshold is {int}")
    public void the_APO_threshold_is(Integer int1) throws Exception{
        // Write code here that turns the phrase above into concrete actions
        Method calculateThreshold = (ContextManager.class).getDeclaredMethod("calculateapoThreshhold", User.class);
        calculateThreshold.setAccessible(true);
        user.apoThreshhold = (int) calculateThreshold.invoke(null, user);
        assertEquals((int) int1, user.apoThreshhold);

    }
}
