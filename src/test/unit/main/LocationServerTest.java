package test.unit.main;

import main.LocationServer;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;

/**
 * LocationServer Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Sep 4, 2019</pre>
 */
public class LocationServerTest {
    @Test
    public void testReadConfig() throws Exception {
        Method method = (LocationServer.class).getDeclaredMethod("readConfig");
        method.setAccessible(true);
        LinkedHashMap<String, String> actual = (LinkedHashMap<String, String>) method.invoke(null);
        LinkedHashMap<String, String> expect = new LinkedHashMap<>();
        expect.put("A", "Indoor");
        expect.put("B", "Indoor");
        expect.put("C", "Outdoor");
        expect.put("D", "Outdoor");
        assertEquals("Location config read correctly", expect, actual);
    }

} 
