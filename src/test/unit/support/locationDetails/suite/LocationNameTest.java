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
public class LocationNameTest {
    private String name;
    private String expectedValue;
    private String location;
    private String info;
    private List<String> services = new ArrayList<>();

    public LocationNameTest(String name, String expectedValue) {
        this.name = name;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                {"Indooroopilly Shopping Centre", "Indooroopilly Shopping Centre"},
                {"Garden City", "Garden City"},
                {"South Bank Parklands", "South Bank Parklands"},
                {"Brisbane City", "Brisbane City"},
        };
        return Arrays.asList(data);
    }

    @Test
    public void testGetName() throws Exception {
        LocationDetails locationDetails = new LocationDetails(name,location,info,services);
        assertEquals(expectedValue,locationDetails.getName());
    }

    @Test
    public void testSetName() throws Exception {
        LocationDetails locationDetails = new LocationDetails(name,location,info,services);
        locationDetails.setName(expectedValue);
        assertEquals(expectedValue,locationDetails.getName());
    }

}
