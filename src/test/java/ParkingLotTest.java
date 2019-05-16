import exception.NoParkingLotCarportException;
import exception.TicketCanNotMatchCarException;
import model.Car;
import model.ParkingLot;
import model.Ticket;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkingLotTest {

    @Test
    public void should_return_ticket_and_parking_lot_given_one_car_and_parking_lot_when_parking() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();

        Ticket ticket = parkingLot.parkCar(car);

        assertEquals(car, parkingLot.fetchCar(ticket));
    }


    @Test(expected = NoParkingLotCarportException.class)
    public void should_not_parking_car_given_one_car_and_parking_lot_empty_carport_quantity_is_0_when_parking() {
        ParkingLot parkingLot = new ParkingLot(0);
        Car car = new Car();

        parkingLot.parkCar(car);
    }

    @Test
    public void should_return_car_given_one_ticket_and_parking_lot_when_fetch_car() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        Ticket ticket = parkingLot.parkCar(car);

        Car fetchedCar = parkingLot.fetchCar(ticket);

        assertEquals(fetchedCar, car);
    }


    @Test(expected = TicketCanNotMatchCarException.class)
    public void should_not_fetch_car_given_ticket_can_not_match_any_car_when_fetch_car() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        parkingLot.parkCar(car);
        Ticket ticket = new Ticket();

        parkingLot.fetchCar(ticket);
    }

}
