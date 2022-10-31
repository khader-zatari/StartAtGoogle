package StartAtGoogle.Stock;

public class Main {
    public static void main(String[] args) {
        //stock class has list of generated items., generate random data method to play with it.
        //items should be sorted by expiration data by default. -> it has a function compare to -> Collections.sort(items) default comperator for item
        //
        Stock stock = new Stock();
        stock.generateRandomItems(10);
        System.out.println(stock);
        System.out.println("====================");
//        List list = stock.expireItems();
//        List list = stock.alphabetSort();
//        List list = stock.aboveWeight(5);
//        Map<ProductTypes, Long> list = stock.countStock();
//        System.out.println(list);
        System.out.println("====================");
//        Optional<Item> item = stock.getName("khader");
//        Optional<Item> item = stock.closeExpireDate();
//        System.out.println(item);
    }
}
