package test.main.preference;

import main.PreferenceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import support.Preference;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PrefRepoInitTest {
    PreferenceRepository preferenceRepository = new PreferenceRepository();
    @Test
    public void testReadPreferenceFunction() throws Exception{
        try {
            Method method = (PreferenceRepository.class).getDeclaredMethod("readPreference");
            method.setAccessible(true);
            List<Preference> results = (List<Preference>) method.invoke(preferenceRepository);
            Preference jackPref = new Preference(
                    "Jack",
                    2,
                    Arrays.asList(
                            "when 20 suggest shops",
                            "when 30 suggest pool",
                            "when APO suggest bowling",
                            "when weather suggest cinema"
                    )
            );
            Preference davidPref = new Preference(
                    "David",
                    3,
                    Arrays.asList(
                            "when 16 suggest pool",
                            "when APO suggest cinema",
                            "when weather suggest shops"
                    )
            );
            List<Preference> expectedResult = new ArrayList<>();
            expectedResult.add(jackPref);
            expectedResult.add(davidPref);
            for (int i = 0; i < expectedResult.size(); i++) {
                assertEquals("Equal", expectedResult.get(i).getName(), results.get(i).getName());
                assertEquals("Equal", expectedResult.get(i).getSuggestions(), results.get(i).getSuggestions());
                assertEquals("Equal", expectedResult.get(i).getMedicalCondition(), results.get(i).getMedicalCondition());
            }
        } catch(NoSuchMethodException e) {
        } catch(IllegalAccessException e) {
        } catch(InvocationTargetException e) {
        }
    }
}
