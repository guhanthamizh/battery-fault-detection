
package com.battery;

public class BatteryMonitor {

    public static void main(String[] args) {

        double voltage = 12.0;
        double current = 15.0;
        double temperature = 30.0;

        System.out.println("BATTERY FAULT DETECTION SYSTEM!");
        System.out.println("--------------------------------");

        System.out.println("Voltage: " + voltage + " V");
        System.out.println("Current: " + current + " A");
        System.out.println("Temperature: " + temperature + " C");

        System.out.println("--------------------------------");

        String status = detectFault(
            voltage, current, temperature
        );

        System.out.println("Battery Status: " + status);
    }

    public static String detectFault(
            double voltage, double current, double temperature) {

        // Check sensor failure
        if (!Double.isFinite(voltage) ||
            !Double.isFinite(current) ||
            !Double.isFinite(temperature) ||
            voltage <= 0 || current < 0 ||
            temperature < -40 || temperature > 125) {

            return "Sensor Failure";
        }

        // Check overcharging
        if (voltage > 14.4) {
            return "Overcharging";
        }

        // Check deep discharge
        if (voltage < 10.5) {
            return "Deep Discharge";
        }

        // Check over-current
        if (current > 10.0) {
            return "Over-current";
        }

        // Check over-temperature
        if (temperature > 45.0) {
            return "Over-temperature";
        }

        return "Normal";
    }
}
