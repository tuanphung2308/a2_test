package test.unit.support.locationDetails;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.unit.support.locationDetails.suite.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        InfoTest.class,
        LocationNameTest.class,
        LocationTest.class,
        ServicesTest.class,
        ToStringTest1.class,
})

public class LocationDetailsSuite {
}
