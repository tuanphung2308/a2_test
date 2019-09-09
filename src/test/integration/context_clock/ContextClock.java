package test.integration.context_clock;

import helper.User;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
    String username;
    @Before
    public void before() throws Exception {
        Method initMethod = (PreferenceRepository.class).getDeclaredMethod("readPreference");
        initMethod.setAccessible(true);
        PrefWorker.setPreferences((List<Preference>) initMethod.invoke(null));
    }

    @Given("User is logged in as {string}")
    public void user_is_logged_in(String username) throws Exception{
        this.username = username;
        PrefWorker prefWorker = new PrefWorker();
        Field field = (ContextManager.class).getDeclaredField("users");
        field.setAccessible(true);
        ((LinkedHashMap<String, User> )field.get(null)).put(username, prefWorker.getUserInfo(username));
    }

    @Given("the current clock value is {int}")
    public void the_current_clock_value_is(int tickTime) throws Exception {
        Method method = (ContextManager.class).getDeclaredMethod("tickClock", String.class);
        method.setAccessible(true);
        for (int i = 0; i < tickTime; i ++) {
            method.invoke(null, this.username);
        }
    }

    @Then("the value of the clock after reset should be {int}")
    public void the_value_of_the_clock_after_reset_should_be(int resetClock) throws Exception{
        Method method = (ContextManager.class).getDeclaredMethod("resetClock", String.class);
        method.setAccessible(true);
        method.invoke(null, this.username);

        Field field = (ContextManager.class).getDeclaredField("users");
        field.setAccessible(true);
        LinkedHashMap<String, User> users = (LinkedHashMap<String, User>) field.get(null);

        assertEquals("Should be equal to 0", 0, users.get(username).clock);
    }

    @When("the tick function is called {int}")
    public void the_tick_function_is_called(Integer tickTime) throws Exception{
        Method method = (ContextManager.class).getDeclaredMethod("tickClock", String.class);
        method.setAccessible(true);
        for (int i = 0; i < tickTime; i ++) {
            method.invoke(null, this.username);
        }
    }

    @Then("the value of the clock after ticking should be {int}")
    public void the_value_of_the_clock_after_ticking_should_be(int tickTime) throws Exception{
        Field field = (ContextManager.class).getDeclaredField("users");
        field.setAccessible(true);
        LinkedHashMap<String, User> users = (LinkedHashMap<String, User>) field.get(null);

        assertEquals("Should be equal to 1", tickTime, users.get(username).clock);
    }
}
