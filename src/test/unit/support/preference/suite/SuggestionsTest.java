package test.unit.support.preference.suite;

import com.zeroc.Ice.Exception;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import support.Preference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SuggestionsTest {
    private String name;
    private Integer medicalCondition;
    private List<String> suggestions;
    private List<String> expectedValue;

    public SuggestionsTest(String name, Integer medicalCondition, List<String> suggestions, List<String> expectedValue) {
        this.name = name;
        this.medicalCondition = medicalCondition;
        this.suggestions = suggestions;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        List<String> suggestions = new ArrayList<>();
        suggestions.add("Pool");
        suggestions.add("Shop");

        List<String> suggestions2 = new ArrayList<>();
        suggestions.add("Pool");
        suggestions.add("Shop");

        Object[][] data = new Object[][] {
                { "Jack", 1, suggestions, suggestions2},
                { "Jack", 1, suggestions, suggestions2},
        };
        return Arrays.asList(data);
    }

    @Test
    public void testGetSuggestions() throws Exception {
        Preference preference = new Preference(name,medicalCondition,suggestions);
        assertEquals("Equals",suggestions,preference.getSuggestions());
    }

    @Test
    public void testSetSuggestions() throws Exception {
        Preference preference = new Preference(name,medicalCondition,suggestions);
        preference.setSuggestions(expectedValue);
        assertEquals(expectedValue,preference.getSuggestions());
    }
}
