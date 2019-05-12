package model;

import exception.NoParkingLotCarportException;
import exception.TicketCanNotMatchCarException;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private int emptyCarportQuantity;
    private List<Car> cars;

    public ParkingLot(int emptyCarportQuantity) {
        cars = new ArrayList<>();
        this.emptyCarportQuantity = emptyCarportQuantity;
    }

    public Ticket parkCar(Car car) {
        if (this.emptyCarportQuantity == 0) {
            throw new NoParkingLotCarportException();
        }
        this.emptyCarportQuantity--;
        Ticket ticket = new Ticket();
        ticket.setCar(car);
        this.cars.add(car);
        return ticket;
    }

    public Car fetchCar(Ticket ticket) {
        this.emptyCarportQuantity++;
        return this.cars.stream().filter(car -> car.equals(ticket.getCar())).findFirst().orElseThrow(TicketCanNotMatchCarException::new);
    }

    public int getEmptyCarportQuantity() {
        return emptyCarportQuantity;
    }
}
