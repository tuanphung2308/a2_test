package test.main.context;

import main.ContextManager;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@RunWith(Parameterized.class)
public class CheckWeatherTest {
    @Before
    public void before() throws Exception {
        Field communicatorField = (ContextManager.class).getDeclaredField("communicator");
        communicatorField.setAccessible(true);
        communicatorField.set(null, com.zeroc.Ice.Util.initialize());

        Method iniPreferenceWorker = (ContextManager.class).getDeclaredMethod("iniPreferenceWorker");
        iniPreferenceWorker.setAccessible(true);
        iniPreferenceWorker.invoke(null);

        Method readCityInfoMethod = (ContextManager.class).getDeclaredMethod("readCityInfo");
        readCityInfoMethod.setAccessible(true);

        Field field = (ContextManager.class).getDeclaredField("cityInfo");
        field.setAccessible(true);
        field.set(null, readCityInfoMethod.invoke(null));
    }
}
