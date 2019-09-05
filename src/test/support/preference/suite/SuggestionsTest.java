package test.support.preference.suite;

import com.zeroc.Ice.Exception;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import support.Preference;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

//@RunWith(Parameterized.class)
public class SuggestionsTest {
    private String name;
    private Integer medicalCondition;
    private List<String> suggestions;

    public SuggestionsTest() {
    }

//    public SuggestionsTest(String name, Integer medicalCondition, List<String> suggestions) {
//        this.name = name;
//        this.medicalCondition = medicalCondition;
//        this.suggestions = suggestions;
//    }

//    @Parameterized.Parameters
//    public static Collection<Object[]> data() {
//        Object[][] data = new Object[][] {
//                { "pool" },
//                {"coffeeshop"},
//                { "shop"},
//        };
//        return Arrays.asList(data);
//    }

    @Test
    public void testGetSuggestions() throws Exception {
        Preference preference = new Preference(name,medicalCondition,suggestions);
        assertEquals("Equals",suggestions,preference.getSuggestions());
    }

    @Test
    public void testSetSuggestions() throws Exception {
        List<String> actual = Arrays.asList("pool", "coffeeshop", "shop");
        List<String> expected = Arrays.asList("pool", "coffeeshop", "shop");
        Preference preference = new Preference(name,medicalCondition,suggestions);
        preference.setSuggestions(actual);
        assertEquals(expected,preference.getSuggestions());
    }
}
