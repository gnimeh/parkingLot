package model;

import exception.TicketCanNotMatchCarException;

import java.util.List;

public abstract class ParkingBoy {

    protected List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public abstract Ticket parkCar(Car car);

    public Car fetchCar(Ticket ticket) {
        for (ParkingLot parkingLot : this.parkingLots) {
            try {
                return parkingLot.fetchCar(ticket);
            } catch (TicketCanNotMatchCarException ignored) {
            }
        }
        throw new TicketCanNotMatchCarException();
    }
}
