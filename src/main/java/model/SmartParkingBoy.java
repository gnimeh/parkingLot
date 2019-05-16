package model;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
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
}
