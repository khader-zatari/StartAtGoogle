package StartAtGoogle.VehiclesForAgency;

public class Passenger {
    private final String name;
    private final VehicleType favoriteVehicle;

    public Passenger(String name, VehicleType favoriteVehicle) {
        this.name = name;
        this.favoriteVehicle = favoriteVehicle;
    }

    public VehicleType getFavoriteVehicle() {
        return favoriteVehicle;
    }

    public String getName() {
        return name;
    }
}
