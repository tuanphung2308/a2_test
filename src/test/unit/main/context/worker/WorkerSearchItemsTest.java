package test.unit.main.context.worker;

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

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class WorkerSearchItemsTest {
    public String username;
    public String location;
    public String[] expectedResult;
    private ContextManager.ContextManagerWorkerI contextManagerWorkerI = new ContextManager.ContextManagerWorkerI();

    public WorkerSearchItemsTest(String username, String location, String[] expectedResult) {
        this.username = username;
        this.location = location;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                { "Jack", "A", new String[]{"Vivo City Shopping Centre"} },
                { "David", "B", new String[]{"Crescent Mall"} },
                { "David", "C", new String[]{"Dam Sen Parklands"} },
                { "David", "D", new String[]{"Ho Chi Minh City, Downtown"} },
                { "David", "E", new String[]{} },
                { "David", "", new String[]{} }
        };
        return Arrays.asList(data);
    }

    @Before
    public void before() throws Exception {
        Field communicatorField = (ContextManager.class).getDeclaredField("communicator");
        communicatorField.setAccessible(true);
        communicatorField.set(null, com.zeroc.Ice.Util.initialize());

        Field weatherField = (ContextManager.class).getDeclaredField("currentWeather");
        weatherField.setAccessible(true);
        weatherField.set(null, 0);

        Method method = (ContextManager.class).getDeclaredMethod("readCityInfo");
        method.setAccessible(true);

        Field cityInfo = (ContextManager.class).getDeclaredField("cityInfo");
        cityInfo.setAccessible(true);
        cityInfo.set(null, method.invoke(null));

        Method iniPreferenceWorker = (ContextManager.class).getDeclaredMethod("iniPreferenceWorker");
        iniPreferenceWorker.setAccessible(true);
        iniPreferenceWorker.invoke(null);

        contextManagerWorkerI.addUser("Jack", new Current());
        contextManagerWorkerI.addUser("David", new Current());
    }

    @Test
    public void testSearchItems() throws Exception{
        Field field = (ContextManager.class).getDeclaredField("users");
        field.setAccessible(true);
        LinkedHashMap<String, User> users = (LinkedHashMap<String, User>) field.get(null);
        users.get(username).sensorData.location = location;

        String[] results = contextManagerWorkerI.searchItems(username, new Current());

        assertArrayEquals("Should be equal", expectedResult, results);

//        contextManagerWorkerI.searchItems(username, new Current());
//        assertFalse(users.containsKey(username));
    }
}
