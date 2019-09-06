package test.unit.main.context;

import main.ContextManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class LocationsByServiceTest {
    public String service;
    public List<String> expectedResults;

    public LocationsByServiceTest(String service, List<String> expectedResults) {
        this.service = service;
        this.expectedResults = expectedResults;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{
                {
                    "shops",
                        Arrays.asList(
                                "Vivo City Shopping Centre",
                                "Crescent Mall",
                                "Dam Sen Parklands",
                                "Ho Chi Minh City, Downtown"
                                )
                },
                {
                        "cinema",
                        Arrays.asList(
                                "Vivo City Shopping Centre",
                                "Crescent Mall"
                        )
                },
                {
                        "Ferris wheel",
                        Arrays.asList(
                                "Dam Sen Parklands"
                        )
                },
                {
                        "bowling",
                        Arrays.asList(
                                "Vivo City Shopping Centre",
                                "Ho Chi Minh City, Downtown"
                        )
                },
                {
                        "market",
                        Arrays.asList(
                                "Ho Chi Minh City, Downtown"
                        )
                },
                {
                        "",
                        Arrays.asList()
                },
                {
                        "asdasdsaidaiopqwdpoqwopdkopaopdasdas",
                        Arrays.asList()
                },
                {
                        "123123123123",
                        Arrays.asList()
                },
                {
                        "a",
                        Arrays.asList()
                },
        };
        return Arrays.asList(data);
    }

    @Before
    public void before() throws Exception {
        Field communicatorField = (ContextManager.class).getDeclaredField("communicator");
        communicatorField.setAccessible(true);
        communicatorField.set(null, com.zeroc.Ice.Util.initialize());

        Method initMethod = (ContextManager.class).getDeclaredMethod("iniLocationMapper");
        initMethod.setAccessible(true);
        initMethod.invoke(null);

        Method readCityInfoMethod = (ContextManager.class).getDeclaredMethod("readCityInfo");
        readCityInfoMethod.setAccessible(true);

        Field field = (ContextManager.class).getDeclaredField("cityInfo");
        field.setAccessible(true);
        field.set(null, readCityInfoMethod.invoke(null));
    }

    @Test
    public void testGetLocationByService() throws Exception {
        Method method = (ContextManager.class).getDeclaredMethod("getLocationsByService", String.class);
        method.setAccessible(true);
        List<String> results = (List<String>) method.invoke(null, service);
        assertEquals("Should be equal", expectedResults, results);
    }
}
