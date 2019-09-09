package test.integration.preference;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import main.PreferenceRepository;
import support.Preference;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PrefRepoTempSuggestSteps {
    PreferenceRepository preferenceRepository = new PreferenceRepository();
    private Field preferences;
    private String username;
    @Given("username: {string}")
    public void username(String string) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        username = string;
        Method initMethod = (PreferenceRepository.class).getDeclaredMethod("readPreference");
        initMethod.setAccessible(true);

        preferences = (PreferenceRepository.class).getDeclaredField("preferences");
        preferences.setAccessible(true);
        preferences.set(null, (List<Preference>) initMethod.invoke(preferenceRepository));
    }

    @Then("The current temperature {int} suggestion is {string}")
    public void the_current_temperature_suggestion_is(Integer int1, String string) throws Exception{
        // Write code here that turns the phrase above into concrete actions
        Method testMethod = (PreferenceRepository.class).getDeclaredMethod("getSuggestionTemp", String.class, Integer.class);
        testMethod.setAccessible(true);
        String result = (String) testMethod.invoke(preferenceRepository, username, int1);

        assertEquals("Should be equal", string, result);
    }
}
