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
public class PrefRepoTempSuggestTest {
    PreferenceRepository preferenceRepository = new PreferenceRepository();
    private String name;
    private Integer threshHold;
    private String services;

    public PrefRepoTempSuggestTest(String name, Integer t, String s) {
        this.name = name;
        this.threshHold = t;
        this.services = s;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                { "Jack", 19 , null}, // less than
                { "Jack", 20 , "shops"}, // equal
                { "Jack", 21 , "shops"}, // between 20-30
                { "Jack", 30 , "pool"}, // equal to 30
                { "Jack", 31 , "pool"}, // greater than

                { "David", 10 , null}, // less than
                { "David", 16 , "pool"}, // equal
                { "David", 20 , "pool"}, // greater than
                { "David", 2147483647 , "pool"}, // max
                { "David", -2147483647 , null}, // min
                { "David", -20 , null}, // less than 0
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
            Method testMethod = (PreferenceRepository.class).getDeclaredMethod("getSuggestionTemp", String.class, Integer.class);
            testMethod.setAccessible(true);
            String result = (String) testMethod.invoke(preferenceRepository, name, threshHold);

            assertEquals("Should be equal", services, result);
        } catch(NoSuchMethodException e) {
        } catch(IllegalAccessException e) {
        } catch(InvocationTargetException e) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
