package models;

import java.util.List;

public class Terminal implements PaymentCalculator {
    private static Terminal instance;
    private static List<Train> trains;
    private static List<Employee> employees;

    private Terminal() {
    }

    public static Terminal getInstance() {
        if (instance == null) {
            instance = new Terminal();
        }
        return instance;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        Terminal.trains = trains;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        Terminal.employees = employees;
    }

    @Override
    public double getPayment() {
        int incomeSum = 0;
        for (var train : trains) {
            for (Vehicle vehicle : train.getVehicles()) {
                incomeSum += vehicle.getPayment();
            }
        }
        return incomeSum;
    }
}
