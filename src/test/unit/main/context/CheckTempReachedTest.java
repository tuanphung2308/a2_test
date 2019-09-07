package test.unit.main.context;

import helper.User;
import main.ContextManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckTempReachedTest {
    public int currentTemperature;
    public int[] tempThreshholds;
    public boolean expectedResult;

    public CheckTempReachedTest(int currentTemperature, int[] tempThreshholds, boolean expectedResult) {
        this.currentTemperature = currentTemperature;
        this.tempThreshholds = tempThreshholds;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                { 30, new int[]{ 50 }, false},
                { 50, new int[]{ 50 }, true},
                { 52, new int[]{ 50 }, true},

                { 49, new int[]{ 50, 60 }, false},
                { 52, new int[]{ 50, 60 }, true},
                { 62, new int[]{ 50, 60 }, true},
                { 50, new int[]{ 50, 60 }, true},
                { 60, new int[]{ 50, 60 }, true},
        };
        return Arrays.asList(data);
    }

    @Before
    public void before() throws Exception {
//        Field field = (ContextManager.class).getDeclaredField("users");
//        field.setAccessible(true);
    }

    @Test
    public void testCheckTempReached() throws Exception {
        User user = new User();
        user.sensorData.temperature = currentTemperature;
        user.tempThreshholds = tempThreshholds;

        Method method = (ContextManager.class).getDeclaredMethod("checkTempReached", User.class);
        method.setAccessible(true);
        assertEquals("Result should be equal", expectedResult, method.invoke(null, user));
    }
}
