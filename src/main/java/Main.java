import models.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Terminal terminal = Terminal.getInstance();

        List<Train> trains = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();

        Train train1 = new Train(TrainType.SMALL);
        train1.addVehicle(new Vehicle(1, VehicleType.CAR));
        train1.addVehicle(new Vehicle(2, VehicleType.VAN));
        trains.add(train1);

        Train train2 = new Train(TrainType.LARGE);
        train2.addVehicle(new Vehicle(3, VehicleType.TRUCK));
        train2.addVehicle(new Vehicle(4, VehicleType.BUS));
        train2.addVehicle(new Vehicle(5, VehicleType.BUS));
        trains.add(train2);

        Employee pero = new Employee("Pero", 10, trains);
        employees.add(pero);

        terminal.setTrains(trains);
        terminal.setEmployees(employees);

        System.out.println();
        System.out.println("Over all income from tickets at terminal is: " + terminal.getPayment() + "€");
        System.out.println();

        for (var train : trains){
            for (Vehicle vehicle : train.getVehicles()) {
                pero.refillGas(vehicle);
            }
        }
        System.out.println();

        Employee jure = new Employee("Jure", 11, trains);
        employees.add(jure);
        terminal.setEmployees(employees);

        for (var e : terminal.getEmployees()) {
            System.out.println("Employee " + e.getName() + " earned total of: " + e.getPayment() + "€");
        }
        System.out.println();

        for (var train : trains){
            for (Vehicle vehicle : train.getVehicles()) {
                jure.chargeBattery(vehicle);
            }
        }
        System.out.println();
    }
}
