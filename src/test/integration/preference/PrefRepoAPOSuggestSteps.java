package test.integration.preference;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import main.PreferenceRepository;
import support.Preference;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PrefRepoAPOSuggestSteps {
    PreferenceRepository preferenceRepository = new PreferenceRepository();
    private Field preferences;
    private String username;
    @Given("username is {string}")
    public void username_is(String string) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        username = string;
        Method initMethod = (PreferenceRepository.class).getDeclaredMethod("readPreference");
        initMethod.setAccessible(true);

        preferences = (PreferenceRepository.class).getDeclaredField("preferences");
        preferences.setAccessible(true);
        preferences.set(null, (List<Preference>) initMethod.invoke(preferenceRepository));
    }

    @Then("The APO suggestion is {string}")
    public void the_APO_suggestion_is(String string) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        Method testMethod = (PreferenceRepository.class).getDeclaredMethod("getSuggestionAPO", String.class);
        testMethod.setAccessible(true);
        String result = (String) testMethod.invoke(preferenceRepository, username);
        assertEquals("Should be equal", string, result);
    }
}
