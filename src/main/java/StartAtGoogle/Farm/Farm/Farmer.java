package StartAtGoogle.Farm.Farm;

public class Farmer {
    Farm farm;

    public Farmer() {
        this.farm = new Farm(5);
    }

    public void move(int id) {
        for (SkeletalAnimal a : farm.farmAnimals) {
            if (a.id == id) {
                a.move();
                break;
            }
        }
        farm.farmAnimals.get(0).move();
    }

    public Animal requestAnimal(AnimalType animalType) {

        Animal animal = farm.provideAnimal(animalType);
        return animal;
    }

    public Animal aquire(AnimalType animalType) {
        return farm.aquire(animalType);
    }

    public Animal mate(AnimalType animalType) {
        return farm.mate(animalType);
    }
}
