package test.unit.main.allSensors;

import com.zeroc.Ice.Exception;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestStop {
    // This is void method
    private boolean signal;

    public TestStop() {
        this.signal = false;
    }

    @Test
    public void testStop() throws Exception {
        TestStop testStop = new TestStop();
        if(testStop.signal){
            Integer num = 0;
            assertEquals((long)0, (long)num);
        }
    }
}
