package test.unit.support.locationDetails.suite;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import support.LocationDetails;
import support.Preference;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

    public class ToStringTest1 {
    private String name;
    private String location;
    private String info;
    private List<String> services;

    public ToStringTest1() {
    }

    @Test
    public void testToString() throws Exception {
        List<String> actual = Arrays.asList("cinema", "restaurants", "pool", "shops");
        LocationDetails locationDetails = new LocationDetails("Indooroopilly Shopping Centre","A","Indooroopilly Shopping Centre is a major regional shopping centre in the western suburb of Indooroopilly, " +
                "Brisbane, Queensland, Australia. It is the largest shopping centre in the western suburbs of Brisbane, by gross area, " +
                "and contains the only Myer store in that region.",actual);
        this.name = "Indooroopilly Shopping Centre";
        this.location = "A";
        this.info = "Indooroopilly Shopping Centre is a major regional shopping centre in the western suburb of Indooroopilly, " +
                    "Brisbane, Queensland, Australia. It is the largest shopping centre in the western suburbs of Brisbane, by gross area, " +
                    "and contains the only Myer store in that region.";
        this.services = actual;
        String expected = "LocationDetails [name=" + name + ", location=" + location + ", info=" + info + ", services=" + services + "]";
        assertEquals(expected,locationDetails.toString());
    }

}
