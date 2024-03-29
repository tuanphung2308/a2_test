package test.unit.support.preference;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.unit.support.preference.suite.MedicalConditionTest;
import test.unit.support.preference.suite.SuggestionsTest;
import test.unit.support.preference.suite.UserNameTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserNameTest.class,
        MedicalConditionTest.class,
        SuggestionsTest.class
})
public class PreferenceSuite {

}

