package StartAtGoogle.Farm.Farm;

import java.util.concurrent.ThreadLocalRandom;

;

abstract class SkeletalAnimal implements Animal {

    protected final AnimalType animalType;
    protected final Genders gender;
    protected final int id;
    protected final int weight;

    protected SkeletalAnimal(AnimalType animalType) {
        this.animalType = animalType;
        this.gender = Genders.values()[ThreadLocalRandom.current().nextInt(Genders.values().length)];
        this.id = ThreadLocalRandom.current().nextInt(100);
        this.weight = ThreadLocalRandom.current().nextInt(100);
    }

    protected boolean ismatable(SkeletalAnimal partner) {
        return this.gender != partner.gender && this.animalType == partner.animalType ;
    }

    @Override
    public String toString() {
        return "SkeletalAnimal{" +
                "animalType=" + animalType +
                ", gender=" + gender +
                ", id=" + id +
                ", weight=" + weight +
                '}';
    }
}
