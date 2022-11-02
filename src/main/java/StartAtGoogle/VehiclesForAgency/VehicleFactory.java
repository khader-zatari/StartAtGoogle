package StartAtGoogle.VehiclesForAgency;

public class VehicleFactory {
    private static VehicleFactory vehicleFactory;

    private VehicleFactory() {

    }

    public static VehicleFactory getInstance() {
        if (vehicleFactory == null) {
            vehicleFactory = new VehicleFactory();
        }
        return vehicleFactory;
    }

    public Vehicle createVehicles(VehicleType vehicleType) {
        switch (vehicleType) {

            case BOAT:
                return new Boat();
            case BUS:
                return new Bus();
            case PLANE:
                return new Plane();
            case TAXI:
                return new Taxi();
            default:
                throw new IllegalArgumentException("there is no vehicle Type like that");
        }

    }
}
