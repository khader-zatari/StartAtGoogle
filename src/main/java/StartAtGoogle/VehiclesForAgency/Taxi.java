package StartAtGoogle.VehiclesForAgency;

public class Taxi implements Vehicle{
    @Override
    public void transport(Passenger passenger) {
        System.out.println(passenger.getName());
    }
}
