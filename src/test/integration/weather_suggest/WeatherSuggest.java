package test.integration.weather_suggest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import main.PreferenceRepository;
import support.Preference;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WeatherSuggest {
    PreferenceRepository preferenceRepository = new PreferenceRepository();
    private String name;
    private Integer weather;
    @Given("The user is logged in under {string}")
    public void the_user_is_logged_in_under(String username) throws Exception {
        this.name = username;
        Method initMethod = (PreferenceRepository.class).getDeclaredMethod("readPreference");
        initMethod.setAccessible(true);

        Field field = (PreferenceRepository.class).getDeclaredField("preferences");
        field.setAccessible(true);
        field.set(null, (List< Preference >) initMethod.invoke(preferenceRepository));
    }

    @Given("the weather from the sensor is {int}")
    public void the_weather_from_the_sensor_is(Integer weather) {
        this.weather = weather;
    }

    @Then("the suggestion for the user should be null")
    public void the_suggestion_for_the_user_should_be_null() throws Exception {
        Method testMethod = (PreferenceRepository.class).getDeclaredMethod("getSuggestionWeather", String.class, Integer.class);
        testMethod.setAccessible(true);
        String result = (String) testMethod.invoke(preferenceRepository, name, weather);

        assertEquals("Should be equal", null, result);
    }

    @Then("the suggestion for the user should be {string}")
    public void the_suggestion_for_the_user_should_be(String expected) throws Exception {
        Method testMethod = (PreferenceRepository.class).getDeclaredMethod("getSuggestionWeather", String.class, Integer.class);
        testMethod.setAccessible(true);
        String result = (String) testMethod.invoke(preferenceRepository, name, weather);

        assertEquals("Should be equal", expected, result);
    }
}
