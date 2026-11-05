
package com.battery;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BatteryMonitorTest {

    @Test
    void testNormalBattery() {
        assertEquals("Normal",
                BatteryMonitor.detectFault(12.0, 2.0, 30.0));
    }

    @Test
    void testOvercharging() {
        assertEquals("Overcharging",
                BatteryMonitor.detectFault(15.0, 2.0, 30.0));
    }

    @Test
    void testDeepDischarge() {
        assertEquals("Deep Discharge",
                BatteryMonitor.detectFault(9.0, 2.0, 30.0));
    }

    @Test
    void testOverCurrent() {
        assertEquals("Over-current",
                BatteryMonitor.detectFault(12.0, 15.0, 30.0));
    }

    @Test
    void testOverTemperature() {
        assertEquals("Over-temperature",
                BatteryMonitor.detectFault(12.0, 2.0, 55.0));
    }

    @Test
    void testSensorFailure() {
        assertEquals("Sensor Failure",
                BatteryMonitor.detectFault(0.0, 2.0, 30.0));
    }
}
