package model;

import exception.NoParkingLotCarportException;
import exception.TicketCanNotMatchCarException;

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
        for (ParkingLot parkingLot : this.parkingLots) {
            try {
                return parkingLot.fetchCar(ticket);
            } catch (TicketCanNotMatchCarException ignored) {
            }
        }
        throw new TicketCanNotMatchCarException();
    }
}
