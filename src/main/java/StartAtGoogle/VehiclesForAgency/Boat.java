package StartAtGoogle.VehiclesForAgency;

public class Boat implements Vehicle {
    @Override
    public void transport(Passenger passenger) {
        System.out.println(passenger.getName());
    }
}
