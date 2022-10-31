package StartAtGoogle.Farm.Farm;

 class Cow extends SkeletalAnimal {
    public Cow() {
        super(AnimalType.COW);
    }

    @Override
    public void move() {
        System.out.println("The Cow moves");
    }

    @Override
    public Animal mate(Animal partner) {
        if (ismatable((SkeletalAnimal) partner)) {
            return new Cow();
        }
        return null;
    }

}
