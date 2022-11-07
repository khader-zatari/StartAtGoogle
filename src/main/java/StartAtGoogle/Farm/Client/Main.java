package StartAtGoogle.Farm.Client;


import StartAtGoogle.Farm.Farm.AnimalType;
import StartAtGoogle.Farm.Farm.Farmer;
import StartAtGoogle.Farm.Farm.WoodenHorse;
import StartAtGoogle.Farm.Farm.WoodenStructureAdapter;

public class Main {
    public static void main(String[] args) {
//        Farmer farmer = new Farmer();
//        farmer.move(1);
//        System.out.println(farmer.requestAnimal(AnimalType.CAT));
//        System.out.println(farmer.aquire(AnimalType.DOG));
//        System.out.println(farmer.mate(AnimalType.DOG));
        WoodenStructureAdapter woodenStructureAdapter = new WoodenStructureAdapter(new WoodenHorse());
        woodenStructureAdapter.move();
        woodenStructureAdapter.mate(new WoodenStructureAdapter(new WoodenHorse()));


    }
}
