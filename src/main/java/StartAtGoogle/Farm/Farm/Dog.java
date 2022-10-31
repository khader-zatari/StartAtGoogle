package StartAtGoogle.Farm.Farm;

class Dog extends SkeletalAnimal {
    public Dog() {
        super(AnimalType.DOG);
    }

    @Override
    public void move() {
        System.out.println("The Dog moves");
    }

    @Override
    public Animal mate(Animal partner) {
        if (ismatable((SkeletalAnimal) partner)) {
            return new Dog();
        }
        return null;
    }

}
