package test.main.preference;

import main.PreferenceRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RunWith(Parameterized.class)
public class PreferenceRepositoryTest {
    PreferenceRepository preferenceRepository = new PreferenceRepository();
    @Before
    public void before() throws Exception {
        try {
            Method method = (PreferenceRepository.class).getMethod("readPreference");
            method.setAccessible(true);
            method.invoke(preferenceRepository);
        } catch(NoSuchMethodException e) {
        } catch(IllegalAccessException e) {
        } catch(InvocationTargetException e) {
        }
    }
}
