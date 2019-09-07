package test.unit.support.preference.suite;

import com.zeroc.Ice.Exception;
import org.junit.Test;
import support.Preference;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class MedicalConditionTest {
    private String name;
    private Integer medicalCondition;
    private List<String> suggestions;

    public MedicalConditionTest() {

    }

    @Test
    public void testGetMedicalCondition() throws Exception {
        Preference preference = new Preference(name,medicalCondition,suggestions);
        assertEquals("Equals",medicalCondition,preference.getMedicalCondition());
    }

    @Test
    public void testSetMedicalCondition() throws Exception {
        Preference preference = new Preference(name,medicalCondition,suggestions);
        preference.setMedicalCondition(1);
        assertEquals("1",String.valueOf(preference.getMedicalCondition()));
    }
    @Test
    public void testSetMedicalCondition2() throws Exception {
        Preference preference = new Preference(name,medicalCondition,suggestions);
        preference.setMedicalCondition(2);
        assertEquals("2",String.valueOf(preference.getMedicalCondition()));
    }
    @Test
    public void testSetMedicalCondition3() throws Exception {
        Preference preference = new Preference(name,medicalCondition,suggestions);
        preference.setMedicalCondition(3);
        assertEquals("3",String.valueOf(preference.getMedicalCondition()));
    }
}
