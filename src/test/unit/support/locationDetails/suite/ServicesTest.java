package test.unit.support.locationDetails.suite;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import support.LocationDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ServicesTest {
    private String name;
    private String location;
    private String info;
    private List<String> services;
    private List<String> expectedValue;

    public ServicesTest(String location, List<String> services, List<String> expectedValue) {
        this.location = location;
        this.services = services;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        List<String> services = new ArrayList<>();
        services.add("cinema");
        services.add("restaurants");
        services.add("pool");
        services.add("shops");

        List<String> services2 = new ArrayList<>();
        services2.add("cinema");
        services2.add("restaurants");
        services2.add("pool");
        services2.add("shops");

        List<String> services3 = new ArrayList<>();
        services3.add("restaurants");
        services3.add("pool");
        services3.add("shops");
        services3.add("Ferris wheel");

        List<String> services4 = new ArrayList<>();
        services4.add("restaurants");
        services4.add("shops");
        services4.add("market");
        services4.add("bowling");

        Object[][] data = new Object[][] {
                {"A", services, services},
                {"B", services2, services2},
                {"C", services3, services3},
                {"D", services4, services4},
        };
        return Arrays.asList(data);
    }

    @Test
    public void testGetServices() throws Exception {
        LocationDetails locationDetails = new LocationDetails(name,location,info,services);
        assertEquals(expectedValue,locationDetails.getServices());
    }

    @Test
    public void testSetServices() throws Exception {
        LocationDetails locationDetails = new LocationDetails(name,location,info,services);
        locationDetails.setServices(expectedValue);
        assertEquals(expectedValue,locationDetails.getServices());
    }

}
