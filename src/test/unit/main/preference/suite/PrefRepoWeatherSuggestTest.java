package test.unit.main.preference.suite;

import main.PreferenceRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import support.Preference;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PrefRepoWeatherSuggestTest {
    PreferenceRepository preferenceRepository = new PreferenceRepository();
    private String name;
    private Integer weather;
    private String services;

    public PrefRepoWeatherSuggestTest(String name, Integer w, String s) {
        this.name = name;
        this.weather = w;
        this.services = s;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                { "Jack", 0 , null}, // normal weather
                { "Jack", 1 , "cinema"}, // shoudl suggest
                { "Jack", 2 , "cinema"}, // shoudl suggest
                { "Jack", 3 , "cinema"}, // shoudl suggest
                { "Jack", -30 , null}, // minus
                { "Jack", 4 , null}, // invalid
                { "Jack", 2147483647 , null}, // large number
                { "Jack", -2147483647 , null}, // smallest number

                { "David", 0 , null}, // shoudl suggest
                { "David", 1 , "shops"}, // shoudl suggest
                { "David", 2 , "shops"}, // shoudl suggest
                { "David", 3 , "shops"}, // shoudl suggest
        };
        return Arrays.asList(data);
    }
    @Before
    public void before() throws Exception {
        Method initMethod = (PreferenceRepository.class).getDeclaredMethod("readPreference");
        initMethod.setAccessible(true);

        Field field = (PreferenceRepository.class).getDeclaredField("preferences");
        field.setAccessible(true);
        field.set(null, (List< Preference >) initMethod.invoke(preferenceRepository));
    }

    @Test
    public void testGetSuggestionAPO() {
        try {
            Method testMethod = (PreferenceRepository.class).getDeclaredMethod("getSuggestionWeather", String.class, Integer.class);
            testMethod.setAccessible(true);
            String result = (String) testMethod.invoke(preferenceRepository, name, weather);

            assertEquals("Should be equal", services, result);
        } catch(NoSuchMethodException e) {
        } catch(IllegalAccessException e) {
        } catch(InvocationTargetException e) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
