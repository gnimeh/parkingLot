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
    public void should_parked_car_in_first_parking_lot_and_return_ticket_given_a_parking_guy_has_2_parking_lots_and_the_first_parking_lot_has_carport() {
        ParkingLot firstParkingLot = new ParkingLot(10);
        final ParkingLot secondParkingLot = new ParkingLot(10);
        List<ParkingLot> parkingLots = Arrays.asList(
                firstParkingLot,
                secondParkingLot
        );
        ParkingGuy parkingGuy = new ParkingGuy(parkingLots);
        Car car = new Car();

        Ticket ticket = parkingGuy.parkCar(car);

        Car fetchedCar = firstParkingLot.fetchCar(ticket);
        assertNotNull(ticket);
        assertEquals(car,fetchedCar);
    }

    @Test
    public void should_parked_car_in_second_parking_lot_and_return_ticket_given_a_parking_guy_has_2_parking_lots_and_the_first_parking_lot_is_full_and_the_second_has_carports() {
        ParkingLot firstParkingLot = new ParkingLot(0);
        final ParkingLot secondParkingLot = new ParkingLot(10);
        List<ParkingLot> parkingLots = Arrays.asList(
                firstParkingLot,
                secondParkingLot
        );
        ParkingGuy parkingGuy = new ParkingGuy(parkingLots);
        Car car = new Car();

        Ticket ticket = parkingGuy.parkCar(car);

        Car fetchedCar = secondParkingLot.fetchCar(ticket);
        assertNotNull(ticket);
        assertEquals(car,fetchedCar);
    }
}
