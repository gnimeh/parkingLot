package model;

import java.util.List;

public class ParkingGuy {
    private List<ParkingLot> parkingLots;

    public ParkingGuy(List<ParkingLot> parkingLots) {

        this.parkingLots = parkingLots;
    }

    public Ticket parkCar(Car car) {

        return parkingLots.get(0).parkCar(car);
    }
}
