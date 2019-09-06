package test.main.context;

import com.zeroc.Ice.Current;
import main.ContextManager;
import main.PreferenceRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

//@RunWith(Parameterized.class)
public class CheckWeatherTest {
    @Before
    public void before() throws Exception {
        Field communicatorField = (ContextManager.class).getDeclaredField("communicator");
        communicatorField.setAccessible(true);
        communicatorField.set(null, com.zeroc.Ice.Util.initialize());

        Method iniPreferenceWorker = (ContextManager.class).getDeclaredMethod("iniPreferenceWorker");
        iniPreferenceWorker.setAccessible(true);
        iniPreferenceWorker.invoke(null);

        ContextManager.ContextManagerWorkerI contextManagerWorkerI = new ContextManager.ContextManagerWorkerI();
        contextManagerWorkerI.addUser("Jack", new Current());

//        Field field = (ContextManager.class).getDeclaredField("cityInfo");
//        field.setAccessible(true);
//        field.set(null, readCityInfoMethod.invoke(null));
    }

    @Test
    public void testCheckWeather() {
        
    }
}
