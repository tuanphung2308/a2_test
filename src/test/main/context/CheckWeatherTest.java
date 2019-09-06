package test.main.context;

import com.zeroc.Ice.Current;
<<<<<<< HEAD
=======
import helper.User;
>>>>>>> b57de188ed89968dbb7f10350a863ef3ac8bc70d
import main.ContextManager;
import main.PreferenceRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;

<<<<<<< HEAD
//@RunWith(Parameterized.class)
=======
>>>>>>> b57de188ed89968dbb7f10350a863ef3ac8bc70d
public class CheckWeatherTest {
    public String username;
    public LinkedHashMap<String, User> expected;

    public CheckWeatherTest(String username, LinkedHashMap<String, User> expected) {
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

    }

<<<<<<< HEAD
        ContextManager.ContextManagerWorkerI contextManagerWorkerI = new ContextManager.ContextManagerWorkerI();
        contextManagerWorkerI.addUser("Jack", new Current());

//        Field field = (ContextManager.class).getDeclaredField("cityInfo");
//        field.setAccessible(true);
//        field.set(null, readCityInfoMethod.invoke(null));
    }

    @Test
    public void testCheckWeather() {
        
=======
    @Test
    public void testCheckWeather() throws Exception{

>>>>>>> b57de188ed89968dbb7f10350a863ef3ac8bc70d
    }
}
