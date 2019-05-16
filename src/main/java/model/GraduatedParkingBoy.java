package model;

import exception.NoParkingLotCarportException;

import java.util.List;

public class GraduatedParkingBoy extends ParkingBoy {

    public GraduatedParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket parkCar(Car car) {
        for (ParkingLot parkingLot : this.parkingLots) {
            try {
                return parkingLot.parkCar(car);
            } catch (NoParkingLotCarportException ignored) {
            }
        }
        throw new NoParkingLotCarportException();
    }
}
