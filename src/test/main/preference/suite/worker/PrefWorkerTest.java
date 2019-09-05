package test.main.preference.suite.worker;

import helper.User;
import main.PreferenceRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import support.Preference;
import test.main.preference.PrefWorker;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PrefWorkerTest {
    private String name;
    private int[] tempThreshHolds;

    public PrefWorkerTest(String name, int[] t) {
        this.name = name;
        this.tempThreshHolds = t;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                { "Jack", new int[]{20, 30}},
                { "David", new int[]{16}}
        };
        return Arrays.asList(data);
    }
    @Before
    public void before() throws Exception {
        Method initMethod = (PreferenceRepository.class).getDeclaredMethod("readPreference");
        initMethod.setAccessible(true);
        PrefWorker.setPreferences((List< Preference >) initMethod.invoke(null));
    }

    @Test
    public void testGetUserInfo() {
        PrefWorker prefWorker = new PrefWorker();
        User user = prefWorker.getUserInfo(name);
        for (int i = 0; i < tempThreshHolds.length; i ++) {
            assertEquals("Temp threshold should be equal", tempThreshHolds[i], user.tempThreshholds[i]);
        }
        assertEquals("weather", 0, user.weather);
        assertEquals("clock", 0, user.clock);
        assertEquals("apo Thresh-hold", 0, user.apoThreshhold);
        assertEquals("apoReached", false, user.apoReached);
        assertEquals("tempReached", false, user.tempReached);
        assertEquals("Sensor Data", null, user.sensorData);
    }

    @Test
    public void testGetPreference() {
        //TODO:
    }
}
