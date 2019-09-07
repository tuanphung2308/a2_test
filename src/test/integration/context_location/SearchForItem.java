package test.integration.context_location;

import com.zeroc.Ice.Current;
import com.zeroc.IceInternal.Ex;
import helper.SensorData;
import helper.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.AllSensors;
import main.ContextManager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;

import static org.junit.Assert.assertArrayEquals;

public class SearchForItem {
    private ContextManager.ContextManagerWorkerI contextManagerWorkerI = new ContextManager.ContextManagerWorkerI();
    private AllSensors allSensors;
    private String username;
    @Given("user is logged in under the name of {string}")
    public void user_is_logged_in_under_the_name_of(String username) throws Exception {
        Field communicatorField = (ContextManager.class).getDeclaredField("communicator");
        communicatorField.setAccessible(true);
        communicatorField.set(null, com.zeroc.Ice.Util.initialize());

        Field weatherField = (ContextManager.class).getDeclaredField("currentWeather");
        weatherField.setAccessible(true);
        weatherField.set(null, 0);

        Method method = (ContextManager.class).getDeclaredMethod("readCityInfo");
        method.setAccessible(true);

        Field cityInfo = (ContextManager.class).getDeclaredField("cityInfo");
        cityInfo.setAccessible(true);
        cityInfo.set(null, method.invoke(null));

        Method iniPreferenceWorker = (ContextManager.class).getDeclaredMethod("iniPreferenceWorker");
        iniPreferenceWorker.setAccessible(true);
        iniPreferenceWorker.invoke(null);

        this.contextManagerWorkerI.addUser(username, new Current());

        this.allSensors = new AllSensors(username);
        this.username = username;
    }

    @When("the user search for item at duration of {int}")
    public void the_user_search_for_item_at_duration_of(Integer int1)  throws Exception {
        // Write code here that turns the phrase above into concrete actions
        Field field = (ContextManager.class).getDeclaredField("users");
        field.setAccessible(true);
        LinkedHashMap<String, User> users = (LinkedHashMap<String, User>) field.get(null);

        Method method = (AllSensors.class).getDeclaredMethod("getSensorData");
        method.setAccessible(true);
        users.get(username).sensorData = (SensorData) method.invoke(this.allSensors);
    }


    @Then("should return the following location {string}")
    public void should_return_the_following_location(String string) {
        // Write code here that turns the phrase above into concrete actions
        String[] results = contextManagerWorkerI.searchItems(username, new Current());
        assertArrayEquals("Should be equal", string.split(","), results);
    }
}
