package test.integration.all_sensor;

import helper.SensorData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.AllSensors;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AllSensorSteps {
    private AllSensors allSensor = null;
    private SensorData sensorData = null;
    private String username;
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Given("the user is {string}")
    public void the_user_is(String username) {
        // Write code here that turns the phrase above into concrete actions
        this.allSensor = new AllSensors(username);
        this.username = username;
    }

    @When("user is at that location for {int}")
    public void user_is_at_that_location_for(Integer duration) throws Exception{
        Method method = (AllSensors.class).getDeclaredMethod("getSensorData");
        method.setAccessible(true);
        System.out.println("Duration is: " + duration);
        if (duration == 0)
            this.sensorData = (SensorData) method.invoke(allSensor);
        for (int i = 0; i < duration; i++) {
            this.sensorData = (SensorData) method.invoke(allSensor);
        }
    }

    @Then("the value should be obtained correctly like username is {string}")
    public void the_value_should_be_obtained_correctly_like_username_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(username);
        assertEquals("Username should match", username, this.sensorData.username);
    }

    @Then("location is {string}")
    public void location_is(String loc) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(loc);
        assertEquals("Location should match", loc, this.sensorData.location);
    }

    @Then("temperature is {int}")
    public void temperature_is(Integer temp) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(temp.intValue());
        assertEquals("Temp should match", temp.intValue(), this.sensorData.temperature);
    }

    @Then("air quality is {int}")
    public void air_quality_is(Integer aqi) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(aqi.intValue());
        assertEquals("Temp should match", aqi.intValue(), this.sensorData.aqi);
    }

    @Given("the user has one of the followings name {string}")
    public void the_user_has_one_of_the_followings_name(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.username = username;
    }

    @Then("the program should result in an error")
    public void the_program_should_result_in_an_error() {
        expectedEx.expect(FileNotFoundException.class);
        this.allSensor = new AllSensors(this.username);
        // Write code here that turns the phrase above into concrete actions
//        throw new cucumber.api.PendingException();
    }

}
