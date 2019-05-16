package model;

import exception.TicketCanNotMatchCarException;

import java.util.List;

public class SmartParkingBoy {
    private List<ParkingLot> parkingLots;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {


        this.parkingLots = parkingLots;
    }

    public Ticket parkCar(Car car) {
        ParkingLot parkingLotWithMaxEmptyCarport = parkingLots.stream().reduce(new ParkingLot(0), (maxCarportQuantityParkingLot, current) -> {
            if (maxCarportQuantityParkingLot.getEmptyCarportQuantity() >= current.getEmptyCarportQuantity()) {
                return maxCarportQuantityParkingLot;
            } else {
                return current;
            }
        });
        return parkingLotWithMaxEmptyCarport.parkCar(car);
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
