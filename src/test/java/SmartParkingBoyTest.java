import exception.NoParkingLotCarportException;
import model.Car;
import model.ParkingGuy;
import model.ParkingLot;
import model.SmartParkingBoy;
import model.Ticket;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SmartParkingBoyTest {
    @Test
    public void should_park_car_in_first_parking_lot_and_get_ticket_given_a_smart_parking_boy_and_two_not_full_parking_lots_and_the_first_parking_lot_has_more_empty_carport_than_the_second_when_smart_parking_boy_park_car() {
        ParkingLot firstParkingLot = new ParkingLot(10000);
        ParkingLot secondParkingLot = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));
        Car car = new Car();

        Ticket ticket = smartParkingBoy.parkCar(car);

        assertNotNull(ticket);
        Car fetchedCar = firstParkingLot.fetchCar(ticket);
        assertEquals(car, fetchedCar);
    }

    @Test
    public void should_park_car_in_second_parking_lot_and_get_ticket_given_a_smart_parking_boy_and_two_not_full_parking_lots_and_the_first_parking_lot_has_less_empty_carport_than_the_second_when_smart_parking_boy_park_car() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(100);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));
        Car car = new Car();

        Ticket ticket = smartParkingBoy.parkCar(car);

        assertNotNull(ticket);
        Car fetchedCar = secondParkingLot.fetchCar(ticket);
        assertEquals(car, fetchedCar);
    }


    @Test
    public void should_park_car_in_second_parking_lot_and_get_ticket_given_a_smart_parking_boy_and_two_not_full_parking_lots_and_the_first_parking_lot_has_same_empty_carport_when_smart_parking_boy_parking_car() {
        ParkingLot firstParkingLot = new ParkingLot(10);
        ParkingLot secondParkingLot = new ParkingLot(10);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));
        Car car = new Car();

        Ticket ticket = smartParkingBoy.parkCar(car);

        assertNotNull(ticket);
        Car fetchedCar = firstParkingLot.fetchCar(ticket);
        assertEquals(car, fetchedCar);
    }


    @Test(expected = NoParkingLotCarportException.class)
    public void should_not_park_car_given_a_smart_parking_boy_and_two_full_parking_lots_and_when_smart_parking_boy_parking_car() {
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(
                new ParkingLot(0),
                new ParkingLot(0)));
        Car car = new Car();

        smartParkingBoy.parkCar(car);
    }

    @Test
    public void should_fetch_original_car_given_a_smart_parking_boy_is_responsible_for_2_parking_lots_and_the_car_parked_in_first_parking_lot_and_a_ticket_can_match_a_car() {
        ParkingLot firstParkingLot = new ParkingLot(10);
        List<ParkingLot> parkingLots = Arrays.asList(
                firstParkingLot,
                new ParkingLot(10)
        );
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();
        Ticket ticket = firstParkingLot.parkCar(car);

        assertEquals(car, smartParkingBoy.fetchCar(ticket));
    }
}
