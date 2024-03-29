package test.unit.main.context;

import com.zeroc.Ice.Current;
import helper.*;
import main.ContextManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ReportFunctionTest {
    private HashMap<String, Boolean> hashMap = new HashMap<>();
    private static LinkedHashMap<String, User> users = new LinkedHashMap<>();
    private static final String INDOOR = "Indoor";
    private static final String OUTDOOR = "Outdoor";
    private static final String APO = "APO";
    private static final String TEMPERATURE = "Temperature";
    private static final String WEATHER = "Weather";
    private static final Integer NORMAL = 0;
    private static LocationWorkerPrx locationWorker;
    private User user = new User();
    public int[] tempThreshholds;
    public int medicalCondition;
    public int currentWeather = 0;
    public int currentClock = 0;
    public String previouslocationStatus;
    public String currentLocationStatus;
    public int previousaqi;
    public int previousTemperature;
    public int currentaqi;
    public int currentTemperature;
    public int expectedClock;
    public boolean expectedApoReached;
    public boolean expectedTempReached;
    public boolean apoReached;
    public boolean tempReached;

    private SensorData sensorData = new SensorData();

    public ReportFunctionTest(int[] tempThreshholds, int medicalCondition, int currentWeather, int currentClock, String previouslocationStatus, String currentLocationStatus, int previousaqi, int previousTemperature, int currentaqi, int currentTemperature, int expectedClock, boolean expectedApoReached, boolean expectedTempReached) {
        this.tempThreshholds = tempThreshholds;
        this.medicalCondition = medicalCondition;
        this.currentWeather = currentWeather;
        this.currentClock = currentClock;
        this.previouslocationStatus = previouslocationStatus;
        this.currentLocationStatus = currentLocationStatus;
        this.previousaqi = previousaqi;
        this.previousTemperature = previousTemperature;
        this.currentaqi = currentaqi;
        this.currentTemperature = currentTemperature;
        this.expectedClock = expectedClock;
        this.expectedApoReached = expectedApoReached;
        this.expectedTempReached = expectedTempReached;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                {new int[]{25, 30}, 1, // temp thresh, med cond
                        0 , 0, // weather, clock
                        INDOOR, INDOOR,  //previous, current loc,
                        0, 20, // previous aqi, temp
                        0, 20, // current aqi, temp
                        0, //expected clock
                        false, false}, //expected apo, temp reached
                {new int[]{20, 30}, 1,
                        0 , 0,
                        INDOOR, INDOOR, 0,
                        20, 0,
                        20, 0,
                        false, true},
                {new int[]{25, 30}, 1, // temp thresh, med cond
                        0 , 0, // weather, clock
                        INDOOR, INDOOR,  //previous, current loc,
                        0, 20, // previous aqi, temp
                        0, 26, // current aqi, temp
                        0, //expected clock
                        false, true}, //expected apo, temp reached
                {new int[]{25, 31}, 1, // temp thresh, med cond
                        0 , 0, // weather, clock
                        INDOOR, INDOOR,  //previous, current loc,
                        0, 20, // previous aqi, temp
                        0, 26, // current aqi, temp
                        0, //expected clock
                        false, true}, //expected apo, temp reached
                //OUTDOOR - OUTDOOR only apo reached
                {new int[]{25, 30}, 1, // temp thresh, med cond
                        0 , 10, // weather, clock
                        OUTDOOR, OUTDOOR,  //previous, current loc,
                        50, 20, // previous aqi, temp
                        50, 24, // current aqi, temp
                        11, //expected clock
                        false, false}, //expected apo, temp reached
                {new int[]{25, 30}, 1, // temp thresh, med cond
                        0 , 29, // weather, clock
                        OUTDOOR, OUTDOOR,  //previous, current loc,
                        50, 20, // previous aqi, temp
                        50, 24, // current aqi, temp
                        30, //expected clock
                        true, false}, //expected apo, temp reached
                {new int[]{25, 30}, 1, // temp thresh, med cond
                        0 , 30, // weather, clock
                        OUTDOOR, OUTDOOR,  //previous, current loc,
                        50, 20, // previous aqi, temp
                        50, 24, // current aqi, temp
                        30, //expected clock // should stop once it reached the threshhold
                        true, false}, //expected apo, temp reached
                //INDOOR - OUTDOOR only apo reached
                {new int[]{25, 30}, 1, // temp thresh, med cond
                        0 , 0, // weather, clock
                        INDOOR, OUTDOOR,  //previous, current loc,
                        50, 20, // previous aqi, temp
                        50, 24, // current aqi, temp
                        1, //expected clock
                        false, false},
                //OUTDOOR - INDOOR only apo reached
                {new int[]{25, 30}, 1, // temp thresh, med cond
                        0 , 10, // weather, clock
                        OUTDOOR, INDOOR,  //previous, current loc,
                        50, 20, // previous aqi, temp
                        50, 24, // current aqi, temp
                        0, //expected clock
                        false, false}, //expected apo, temp reached
                {new int[]{25, 30}, 1, // temp thresh, med cond
                        0 , 29, // weather, clock
                        OUTDOOR, INDOOR,  //previous, current loc,
                        50, 20, // previous aqi, temp
                        50, 24, // current aqi, temp
                        0, //expected clock
                        false, false}, //expected apo, temp reached
                {new int[]{25, 30}, 1, // temp thresh, med cond
                        0 , 30, // weather, clock
                        OUTDOOR, INDOOR,  //previous, current loc,
                        50, 20, // previous aqi, temp
                        50, 24, // current aqi, temp
                        0, //expected clock // should stop once it reached the threshhold
                        false, false}, //expected apo, temp reached
                //INDOOR - INDOOR only apo reached
                {new int[]{25, 30}, 1, // temp thresh, med cond
                        0 , 0, // weather, clock
                        INDOOR, INDOOR,  //previous, current loc,
                        50, 20, // previous aqi, temp
                        50, 24, // current aqi, temp
                        0, //expected clock
                        false, false}, //expected apo, temp reached
        };
        return Arrays.asList(data);
    }
    @Before
    public void before() throws Exception{
        this.sensorData = new SensorData();
        this.sensorData.temperature = currentTemperature;
        this.sensorData.aqi = currentaqi;

        user.medicalConditionType = this.medicalCondition;
        user.tempThreshholds = this.tempThreshholds;
        user.sensorData = this.sensorData;
        user.apoThreshhold = calculateapoThreshhold(user);
    }

    @Test
    public void testReport() throws Exception{
        report(this.sensorData, null);
        assertEquals("Clock should be equal", expectedClock, currentClock);
        assertEquals("apoReached?", expectedApoReached, apoReached);
        assertEquals("tempReached?", expectedTempReached, tempReached);
    }

    private static Integer calculateapoThreshhold(User user) throws Exception{
        Method method = (ContextManager.class).getDeclaredMethod("calculateapoThreshhold", User.class);
        method.setAccessible(true);
        Integer result = (Integer) method.invoke(null, user);
        return result;
    }

    private boolean checkapoReached(User user) {
        return this.currentClock == user.apoThreshhold;
    }

    private static boolean checkTempReached(User user) {
        int temperature = user.sensorData.temperature;
        List<Integer> tempThreshholds = Arrays.stream(user.tempThreshholds).boxed().collect(Collectors.toList());
        return temperature >= Collections.min(tempThreshholds);
    }

    public void report(SensorData sensorData, Current current) throws Exception{
    String username = sensorData.username;
    user.sensorData = sensorData;

    if (previouslocationStatus.equals(OUTDOOR) && currentLocationStatus.equals(INDOOR)) {
        resetClock(username);
    }
    if (user.sensorData.aqi != previousaqi) {
        resetClock(username);
        user.apoThreshhold = calculateapoThreshhold(user);
    }
    if (user.sensorData.temperature != previousTemperature) {
        user.tempReached = false;
    }
    if (currentLocationStatus.equals(OUTDOOR)) {
        tickClock(username);
    }

    apoReached = checkapoReached(user);
    tempReached = checkTempReached(user);
    }

    private void tickClock(String username) {
        currentClock++;
    }

    private void resetClock(String username) {
        currentClock = 0;
    }
}
