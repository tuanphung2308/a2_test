package test.integration;

import io.cucumber.java.en.And;
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

    @Given("^Indoor is \"([^\"]*)\"$")
    public void indoor_is(String indoor) {
        this.indoor = indoor;
    }
    @And("^Outdoor is \"([^\"]*)\"$")
    public void outdoor_is(String outdoor) {
        this.outdoor = outdoor;
    }

    @Then("the value should be obtained correctly like indoor is \"([^\"]*)\"$ and outdoor is \"([^\"]*)\"$")
    public void i_should_be_told() throws Exception{
        Method method = (LocationServer.class).getDeclaredMethod("readConfig");
        method.setAccessible(true);
        LinkedHashMap<String, String> linkedHashMap = (LinkedHashMap<String, String>) method.invoke(LocationServer.class);
        System.out.println(linkedHashMap);
        assertEquals("Weather condition read correctly", linkedHashMap);
    }
}
