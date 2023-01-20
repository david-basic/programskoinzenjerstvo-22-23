package models;

import java.util.ArrayList;
import java.util.List;

public class Employee implements PaymentCalculator, BatteryCharger, GasFiller {
    private final String name;
    private int paycheckPercentage;
    private double moneyEarned;
    private List<Train> trains;

    public Employee(String name, int paycheckPercentage, List<Train> trains) {
        this.name = name;
        this.paycheckPercentage = paycheckPercentage;
        this.trains = new ArrayList<>(trains);
    }

    public String getName() {
        return name;
    }

    public int getPaycheckPercentage() {
        return paycheckPercentage;
    }

    public void setPaycheckPercentage(int paycheckPercentage) {
        this.paycheckPercentage = paycheckPercentage;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    @Override
    public double getPayment() {
        for (var train : trains) {
            for (Vehicle v : train.getVehicles()) {
                moneyEarned += ((v.getPayment() * paycheckPercentage) / 100);
            }
        }
        return moneyEarned;
    }

    @Override
    public void chargeBattery(Vehicle vehicle) {
        System.out.println("Battery percentage of vehicle " + vehicle.getVehicleID() + " is: " + vehicle.getBatteryPercentage() + "%");
        if (vehicle.getBatteryPercentage() < 10) {
            System.out.println("Battery needs charging!");
            System.out.println("Recharging battery...");
            vehicle.setBatteryPercentage(100);
            System.out.println("Battery is now full!");
        } else {
            System.out.println("Battery doesn't require filling yet.");
        }
        System.out.println();
    }

    @Override
    public void refillGas(Vehicle vehicle) {
        System.out.println("Gas percentage of vehicle " + vehicle.getVehicleID() + " is: " + vehicle.getGasTankPercentage() + "%");
        if (vehicle.getGasTankPercentage() < 10) {
            System.out.println("Gas needs refilling!");
            System.out.println("Refilling gas tank...");
            vehicle.setGasTankPercentage(100);
            System.out.println("Tank is now full!");
        } else {
            System.out.println("Gas tank doesn't require filling yet.");
        }
        System.out.println();
    }
}
