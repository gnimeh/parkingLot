import exception.NoParkingLotCarportException;
import exception.TicketCanNotMatchCarException;
import model.Car;
import model.GraduatedParkingBoy;
import model.ParkingLot;
import model.Ticket;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GraduatedParkingBoyTest {
    @Test
    public void should_parked_car_in_first_parking_lot_and_return_ticket_given_a_graduated_parking_boy_is_responsible_for_2_parking_lots_and_the_first_parking_lot_has_carport() {
        ParkingLot firstParkingLot = new ParkingLot(10);
        final ParkingLot secondParkingLot = new ParkingLot(10);
        List<ParkingLot> parkingLots = Arrays.asList(
                firstParkingLot,
                secondParkingLot
        );
        GraduatedParkingBoy graduatedParkingBoy = new GraduatedParkingBoy(parkingLots);
        Car car = new Car();

        Ticket ticket = graduatedParkingBoy.parkCar(car);

        assertNotNull(ticket);
        assertEquals(car, firstParkingLot.fetchCar(ticket));
    }

    @Test
    public void should_parked_car_in_second_parking_lot_and_return_ticket_given_a_graduated_parking_boy_is_responsible_for_2_parking_lots_and_the_first_parking_lot_is_full_and_the_second_has_carports() {
        ParkingLot firstParkingLot = new ParkingLot(0);
        final ParkingLot secondParkingLot = new ParkingLot(10);
        List<ParkingLot> parkingLots = Arrays.asList(
                firstParkingLot,
                secondParkingLot
        );
        GraduatedParkingBoy graduatedParkingBoy = new GraduatedParkingBoy(parkingLots);
        Car car = new Car();

        Ticket ticket = graduatedParkingBoy.parkCar(car);

        assertNotNull(ticket);
        assertEquals(car, secondParkingLot.fetchCar(ticket));
    }

    @Test(expected = NoParkingLotCarportException.class)
    public void should_not_park_car_given_a_graduated_parking_boy_is_responsible_for_2_parking_lots_and_they_are_full() {
        List<ParkingLot> parkingLots = Arrays.asList(
                new ParkingLot(0),
                new ParkingLot(0)
        );
        GraduatedParkingBoy graduatedParkingBoy = new GraduatedParkingBoy(parkingLots);
        Car car = new Car();

        graduatedParkingBoy.parkCar(car);
    }
}
