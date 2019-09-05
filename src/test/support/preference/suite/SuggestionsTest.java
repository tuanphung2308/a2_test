package test.support.preference.suite;

import com.zeroc.Ice.Exception;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import support.Preference;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SuggestionsTest {
    private String name;
    private Integer medicalCondition;
    private List<String> suggestions;

    public SuggestionsTest(String name, Integer medicalCondition, List<String> suggestions) {
        this.name = name;
        this.medicalCondition = medicalCondition;
        this.suggestions = suggestions;
    }

    @Parameterized.Parameters


    @Test
    public void testGetSuggestions() throws Exception {
        Preference preference = new Preference(name,medicalCondition,suggestions);
        assertEquals("Equals",suggestions,preference.getSuggestions());
    }

    @Test
    public void testSetSuggestions() throws Exception {

    }
}
