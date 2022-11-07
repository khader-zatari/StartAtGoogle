package StartAtGoogle.Farm.Farm;

public class WoodenHorse implements WoodenStructures {
    @Override
    public void roll() {
        System.out.println("roll");
    }

    @Override
    public WoodenStructures replicate() {
        return new WoodenHorse();
    }
}
