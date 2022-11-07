package StartAtGoogle.Farm.Farm;

public class WoodenStructureAdapter implements Animal {
    WoodenStructures woodenStructures;

    public WoodenStructureAdapter(WoodenStructures woodenStructures) {
        this.woodenStructures = woodenStructures;
    }

    @Override
    public void move() {
        woodenStructures.roll();

    }

    @Override
    public Animal mate(Animal partner) {
        woodenStructures.replicate();
        return null;
    }
}
