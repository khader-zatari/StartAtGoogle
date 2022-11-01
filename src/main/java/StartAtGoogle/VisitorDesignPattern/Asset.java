package StartAtGoogle.VisitorDesignPattern;

public class Asset implements Data {
    private final int serialNumber;
    private final String owner;
    private final double rating;

    public Asset(int serialNumber, String owner, double rating) {
        this.serialNumber = serialNumber;
        this.owner = owner;
        this.rating = rating;
    }

    @Override
    public void exportToJson(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Asset{" +
                "serialNumber=" + serialNumber +
                ", owner='" + owner + '\'' +
                ", rating=" + rating +
                '}';
    }
}
