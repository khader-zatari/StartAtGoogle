package StartAtGoogle.VisitorDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Data> dataList = new ArrayList<>();
        dataList.add(new User(1, "khader", "password123"));
        dataList.add(new Group(1, 10));
        dataList.add(new Asset(123, "khader", 4.3));
        ExportToJsonVisitor jsonVisitor = new ExportToJsonVisitor();
        for (Data data : dataList) {
            data.exportToJson(jsonVisitor);
        }
    }
}
