import exception.NoParkingLotCarportException;
import exception.TicketCanNotMatchCarException;
import model.Car;
import model.ParkingGuy;
import model.ParkingLot;
import model.Ticket;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ParkingGuyTest {
    @Test
    public void should_parked_car_in_first_parking_lot_and_return_ticket_given_a_parking_guy_is_responsible_for_2_parking_lots_and_the_first_parking_lot_has_carport() {
        ParkingLot firstParkingLot = new ParkingLot(10);
        final ParkingLot secondParkingLot = new ParkingLot(10);
        List<ParkingLot> parkingLots = Arrays.asList(
                firstParkingLot,
                secondParkingLot
        );
        ParkingGuy parkingGuy = new ParkingGuy(parkingLots);
        Car car = new Car();

        Ticket ticket = parkingGuy.parkCar(car);

        assertNotNull(ticket);
        assertEquals(car, firstParkingLot.fetchCar(ticket));
    }

    @Test
    public void should_parked_car_in_second_parking_lot_and_return_ticket_given_a_parking_guy_is_responsible_for_2_parking_lots_and_the_first_parking_lot_is_full_and_the_second_has_carports() {
        ParkingLot firstParkingLot = new ParkingLot(0);
        final ParkingLot secondParkingLot = new ParkingLot(10);
        List<ParkingLot> parkingLots = Arrays.asList(
                firstParkingLot,
                secondParkingLot
        );
        ParkingGuy parkingGuy = new ParkingGuy(parkingLots);
        Car car = new Car();

        Ticket ticket = parkingGuy.parkCar(car);

        assertNotNull(ticket);
        assertEquals(car, secondParkingLot.fetchCar(ticket));
    }

    @Test(expected = NoParkingLotCarportException.class)
    public void should_not_park_car_given_a_parking_guy_is_responsible_for_2_parking_lots_and_they_are_full() {
        List<ParkingLot> parkingLots = Arrays.asList(
                new ParkingLot(0),
                new ParkingLot(0)
        );
        ParkingGuy parkingGuy = new ParkingGuy(parkingLots);
        Car car = new Car();

        parkingGuy.parkCar(car);
    }

    @Test
    public void should_fetch_original_car_given_a_parking_guy_is_responsible_for_2_parking_lots_and_the_car_parked_in_first_parking_lot_and_a_ticket_can_match_a_car() {
        ParkingLot firstParkingLot = new ParkingLot(10);
        List<ParkingLot> parkingLots = Arrays.asList(
                firstParkingLot,
                new ParkingLot(10)
        );
        ParkingGuy parkingGuy = new ParkingGuy(parkingLots);
        Car car = new Car();
        Ticket ticket = firstParkingLot.parkCar(car);

        assertEquals(car, parkingGuy.fetchCar(ticket));
    }


    @Test
    public void should_fetch_original_car_given_a_parking_guy_is_responsible_for_2_parking_lots_and_the_car_parked_in_second_parking_lot_and_a_ticket_can_match_a_car() {
        ParkingLot secondParkingLot = new ParkingLot(10);
        List<ParkingLot> parkingLots = Arrays.asList(
                new ParkingLot(10),
                secondParkingLot
        );
        ParkingGuy parkingGuy = new ParkingGuy(parkingLots);
        Car car = new Car();
        Ticket ticket = secondParkingLot.parkCar(car);

        Car fetchedCar = parkingGuy.fetchCar(ticket);

        assertEquals(car, fetchedCar);
    }

    @Test(expected = TicketCanNotMatchCarException.class)
    public void should_not_fetch_car_given_a_parking_guy_is_responsible_for_2_parking_lots_and_a_ticket_can_not_match_a_car() {
        List<ParkingLot> parkingLots = Arrays.asList(
                new ParkingLot(10),
                new ParkingLot(10)
        );
        ParkingGuy parkingGuy = new ParkingGuy(parkingLots);
        Ticket ticket = new Ticket();

        parkingGuy.fetchCar(ticket);
    }

    @Test(expected = TicketCanNotMatchCarException.class)
    public void should_not_fetch_car_given_a_parking_guy_is_responsible_for_2_parking_lots_and_a_ticket_has_been_used_to_fetch_car() {
        List<ParkingLot> parkingLots = Arrays.asList(
                new ParkingLot(10),
                new ParkingLot(10)
        );
        ParkingGuy parkingGuy = new ParkingGuy(parkingLots);
        Ticket ticket = new Ticket();

        parkingGuy.fetchCar(ticket);
    }
}
