package test.unit.support.preference.suite;

import com.zeroc.Ice.Exception;
import org.junit.Test;
import support.Preference;

import java.util.List;

import static org.junit.Assert.assertEquals;


//@RunWith(Parameterized.class)
public class UserNameTest {
    private String name;
    private Integer medicalCondition;
    private List<String> suggestions;

    public UserNameTest() {
    }

//    public UserNameTest(String name, Integer medicalCondition, List<String> suggestions) {
//        this.name = name;
//        this.medicalCondition = medicalCondition;
//        this.suggestions = suggestions;
//    }

//    @Parameterized.Parameters
//    public static String[] Uname() {
//        UserNameTest userNameTest = new UserNameTest();
//        String[] userName = new String[]{"Jack"};
//        userNameTest.name = userName[0];
//        return userName;
//    }

    @Test
    public void testGetName() throws Exception {
        Preference preference = new Preference(name,medicalCondition,suggestions);
        assertEquals("Equals",name,preference.getName());
    }

    @Test
    public void testSetName() throws Exception {
        Preference preference = new Preference(name,medicalCondition,suggestions);
        preference.setName("Jin");
        assertEquals("Jin",preference.getName());
    }
}
