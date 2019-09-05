package test.main.context;

import helper.User;
import main.ContextManager;
import main.PreferenceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import support.Preference;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class AQIThreshHoldTest {

    public Integer medicalConditionType;
    public Integer aqi;
    public Integer expectedVal;

    public AQIThreshHoldTest(Integer medicalConditionType, Integer aqi, Integer expectedVal) {
        this.medicalConditionType = medicalConditionType;
        this.aqi = aqi;
        this.expectedVal = expectedVal;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                { 1, 0, 30},
                { 1, 39, 30},
                { 1, 50, 30},

                { 1, 51, 15},
                { 1, 60, 15},
                { 1, 100, 15},

                { 1, 101, 10},
                { 1, 122, 10},
                { 1, 150, 10},

                { 1, 151, 5},
                { 1, 177, 5},
                { 1, 200, 5},

                { 2, 0, 60},
                { 2, 39, 60},
                { 2, 50, 60},

                { 2, 51, 30},
                { 2, 60, 30},
                { 2, 100, 30},

                { 2, 101, 20},
                { 2, 122, 20},
                { 2, 150, 20},

                { 2, 151, 10},
                { 2, 177, 10},
                { 2, 200, 10},

                { 3, 0, 90},
                { 3, 39, 90},
                { 3, 50, 90},

                { 3, 51, 45},
                { 3, 60, 45},
                { 3, 100, 45},

                { 3, 101, 30},
                { 3, 122, 30},
                { 3, 150, 30},

                { 3, 151, 15},
                { 3, 177, 15},
                { 3, 200, 15},

                {1, -2, null},
                {1, 20000, null},
                {1, 2147483647, null},
                {1, -2147483647, null},
        };
        return Arrays.asList(data);
    }

    @Test
    public void testThreshHold() throws Exception {
        User user = new User();
        user.sensorData.aqi = this.aqi;
        user.medicalConditionType = this.medicalConditionType;
        Method method = (ContextManager.class).getDeclaredMethod("calculateapoThreshhold", User.class);
        method.setAccessible(true);
        Integer result = (Integer) method.invoke(null, user);
        System.out.println("Medical Condition: " + medicalConditionType + " & AQI: " + this.aqi);
        assertEquals("Should be equal", expectedVal, result);
    }
}
