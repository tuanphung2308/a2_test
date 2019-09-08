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
public class LocationTest {
    private String name;
    private String location;
    private String expectedValue;
    private String info;
    private List<String> services = new ArrayList<>();

    public LocationTest(String name, String location, String expectedValue) {
        this.name = name;
        this.location = location;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                {"Indooroopilly Shopping Centre", "A", "A"},
                {"Garden City", "B", "B"},
                {"South Bank Parklands", "C", "C"},
                {"Brisbane City", "D", "D"}
        };
        return Arrays.asList(data);
    }

    @Test
    public void testGetLocation() throws Exception {
        LocationDetails locationDetails = new LocationDetails(name,location,info,services);
        assertEquals(expectedValue,locationDetails.getLocation());
    }

    @Test
    public void testSetLocation() throws Exception {
        LocationDetails locationDetails = new LocationDetails(name,location,info,services);
        locationDetails.setLocation(expectedValue);
        assertEquals(expectedValue,locationDetails.getLocation());
    }


}
