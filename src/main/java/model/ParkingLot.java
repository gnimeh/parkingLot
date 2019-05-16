package model;

import exception.NoParkingLotCarportException;
import exception.TicketCanNotMatchCarException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int emptyCarportQuantity;
    private Map<Ticket, Car> carMap;

    public ParkingLot(int emptyCarportQuantity) {
        this.carMap = new HashMap<>();
        this.emptyCarportQuantity = emptyCarportQuantity;
    }

    public Ticket parkCar(Car car) {
        if (this.emptyCarportQuantity == 0) {
            throw new NoParkingLotCarportException();
        }
        this.emptyCarportQuantity--;
        Ticket ticket = new Ticket();
        this.carMap.put(ticket, car);
        return ticket;
    }

    public Car fetchCar(Ticket ticket) {
        this.emptyCarportQuantity++;
        if (!carMap.containsKey(ticket)) {
            throw new TicketCanNotMatchCarException();
        }
        Car car = this.carMap.get(ticket);
        this.carMap.remove(ticket);
        return car;
    }

    public int getEmptyCarportQuantity() {
        return emptyCarportQuantity;
    }
}
