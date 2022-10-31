package StartAtGoogle.Stock;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Stock {
    private List<Item> itemList;

    public Stock() {
        this.itemList = new ArrayList<>();
    }

    private void generateItem() {
        String name = ThreadLocalRandom.current().nextDouble(1) > 0.5 ? "khader" : "zatari";
        ProductTypes productType = ProductTypes.values()[ThreadLocalRandom.current().nextInt(ProductTypes.values().length)];

        long minDay = LocalDate.of(2022, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2023, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        LocalDate expireDate = LocalDate.ofEpochDay(randomDay);

        double weight = ThreadLocalRandom.current().nextDouble(15);
        Item item = new Item(name, productType, expireDate, weight);
        this.itemList.add(item);
//        itemList.sort(Comparator.comparing(Item::getExpirationDate));
        this.itemList = this.itemList.stream().sorted(Comparator.comparing(Item::getExpirationDate)).collect(Collectors.toList());

    }

    public void generateRandomItems(int numberOfItems) {
        while (numberOfItems > 0) {
            generateItem();
            numberOfItems--;
        }
    }

    public List<Item> expireItems() {
        return this.itemList.stream().filter(item -> (item.getExpirationDate().toEpochDay() - LocalDate.now().toEpochDay()) < 0).collect(Collectors.toList());
    }

    public Optional<Item> closeExpireDate() {
        return this.itemList.stream().sorted(Comparator.comparing(Item::getExpirationDate)).filter(item -> (item.getExpirationDate().toEpochDay() - LocalDate.now().toEpochDay() > 0)).findFirst();
    }

    public List<Item> alphabetSort() {
//        return this.itemList.stream().sorted((item1, item2) -> item1.getName().compareTo(item2.getName())).collect(Collectors.toList());
        return this.itemList.stream().sorted(Comparator.comparing(Item::getName)).collect(Collectors.toList());
    }

    public Optional<Item> getName(String name) {
        return this.itemList.stream().filter(item -> item.getName().equals(name)).findFirst();
    }

    public List<String> aboveWeight(double weight) {
//        return this.itemList.stream().filter(item -> item.getWeight() > weight).map(item -> item.getName()).collect(Collectors.toList());
        return this.itemList.stream().filter(item -> item.getWeight() > weight).map(Item::getName).collect(Collectors.toList());
    }

    public Map<ProductTypes, Long> countStock() {
        return this.itemList.stream().collect(Collectors.groupingBy(Item::getProductType, Collectors.counting()));
    }

    @Override
    public String toString() {
        return "Stock{" +
                "itemList=" + Arrays.toString(itemList.toArray()) +
                '}';
    }
}
