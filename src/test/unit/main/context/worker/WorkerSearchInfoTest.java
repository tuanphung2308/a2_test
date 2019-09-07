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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class WorkerSearchInfoTest {
    public String location;
    public String expectedResult;
    private ContextManager.ContextManagerWorkerI contextManagerWorkerI = new ContextManager.ContextManagerWorkerI();

    public WorkerSearchInfoTest(String location, String expectedResult) {
        this.location = location;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                { "Vivo City Shopping Centre", "Vivo City Shopping Centre is a major regional shopping centre in the southern suburb of Ho Chi Minh City, Vietnam. It is the second largest shopping centre in the southern suburbs of Ho Chi Minh City, by gross area, and contains the only H&M store in that region." },
                { "Crescent Mall", "Crescent Mall Shopping Centre is located 10km South of the Ho Chi Minh City central business district(CBD) and includes Banana Republic, Baskin Robins, CGV Cinema, Bobapop and over 130 specialty stores." },
                { "Dam Sen Parklands", "The Dam Sen Parklands area was created as part of the rejuvenation of the industrial upgrade undertaken for World Expo 1988. The Parklands area is spacious with plenty of green and spaces for all ages. A big lake promenade stretches the area of Dam Sen Parklands."},
                { "Ho Chi Minh City, Downtown", "The Ho Chi Minh City central business district (CBD), or 'the City' is located on a central point in district One. The point, known at its tip as Central Point, slopes upward to the north-west where 'the city' is bounded by parkland and the inner city suburb of District 3, District 4 and District 5."},
                { "", "Not Found"},
                { "asdasdasdasdasdasasdas", "Not Found"}
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

        String results = contextManagerWorkerI.searchInfo(location, new Current());
        assertEquals("Should be equals", expectedResult, results);
//        assertArrayEquals("Should be equal", expectedResult, results);

//        contextManagerWorkerI.searchItems(username, new Current());
//        assertFalse(users.containsKey(username));
    }
}
