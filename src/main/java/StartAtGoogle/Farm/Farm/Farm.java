package StartAtGoogle.Farm.Farm;

import java.util.ArrayList;
import java.util.List;

class Farm {


    List<SkeletalAnimal> farmAnimals;

    public Farm(int numberOfAnimals) {
        farmAnimals = new ArrayList<>();
        generateRandomAnimals(numberOfAnimals);
    }

    public void generateRandomAnimals(int number) {
        for (int i = 0; i < number; i++) {
            farmAnimals.add(new Cat());
            farmAnimals.add(new Dog());
            farmAnimals.add(new Cow());
        }
    }

    public Animal provideAnimal(AnimalType animalType) {
        for (int i = 0; i < farmAnimals.size(); i++) {
            if (farmAnimals.get(i).animalType == animalType) {
                Animal a = farmAnimals.get(i);
                farmAnimals.remove(i);
                return a;
            }
        }
        return null;
    }

    public Animal aquire(AnimalType animalType) {

        switch (animalType) {
            case CAT:
                return new Cat();
            case COW:
                return new Cow();
            case DOG:
                return new Dog();
            default:
                return null;
        }

    }

    public Animal mate(AnimalType animalType) {
        for (int i = 0; i < farmAnimals.size(); i++) {
            for (int j = 0; j < farmAnimals.size(); j++) {
                if (farmAnimals.get(i).animalType == animalType && farmAnimals.get(j).animalType == animalType) {
                    if (farmAnimals.get(i).ismatable(farmAnimals.get(j))) {
                        System.out.println("\nthis two lines is the mated animals");
                        System.out.println(farmAnimals.get(i));
                        System.out.println(farmAnimals.get(j));
                        System.out.println("\n");
                        SkeletalAnimal newAnimal = (SkeletalAnimal) farmAnimals.get(i).mate(farmAnimals.get(j));
                        farmAnimals.add(newAnimal);
                        return newAnimal;
                    }
                }
            }
        }
        return null;
    }
}
