import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkingLotTest {

    @Test
    public void should_return_ticket_and_parking_lot_carport_quantity_minus_one_given_one_car_and_parking_lot_when_parking() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        Ticket ticket = parkingLot.parkCar(car);
        assertEquals(ticket.getCar(), car);
    }


    @Test(expected = NoParkingLotCarportException.class)
    public void should_not_parking_car_given_one_car_and_parking_lot_carport_quantity_is_0_when_parking() {
        ParkingLot parkingLot = new ParkingLot(0);
        Car car = new Car();
        parkingLot.parkCar(car);
    }

    @Test
    public void should_return_car_and_parking_lot_carport_quantity_plus_one_given_one_ticket_and_parking_lot_when_fetch_car() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        Ticket ticket = parkingLot.parkCar(car);
        Car fetchedCar = parkingLot.fetchCar(ticket);
        assertEquals(fetchedCar, car);
    }


    @Test(expected = TicketCanNotMatchCarException.class)
    public void should_not_fetch_car_when_ticket_can_not_match_any_car() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        parkingLot.parkCar(car);
        Ticket ticket = new Ticket();
        parkingLot.fetchCar(ticket);
    }

}
