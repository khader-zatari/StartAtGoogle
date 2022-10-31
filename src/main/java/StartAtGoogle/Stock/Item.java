package StartAtGoogle.Stock;

import java.time.LocalDate;

public class Item implements Comparable {
    private final String name;
    private final ProductTypes productType;
    private final LocalDate expirationDate;
    private final double weight;

    public Item(String name, ProductTypes productType, LocalDate expirationDate, double weight) {
        this.name = name;
        this.productType = productType;
        this.expirationDate = expirationDate;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public ProductTypes getProductType() {
        return productType;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "\nItem{" +
                "name='" + name + '\'' +
                ", productType=" + productType +
                ", expirationDate=" + expirationDate +
                ", weight=" + weight +
                "}";
    }
//you should do it.
    @Override
    public int compareTo(Object o) {
        return 0;
    }

    //could be here random name, weight, .. not in stock, make it public static function.

}
