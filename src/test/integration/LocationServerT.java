package test.integration;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.LocationServer;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;

public class LocationServerT {
    private String indoor;
    private String outdoor;

    @Given("Indoor is {string}")
    public void indoor_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.indoor = indoor;
    }

    @Given("Outdoor is {string}")
    public void outdoor_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.outdoor = outdoor;
    }

    @Then("the value should be obtained correctly like indoor is {string} and outdoor is {string}")
    public void the_value_should_be_obtained_correctly_like_indoor_is_and_outdoor_is(String string, String string2) throws Exception{
        Method method = (LocationServer.class).getDeclaredMethod("readConfig");
        method.setAccessible(true);
        LinkedHashMap<String, String> linkedHashMap = (LinkedHashMap<String, String>) method.invoke(LocationServer.class);
        System.out.println(linkedHashMap);
        assertEquals("Indoor", linkedHashMap.get("A"));
    }
}
