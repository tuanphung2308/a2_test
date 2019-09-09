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
public class InfoTest {
    private String name;
    private String location;
    private String info;
    private String expectedValue;
    private List<String> services = new ArrayList<>();

    public InfoTest(String name, String location, String info, String expectedValue) {
        this.name = name;
        this.info = info;
        this.location = location;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                {"Indooroopilly Shopping Centre", "A", "Indooroopilly Shopping Centre is a major regional shopping centre in the western suburb of\n" +
                                                                "Indooroopilly, Brisbane, Queensland, Australia. It is the largest shopping centre in the western suburbs of\n" +
                                                                "Brisbane, by gross area, and contains the only Myer store in that region.",
                                                        "Indooroopilly Shopping Centre is a major regional shopping centre in the western suburb of\n" +
                                                                "Indooroopilly, Brisbane, Queensland, Australia. It is the largest shopping centre in the western suburbs of\n" +
                                                                "Brisbane, by gross area, and contains the only Myer store in that region."},
                {"Garden City", "B","Garden City Shopping Centre is located 10km South of the Brisbane central business district\n" +
                                    "(CBD) and includes Myer, David Jones, Hoyts Cinema, Freedom and over 230 specialty stores",
                                    "Garden City Shopping Centre is located 10km South of the Brisbane central business district\n" +
                                    "(CBD) and includes Myer, David Jones, Hoyts Cinema, Freedom and over 230 specialty stores"},
                {"South Bank Parklands", "C", "The South Bank Parklands area was created as part of the rejuvenation\n" +
                                                      "of the industrial water front undertaken for World Expo 1988. The Parklands area contains many shops, a\n" +
                                                      "cinema complex, and a large number of restaurants as well as a man-made beach. A river promenade\n" +
                                                      "stretches the length of South Bank Parklands.",
                                              "The South Bank Parklands area was created as part of the rejuvenation\n" +
                                                      "of the industrial water front undertaken for World Expo 1988. The Parklands area contains many shops, a\n" +
                                                      "cinema complex, and a large number of restaurants as well as a man-made beach. A river promenade\n" +
                                                      "stretches the length of South Bank Parklands."},
                {"Brisbane City", "D", "The Brisbane central business district (CBD), or 'the City' is located on a point on the northern\n" +
                                                "bank of the Brisbane River. The triangular shaped area is bounded by the Brisbane River to the east, south\n" +
                                                "and west. The point, known at its tip as Gardens Point, slopes upward to the north-west where 'the city'\n" +
                                                "is bounded by parkland and the inner city suburb of Spring Hill to the north. The City is bounded to the\n" +
                                                "north-east by the suburb of Fortitude Valley.",
                                        "The Brisbane central business district (CBD), or 'the City' is located on a point on the northern\n" +
                                                "bank of the Brisbane River. The triangular shaped area is bounded by the Brisbane River to the east, south\n" +
                                                "and west. The point, known at its tip as Gardens Point, slopes upward to the north-west where 'the city'\n" +
                                                "is bounded by parkland and the inner city suburb of Spring Hill to the north. The City is bounded to the\n" +
                                                "north-east by the suburb of Fortitude Valley."},
        };
        return Arrays.asList(data);
    }

    @Test
    public void testGetInfo() throws Exception {
        LocationDetails locationDetails = new LocationDetails(name,location,info,services);
        assertEquals(expectedValue,locationDetails.getInfo());
    }

    @Test
    public void testSetInfo() throws Exception {
        LocationDetails locationDetails = new LocationDetails(name,location,info,services);
        locationDetails.setInfo(expectedValue);
        assertEquals(expectedValue,locationDetails.getInfo());
    }

}
