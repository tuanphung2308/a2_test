package test.main.context;

import com.zeroc.Ice.Current;
import helper.User;
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

    @Test
    public void testCheckWeather() throws Exception{

    }
}
