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

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class UserNameTest {
    private String name;
    private Integer medicalCondition = 1;
    private String expectedValue;
    private List<String> suggestions = new ArrayList<>();

    public UserNameTest(String name, String expectedValue) {
        this.name = name;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                {"Jack", "Jack"},
                {"David", "David"},
        };
        return Arrays.asList(data);
    }

    @Test
    public void testGetName() throws Exception {
        Preference preference = new Preference(name,medicalCondition,suggestions);
        assertEquals(expectedValue,name,preference.getName());
    }

    @Test
    public void testSetName() throws Exception {
        Preference preference = new Preference(name,medicalCondition,suggestions);
        preference.setName(expectedValue);
        assertEquals(expectedValue,preference.getName());
    }
}
