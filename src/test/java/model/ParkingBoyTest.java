package model;

import exception.TicketCanNotMatchCarException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ParkingBoyTest {
    @Test
    public void should_fetch_original_car_given_a_parking_boy_is_responsible_for_2_parking_lots_and_the_car_parked_in_first_parking_lot_and_a_ticket_can_match_a_car() {
        ParkingLot firstParkingLot = new ParkingLot(10);
        List<ParkingLot> parkingLots = Arrays.asList(
                firstParkingLot,
                new ParkingLot(10)
        );
        ParkingBoy parkingBoy = createParkingBoy(parkingLots);
        Car car = new Car();
        Ticket ticket = firstParkingLot.parkCar(car);

        assertEquals(car, parkingBoy.fetchCar(ticket));
    }

    @Test
    public void should_fetch_original_car_given_a_parking_boy_is_responsible_for_2_parking_lots_and_the_car_parked_in_second_parking_lot_and_a_ticket_can_match_a_car() {
        ParkingLot secondParkingLot = new ParkingLot(10);
        List<ParkingLot> parkingLots = Arrays.asList(
                new ParkingLot(10),
                secondParkingLot
        );
        ParkingBoy parkingBoy = createParkingBoy(parkingLots);
        Car car = new Car();
        Ticket ticket = secondParkingLot.parkCar(car);

        Car fetchedCar = parkingBoy.fetchCar(ticket);

        assertEquals(car, fetchedCar);
    }

    @Test(expected = TicketCanNotMatchCarException.class)
    public void should_not_fetch_car_given_a_parking_boy_is_responsible_for_2_parking_lots_and_a_ticket_can_not_match_a_car() {
        List<ParkingLot> parkingLots = Arrays.asList(
                new ParkingLot(10),
                new ParkingLot(10)
        );
        ParkingBoy parkingBoy = createParkingBoy(parkingLots);
        Ticket ticket = new Ticket();

        parkingBoy.fetchCar(ticket);
    }

    @Test(expected = TicketCanNotMatchCarException.class)
    public void should_not_fetch_car_given_a_parking_boy_is_responsible_for_2_parking_lots_and_a_ticket_has_been_used_to_fetch_car() {
        List<ParkingLot> parkingLots = Arrays.asList(
                new ParkingLot(10),
                new ParkingLot(10)
        );
        ParkingBoy parkingBoy = createParkingBoy(parkingLots);
        Ticket ticket = new Ticket();

        parkingBoy.fetchCar(ticket);
    }

    private ParkingBoy createParkingBoy(List<ParkingLot> parkingLots) {
        return new ParkingBoy(parkingLots) {
            @Override
            public Ticket parkCar(Car car) {
                return null;
            }
        };
    }

}