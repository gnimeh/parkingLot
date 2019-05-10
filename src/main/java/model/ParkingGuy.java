package model;

import exception.NoParkingLotCarportException;

import java.util.List;

public class ParkingGuy {
    private List<ParkingLot> parkingLots;

    public ParkingGuy(List<ParkingLot> parkingLots) {

        this.parkingLots = parkingLots;
    }

    public Ticket parkCar(Car car) {
        Ticket ticket = null;
        for (ParkingLot parkingLot: this.parkingLots) {
            try {
                ticket = parkingLot.parkCar(car);
            } catch (NoParkingLotCarportException ignored) {
            }
        }
        return ticket;
    }
}
