package test.unit.support.preference.suite;

import com.zeroc.Ice.Exception;
import org.junit.Test;
import support.Preference;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ToStringTest {
    private String name;
    private Integer medicalCondition;
    private List<String> suggestions;

    public ToStringTest() {
    }

    @Test
    public void testToString() throws Exception {
        List<String> actual = Arrays.asList("pool", "coffeeshop", "shop");
        Preference preference = new Preference("Jack",1,actual);
        this.name = "Jack";
        this.medicalCondition = 1;
        this.suggestions = actual;
        String expected = "Preference [name=" + name + ", medical condition=" + medicalCondition + ", suggestions=" + suggestions + "]";
        assertEquals(expected,preference.toString());
    }
}
