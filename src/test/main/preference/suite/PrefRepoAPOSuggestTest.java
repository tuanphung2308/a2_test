package test.main.preference.suite;

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
public class PrefRepoAPOSuggestTest {
    PreferenceRepository preferenceRepository = new PreferenceRepository();
    private String name;
    private String services;

    public PrefRepoAPOSuggestTest(String name, String s) {
        this.name = name;
        this.services = s;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                { "Jack" , "bowling"},
                { "David", "cinema"},
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
            Method testMethod = (PreferenceRepository.class).getDeclaredMethod("getSuggestionAPO", String.class);
            testMethod.setAccessible(true);
            String result = (String) testMethod.invoke(preferenceRepository, name);

            assertEquals("Should be equal", services, result);
        } catch(NoSuchMethodException e) {
        } catch(IllegalAccessException e) {
        } catch(InvocationTargetException e) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
