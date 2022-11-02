package StartAtGoogle.VehiclesForAgency;

public class Main {
    public static void main(String[] args) {
        Passenger passenger1 = new Passenger("kahder", VehicleType.PLANE);
        Passenger passenger2 = new Passenger("Haitham", VehicleType.PLANE);
        Passenger passenger3 = new Passenger("yazan", VehicleType.BOAT);
        Agency agency = new Agency(1, 4, 8, 3);
        agency.assignPassenger(passenger1);
        agency.assignPassenger(passenger2);
        agency.assignPassenger(passenger3);

//        agency.assignPassenger(passenger1);
//        agency.assignPassenger(passenger1);
//        agency.assignPassenger(passenger1);
//        agency.assignPassenger(passenger1);
//        agency.assignPassenger(passenger1);
//        agency.assignPassenger(passenger1);
//        agency.assignPassenger(passenger1);



        System.out.println(agency);

    }
}
