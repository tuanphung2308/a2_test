package test.support.preference;

import static org.junit.Assert.assertEquals;
import com.zeroc.Ice.Exception;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import support.Preference;

import java.util.List;

@RunWith(Parameterized.class)
public class PreferenceTest {
    private String name;
    private Integer medicalCondition;
    private List<String> suggestions;

    public PreferenceTest(String name, Integer medicalCondition, List<String> suggestions) {
        this.name = name;
        this.medicalCondition = medicalCondition;
        this.suggestions = suggestions;
    }

    @Test
    public void testToString() throws Exception {

    }
}
