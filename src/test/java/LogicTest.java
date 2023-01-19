import models.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    @Test
    @DisplayName("Test adding vehicle to a train.")
    public void testAddVehicleToTrain() {
        Train train = new Train(TrainType.SMALL);
        Vehicle expected = new Vehicle(1, VehicleType.CAR);

        train.addVehicle(expected);

        Vehicle actual = train.getVehicles().get(0);

        assertSame(expected, actual);
    }

    @Test
    @DisplayName("Test to get Terminal income.")
    public void testGetTerminalIncome() {
        Terminal terminal = Terminal.getInstance();
        List<Train> trains = new ArrayList<>();
        Train t1 = new Train(TrainType.SMALL);
        t1.addVehicle(new Vehicle(1, VehicleType.CAR));
        t1.addVehicle(new Vehicle(2, VehicleType.VAN));
        t1.addVehicle(new Vehicle(3, VehicleType.TRUCK));
        t1.addVehicle(new Vehicle(4, VehicleType.BUS));
        t1.addVehicle(new Vehicle(5, VehicleType.BUS));
        trains.add(t1);
        terminal.setTrains(trains);

        double expected = 360;
        double actual = terminal.getPayment();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test to get vehicle charge by type.")
    public void testGetVehicleChargeByType() {
        Vehicle vehicle = new Vehicle(1, VehicleType.CAR);

        double expected = 50;
        double actual = vehicle.getPayment();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test to get employee payment")
    public void testGetEmployeePayment() {
        List<Train> trains = new ArrayList<>();
        Train t1 = new Train(TrainType.SMALL);
        t1.addVehicle(new Vehicle(1, VehicleType.CAR));
        t1.addVehicle(new Vehicle(2, VehicleType.VAN));
        t1.addVehicle(new Vehicle(3, VehicleType.TRUCK));
        t1.addVehicle(new Vehicle(4, VehicleType.BUS));
        t1.addVehicle(new Vehicle(5, VehicleType.BUS));
        trains.add(t1);
        Employee employee = new Employee("Pero", 10, trains);

        double actual = employee.getPayment();
        double expected = 36;

        assertEquals(expected, actual);
    }
}
