package StartAtGoogle.Farm.Farm;

 class Cat extends SkeletalAnimal {
    public Cat() {
        super(AnimalType.CAT);
    }

    @Override
    public void move() {
        System.out.println("The cat moves");
    }

    @Override
    public Animal mate(Animal partner) {

        if (ismatable((SkeletalAnimal) partner)) {
            return new Cat();
        }
        return null;
    }

}
