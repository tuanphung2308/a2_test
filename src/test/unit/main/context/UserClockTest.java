package test.unit.main.context;

import helper.User;
import main.ContextManager;
import main.PreferenceRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import support.Preference;
import test.unit.main.preference.PrefWorker;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class UserClockTest {
    public String username;
    public int tickTime;

    public UserClockTest(String username, int tickTime) {
        this.username = username;
        this.tickTime = tickTime;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                {"Jack", 5},
                {"David", 7}
        };
        return Arrays.asList(data);
    }

    @Before
    public void before() throws  Exception{
        Method initMethod = (PreferenceRepository.class).getDeclaredMethod("readPreference");
        initMethod.setAccessible(true);
        PrefWorker.setPreferences((List< Preference >) initMethod.invoke(null));

        PrefWorker prefWorker = new PrefWorker();
        Field field = (ContextManager.class).getDeclaredField("users");
        field.setAccessible(true);
        ((LinkedHashMap<String, User> )field.get(null)).put(username, prefWorker.getUserInfo(username));
    }

    @Test
    public void testResetClock() throws Exception {
        Method method = (ContextManager.class).getDeclaredMethod("resetClock", String.class);
        method.setAccessible(true);
        method.invoke(null, this.username);

        Field field = (ContextManager.class).getDeclaredField("users");
        field.setAccessible(true);
        LinkedHashMap<String, User> users = (LinkedHashMap<String, User>) field.get(null);

        assertEquals("Should be equal to 0", 0, users.get(username).clock);
    }

    @Test
    public void testTickClock() throws Exception{
        Method method = (ContextManager.class).getDeclaredMethod("tickClock", String.class);
        method.setAccessible(true);
        for (int i = 0; i < tickTime; i ++) {
            method.invoke(null, this.username);
        }

        Field field = (ContextManager.class).getDeclaredField("users");
        field.setAccessible(true);
        LinkedHashMap<String, User> users = (LinkedHashMap<String, User>) field.get(null);

        assertEquals("Should be equal to 1", tickTime, users.get(username).clock);
    }
}
