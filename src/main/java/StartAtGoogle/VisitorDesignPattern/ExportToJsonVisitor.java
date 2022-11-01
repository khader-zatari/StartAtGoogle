package StartAtGoogle.VisitorDesignPattern;

import com.google.gson.Gson;

public class ExportToJsonVisitor implements Visitor {
    @Override
    public void visit(Data data) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(data);
        System.out.println(jsonString);

    }
}
