package test.unit.support;

import main.EnviroAPPUI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import support.HandleUserInput;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Parameterized.class)
public class HandleUserInputTest {
    public static int FIRST_MENU = 1;
    public static int SECOND_MENU = 2;
    public static int EXIT = 3;
    public static int INVALID_CHOICE = 4;

    public String choice;
    public int expected;

    public HandleUserInputTest(String choice, int expected) {
        this.choice = choice;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{
                {"1", FIRST_MENU},
                {"2", SECOND_MENU},
                {"E", EXIT},
                {"e", EXIT},
                {"4", INVALID_CHOICE},
                {"q", INVALID_CHOICE},
                {"", INVALID_CHOICE},
                {"dsfasfsadfds", INVALID_CHOICE},
        };
        return Arrays.asList(data);
    }

    public int handleInput(String option) {
        switch (option) {
            case "1":
                return FIRST_MENU;
            case "2":
                return SECOND_MENU;
            case "E":
                return EXIT;
            default:
                return INVALID_CHOICE;
        }
    }

    @Test
    public void userInput() {
        assertEquals("Menu choice should be equal", handleInput(choice), expected);
    }
}
