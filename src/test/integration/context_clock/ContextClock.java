package test.integration.context_clock;

import helper.User;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import main.ContextManager;
import main.LocationServer;
import main.PreferenceRepository;
import support.Preference;
import test.unit.main.preference.PrefWorker;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ContextClock {
    @Before
    public void before() throws Exception {
        Method initMethod = (PreferenceRepository.class).getDeclaredMethod("readPreference");
        initMethod.setAccessible(true);
        PrefWorker.setPreferences((List<Preference>) initMethod.invoke(null));
    }

    @Given("User is logged in as {string}")
    public void user_is_logged_in(String username) throws Exception{
        PrefWorker prefWorker = new PrefWorker();
        Field field = (ContextManager.class).getDeclaredField("users");
        field.setAccessible(true);
        ((LinkedHashMap<String, User> )field.get(null)).put(username, prefWorker.getUserInfo(username));
    }

    @Given("the current clock value is {int}")
    public void the_current_clock_value_is(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("the value of the clock after reset should be {int}")
    public void the_value_of_the_clock_after_reset_should_be(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }
}
