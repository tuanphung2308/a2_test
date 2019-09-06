package test.main.context;

import com.zeroc.Ice.Current;
import helper.User;
import main.ContextManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class WorkerAddUserTest {
    public String username;
    public LinkedHashMap<String, User> expected;

    public WorkerAddUserTest(String username, LinkedHashMap<String, User> expected) {
        this.username = username;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                {"Jack", null},
                {"David", null}
        };
        return Arrays.asList(data);
    }

    @Before
    public void before() throws Exception {
        Field communicatorField = (ContextManager.class).getDeclaredField("communicator");
        communicatorField.setAccessible(true);
        communicatorField.set(null, com.zeroc.Ice.Util.initialize());

        Method iniPreferenceWorker = (ContextManager.class).getDeclaredMethod("iniPreferenceWorker");
        iniPreferenceWorker.setAccessible(true);
        iniPreferenceWorker.invoke(null);

        Field weatherField = (ContextManager.class).getDeclaredField("currentWeather");
        weatherField.setAccessible(true);
        weatherField.set(null, 0);

        ContextManager.ContextManagerWorkerI contextManagerWorkerI = new ContextManager.ContextManagerWorkerI();
        contextManagerWorkerI.addUser(username, new Current());
    }

    @Test
    public void testAddUser() throws Exception{
        Field field = (ContextManager.class).getDeclaredField("users");
        field.setAccessible(true);
        LinkedHashMap<String, User> users = (LinkedHashMap<String, User>) field.get(null);
        assertTrue(users.containsKey(username));
    }
}
