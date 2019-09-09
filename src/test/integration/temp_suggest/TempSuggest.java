package test.integration.temp_suggest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import main.PreferenceRepository;
import support.Preference;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TempSuggest {
    private Integer threshHold;
    private String username;

    PreferenceRepository preferenceRepository = new PreferenceRepository();
    @Given("The user is logged in under {string}")
    public void the_user_is_logged_in_under(String username) throws Exception {
        this.username = username;

        // Write code here that turns the phrase above into concrete actions
        Method initMethod = (PreferenceRepository.class).getDeclaredMethod("readPreference");
        initMethod.setAccessible(true);

        Field field = (PreferenceRepository.class).getDeclaredField("preferences");
        field.setAccessible(true);
        field.set(null, (List<Preference>) initMethod.invoke(preferenceRepository));
    }

    @Given("the temperature from the sensor is {int}")
    public void the_temperature_from_the_sensor_is(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        this.threshHold = int1;
    }

    @Then("the suggestion for the user should be null")
    public void the_suggestion_for_the_user_should_be_null()  throws Exception{
        Method testMethod = (PreferenceRepository.class).getDeclaredMethod("getSuggestionTemp", String.class, Integer.class);
        testMethod.setAccessible(true);
        String result = (String) testMethod.invoke(preferenceRepository, this.username, threshHold);

        assertEquals("Should be equal", null, result);
    }

    @Then("the suggestion for the user should be {string}")
    public void the_suggestion_for_the_user_should_be(String expected) throws Exception {
        Method testMethod = (PreferenceRepository.class).getDeclaredMethod("getSuggestionTemp", String.class, Integer.class);
        testMethod.setAccessible(true);
        String result = (String) testMethod.invoke(preferenceRepository, this.username, threshHold);

        assertEquals("Should be equal", expected, result);
    }
}
