package model;

import java.util.List;

public class SmartParkingBoy {
    private List<ParkingLot> parkingLots;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {


        this.parkingLots = parkingLots;
    }

    public Ticket parkCar(Car car) {

        if (parkingLots.get(0).getEmptyCarportQuantity() >= parkingLots.get(1).getEmptyCarportQuantity()) {
            return parkingLots.get(0).parkCar(car);
        } else {
            return parkingLots.get(1).parkCar(car);
        }
    }
}
