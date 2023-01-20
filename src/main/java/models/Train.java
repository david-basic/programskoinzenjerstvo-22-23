package models;

import java.util.ArrayList;
import java.util.List;

public class Train implements Transporter{
    private TrainType trainType;
    private final Integer capacity;
    private List<Vehicle> vehicles = new ArrayList<>();

    public Train(TrainType trainType) {
        this.trainType = trainType;
        if (trainType.equals(TrainType.SMALL)) {
            capacity = 8;
        } else {
            capacity = 6;
        }
    }

    public TrainType getTrainType() {
        return trainType;
    }

    public void setTrainType(TrainType trainType) {
        this.trainType = trainType;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
}
