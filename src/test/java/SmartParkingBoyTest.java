import model.Car;
import model.ParkingLot;
import model.SmartParkingBoy;
import model.Ticket;
import org.junit.Test;

import java.util.Arrays;

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
}