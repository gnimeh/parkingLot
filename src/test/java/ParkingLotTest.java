import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkingLotTest {
    @Test
    public void should_return_parking_lot_with_carports_given_a_parking_lot_and_quantity_of_carport_when_parking_lot_set_carports() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setCarportQuantity(10);
        assertEquals(10, parkingLot.getCarportQuantity());
    }

    @Test
    public void should_return_ticket_and_parking_lot_carport_quantity_minus_one_given_one_car_and_parking_lot_when_parking() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setCarportQuantity(10);
        Car car = new Car();
        Ticket ticket = parkingLot.parkCar(car);
        assertEquals(9, parkingLot.getCarportQuantity());
        assertEquals(ticket.getCarId(), car.getId());
    }


    @Test(expected = NoParkingLotCarportException.class)
    public void should_not_parking_car_given_one_car_and_parking_lot_carport_quantity_is_0_when_parking() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setCarportQuantity(0);
        Car car = new Car();
        parkingLot.parkCar(car);
    }

    @Test
    public void should_return_car_and_parking_lot_carport_quantity_plus_one_given_one_ticket_and_parking_lot_when_fetch_car() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setCarportQuantity(10);
        Car car = new Car();
        car.setId(1);
        Ticket ticket = parkingLot.parkCar(car);
        Car fetchedCar = parkingLot.fetchCar(ticket);
        assertEquals(fetchedCar.getId(), ticket.getCarId());
        assertEquals(10, parkingLot.getCarportQuantity());
    }


    @Test(expected = TicketCanNotMatchCarException.class)
    public void should_not_fetch_car_when_ticket_can_not_match_any_car() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setCarportQuantity(10);
        Car car = new Car();
        car.setId(1);
        parkingLot.parkCar(car);
        Ticket ticket = new Ticket();
        ticket.setCarId(2);
        parkingLot.fetchCar(ticket);
    }

}
