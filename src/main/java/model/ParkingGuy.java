package model;

import exception.NoParkingLotCarportException;

import java.util.List;

public class ParkingGuy {
    private List<ParkingLot> parkingLots;

    public ParkingGuy(List<ParkingLot> parkingLots) {

        this.parkingLots = parkingLots;
    }

    public Ticket parkCar(Car car) {
        for (ParkingLot parkingLot : this.parkingLots) {
            try {
                return parkingLot.parkCar(car);
            } catch (NoParkingLotCarportException ignored) {
            }
        }
        throw new NoParkingLotCarportException();
    }

    public Car fetchCar(Ticket ticket) {
            return parkingLots.get(0).fetchCar(ticket);
    }
}
