package StartAtGoogle.VehiclesForAgency;

import java.util.*;

public class Agency {
    private List<Vehicle> freeVehicles;
    private List<Vehicle> busyVehicles;
    private final VehicleFactory vehicleFactory = VehicleFactory.getInstance();

    public Agency(int planeCount, int busCount, int taxiCount, int boatCount) {
        freeVehicles = new ArrayList<>();
        busyVehicles = new ArrayList<>();
        createAllVehicles(planeCount, busCount, taxiCount, boatCount);
    }

    private void createAllVehicles(int planeCount, int busCount, int taxiCount, int boatCount) {


        for (int i = 0; i < planeCount; i++) {
            freeVehicles.add(vehicleFactory.createVehicles(VehicleType.PLANE));
        }
        for (int i = 0; i < busCount; i++) {
            freeVehicles.add(vehicleFactory.createVehicles(VehicleType.BUS));
        }
        for (int i = 0; i < taxiCount; i++) {
            freeVehicles.add(vehicleFactory.createVehicles(VehicleType.TAXI));
        }
        for (int i = 0; i < boatCount; i++) {
            freeVehicles.add(vehicleFactory.createVehicles(VehicleType.BOAT));
        }


    }

    public void assignPassenger(Passenger passenger) {
        Class<?> clz;
        switch (passenger.getFavoriteVehicle()) {
            case TAXI:
                clz = Taxi.class;
                break;
            case BUS:
                clz = Bus.class;
                break;
            case BOAT:
                clz = Boat.class;
                break;
            case PLANE:
                clz = Plane.class;
                break;
            default:
                clz = Object.class;
                break;

        }

        for (int i = 0; i < freeVehicles.size(); i++) {
            if (freeVehicles.get(i).getClass().equals(clz)) {
                busyVehicles.add(freeVehicles.get(i));
                freeVehicles.get(i).transport(passenger);
                freeVehicles.remove(freeVehicles.get(i));
                return;
            }
        }
        if (freeVehicles.size() > 0) {
            busyVehicles.add(freeVehicles.get(0));
            freeVehicles.get(0).transport(passenger);
            freeVehicles.remove(freeVehicles.get(0));
        } else {
            throw new NullPointerException("there is not vehicles");
        }

    }

    @Override
    public String toString() {
        return "Agency{" +
                "\nfreeVehicles=" + freeVehicles.toString() +
                "\nbusyVehicles=" + busyVehicles.toString() +
                '}';
    }
}
