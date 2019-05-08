import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private int carportQuantity;
    private List<Car> cars;

    public ParkingLot(int carportQuantity) {
        cars = new ArrayList<>();
        this.carportQuantity = carportQuantity;
    }

    public Ticket parkCar(Car car) {
        if (this.carportQuantity == 0) {
            throw new NoParkingLotCarportException();
        }
        this.carportQuantity--;
        Ticket ticket = new Ticket();
        ticket.setCar(car);
        this.cars.add(car);
        return ticket;
    }

    public Car fetchCar(Ticket ticket) {
        this.carportQuantity++;
        return this.cars.stream().filter(car -> car.equals(ticket.getCar())).findFirst().orElseThrow(TicketCanNotMatchCarException::new);
    }
}
