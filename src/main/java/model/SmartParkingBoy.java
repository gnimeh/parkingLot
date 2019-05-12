package model;

import java.util.List;

public class SmartParkingBoy {
    private List<ParkingLot> parkingLots;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {


        this.parkingLots = parkingLots;
    }

    public Ticket parkCar(Car car) {

        return parkingLots.get(0).parkCar(car);
    }
}
