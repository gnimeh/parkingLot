import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private int carportQuantity;
    private List<Car> cars;

    public ParkingLot() {
        cars = new ArrayList<>();
    }

    public void setCarportQuantity(int carportQuantity) {
        this.carportQuantity = carportQuantity;
    }

    public int getCarportQuantity() {
        return carportQuantity;
    }

    public Ticket parkCar(Car car) {
        if (this.carportQuantity == 0) {
            throw new NoParkingLotCarportException();
        }
        this.carportQuantity--;
        Ticket ticket = new Ticket();
        ticket.setCarId(car.getId());
        this.cars.add(car);
        return ticket;
    }

    public Car fetchCar(Ticket ticket) {
        this.carportQuantity++;
        return this.cars.stream().filter(car -> car.getId() == ticket.getCarId()).findFirst().orElseThrow(TicketCanNotMatchCarException::new);
    }
}
