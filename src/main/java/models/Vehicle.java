package models;

import java.util.Random;

public class Vehicle implements PaymentCalculator {
    private int vehicleID;
    private VehicleType vehicleType;
    private int gasTankPercentage;
    private int batteryPercentage;

    Random random = new Random();

    public Vehicle(int vehicleID, VehicleType vehicleType) {
        this.vehicleID = vehicleID;
        this.vehicleType = vehicleType;
        gasTankPercentage = random.ints(0, 101).findFirst().getAsInt();
        batteryPercentage = random.ints(0, 101).findFirst().getAsInt();
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getGasTankPercentage() {
        return gasTankPercentage;
    }

    public void setGasTankPercentage(int gasTankPercentage) {
        this.gasTankPercentage = gasTankPercentage;
    }

    public int getBatteryPercentage() {
        return batteryPercentage;
    }

    public void setBatteryPercentage(int batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }

    @Override
    public String toString() {
        return "Vehicle: \n" +
                "\tvehicle type: " + vehicleType + "\n" +
                "\tgas tank percentage: " + gasTankPercentage + "\n" +
                "\tbattery percentage: " + batteryPercentage + "\n";
    }

    @Override
    public double getPayment() {
        return switch (this.getVehicleType()) {
            case CAR -> 50;
            case VAN -> 80;
            case BUS -> 70;
            case TRUCK -> 90;
        };
    }
}
