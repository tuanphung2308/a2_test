package test.unit.support.preference.suite;

import com.zeroc.Ice.Exception;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import support.Preference;

import java.util.*;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MedicalConditionTest {
    private String name;
    private Integer medicalCondition;
    private Integer expectedValue;
    private List<String> suggestions = new ArrayList<>();

    public MedicalConditionTest(String name, Integer medicalCondition, Integer expectedValue) {
        this.name = name;
        this.medicalCondition = medicalCondition;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        Object[][] data = new Object[][] {
                {"Jack", 1, 1},
                {"Jack", 2, 2},
                {"Jack", 3, 3},
                {"David", 1, 1},
                {"David", 2, 2},
                {"David", 3, 3}
        };
        return Arrays.asList(data);
    }
    @Test
    public void testGetName() throws Exception {
        Preference preference = new Preference(name,medicalCondition,suggestions);
        assertEquals(expectedValue,medicalCondition,preference.getMedicalCondition());
    }

    @Test
    public void testSetMedicalCondition() throws Exception {
        Preference preference = new Preference(name,medicalCondition,suggestions);
        preference.setMedicalCondition(expectedValue);
        assertEquals(expectedValue,preference.getMedicalCondition());
    }
}
