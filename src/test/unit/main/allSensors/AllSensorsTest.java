package test.unit.main.allSensors;

import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Exception;
import helper.MonitorPrx;
import main.AllSensors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.omg.SendingContext.RunTime;
import support.Sensor;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class AllSensorsTest {
    private String username;
    private boolean signal;
    private Sensor locationSensor;
    private Sensor temperatureSensor;
    private Sensor aqiSensor;
    private Communicator communicator;
    private MonitorPrx monitor;

    public AllSensorsTest(String username, boolean signal, Sensor locationSensor, Sensor temperatureSensor, Sensor aqiSensor, Communicator communicator, MonitorPrx monitor) {
        this.username = username;
        this.signal = signal;
        this.locationSensor = locationSensor;
        this.temperatureSensor = temperatureSensor;
        this.aqiSensor = aqiSensor;
        this.communicator = communicator;
        this.monitor = monitor;
    }
}