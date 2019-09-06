package test.unit.support.preference;

import static org.junit.Assert.assertEquals;

import java.util.List;

//@RunWith(Parameterized.class)
public class PreferenceTest {
    private String name;
    private Integer medicalCondition;
    private List<String> suggestions;

    public PreferenceTest(String name, Integer medicalCondition, List<String> suggestions) {
        this.name = name;
        this.medicalCondition = medicalCondition;
        this.suggestions = suggestions;
    }
}